package com.java.Controller;

import com.google.gson.Gson;
import com.java.Model.entidades.*;
import com.java.service.*;
import com.java.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletTecnico", value = "/tecnicoMan")
public class ServletTecnico extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strTipo=request.getParameter("tipo");
        System.out.println("tipo "+strTipo);


            CargoService objCargoService=new CargoServiceImpl();
            TecnicoService objTecnicoService= new TecnicoServiceImpl();
        EspecialidadService objEspecialidadService= new EspecialidadServiceImpl();
        EspecialidadTecnicoService objEspecialidadTecnico= new EspecialidadTecnicoServiceImpl();
        Gson gson= new Gson();
             Integer strCodigo;
            try {if(strTipo.equals("buscar_tecnico")){
                String dni = request.getParameter("idcod");
                System.out.println("codigo: "+dni);
                Tecnico tecnico=objTecnicoService.buscarPorDni(dni);
                System.out.println(tecnico);
                String json=gson.toJson(tecnico);
                //Type listType= new TypeToken<Cliente>(){}.getType();
                response.getWriter().println(json);
            }else


                if(strTipo.equals("registrar_tecnico")){

                    //Captura los parametros que llegan de la Web.
                    String nombres = request.getParameter("txtNombre");
                    String apellidos = request.getParameter("txtApellido");
                    String telefono = request.getParameter("txtTelefono");
                    String dni = request.getParameter("txtDni");
                    String correo = request.getParameter("txtCorreo");
                    System.out.println(correo);
                    String[] especialidades = request.getParameterValues("especialidades");
                    String experiencia = request.getParameter("txtExperiencia");
                    String usuario = request.getParameter("txtUsuario");
                    String clave = request.getParameter("txtClave");
                    String cargo = request.getParameter("cargo");

                    Cargo objCargo=objCargoService.bucarPorNombre(cargo);

                    //Llena el Bean
                    Tecnico tecnico = new Tecnico(nombres, apellidos,dni, telefono, correo, experiencia, usuario, clave, objCargo);

                    //Inserta el Bean.
                    objTecnicoService.insertar(tecnico);
                    tecnico.setIdTecnico(objTecnicoService.mostrarIdTecnico());
                    for (String espe : especialidades) {
                        System.out.println("Entre a especialidadsse");
                        Especialidad objE=objEspecialidadService.buscar(Integer.parseInt(espe));
                        System.out.println(espe);
                        EspecialidadTecnico obj= new EspecialidadTecnico( tecnico,objE);
                        objEspecialidadTecnico.insertar(obj);

                    }
                    response.sendRedirect("TecnicoMsg.jsp");
                }else if (strTipo.equals("actualizar_tecnico")){
                    int cod = Integer.parseInt(request.getParameter("txtId"));
                    System.out.println("codigo: "+cod);

                    String nombres = request.getParameter("txtNombre");
                    String apellidos = request.getParameter("txtApellido");
                    String dni = request.getParameter("txtDni");
                    String telefono = request.getParameter("txtTelefono");
                    String correo = request.getParameter("txtCorreo");
                    String expecialidad= request.getParameter("txtEspecialidad");
                    String experiencia = request.getParameter("txtExperiencia");
                    String usuario = request.getParameter("txtUsuario");
                    String clave = request.getParameter("txtClave");
                    String cargo = request.getParameter("cargo");


                    Cargo objCargo=objCargoService.bucarPorNombre(cargo);

                    Tecnico tecnico = new Tecnico(nombres, apellidos,dni, telefono, correo,  experiencia, usuario, clave, objCargo);

                    System.out.println(tecnico);
                    tecnico.setIdTecnico(cod);
                    objTecnicoService.actualizar(tecnico);
                    response.sendRedirect("TecnicoMsg.jsp");

                }else if(strTipo.equals("eliminar_tecnico")){
                    int cod = Integer.parseInt(request.getParameter("txtId"));
                    System.out.println("codigo: "+cod);
                    objTecnicoService.cambiarEstado(cod,0);
                    response.sendRedirect("TecnicoMsg.jsp");
                }


            }catch(Exception e){
                response.sendRedirect("TecnicoError.jsp");
            }
    }
}
