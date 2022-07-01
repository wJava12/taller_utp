package com.java.Controller;

import com.java.Model.entidades.Cargo;
import com.java.Model.entidades.Personal;
import com.java.service.CargoService;
import com.java.service.PersonalService;
import com.java.service.impl.CargoServiceImpl;
import com.java.service.impl.PersonalServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletPersonal", value = "/personalMan")
public class ServletPersonal extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strTipo=request.getParameter("tipo");
        System.out.println("tipo"+strTipo);

            PersonalService objPersonalService = new PersonalServiceImpl();
            CargoService objCargoService=new CargoServiceImpl();
             Integer strCodigo;
            try {
                if(strTipo.equals("registrar_personal")){

                    //Captura los parametros que llegan de la Web.
                    String nombres = request.getParameter("txtNombre");
                    String apellidos = request.getParameter("txtApellido");
                    String telefono = request.getParameter("txtTelefono");
                    String direccion = request.getParameter("txtDireccion");
                    String dni= request.getParameter("txtDni");
                    String correo = request.getParameter("txtCorreo");
                    String usuario = request.getParameter("txtUsuario");
                    String clave = request.getParameter("txtClave");
                    String cargo = request.getParameter("cargo");
                    Cargo objCargo=objCargoService.bucarPorNombre(cargo);

                    //Llena el Bean
                    Personal personal = new Personal(nombres, apellidos, direccion, dni, telefono, correo, usuario, clave, objCargo);

                    //Inserta el Bean.
                    objPersonalService.insertar(personal);

                }else if (strTipo.equals("actualizar_personal")){
                    int cod = Integer.parseInt(request.getParameter("txtId"));
                    //Captura los parametros que llegan de la Web.
                    String nombres = request.getParameter("txtNombre");
                    String apellidos = request.getParameter("txtApellido");
                    String telefono = request.getParameter("txtTelefono");
                    String direccion = request.getParameter("txtDireccion");
                    String dni= request.getParameter("txtDni");
                    String correo = request.getParameter("txtCorreo");
                    String usuario = request.getParameter("txtUsuario");
                    String clave = request.getParameter("txtClave");
                    String cargo = request.getParameter("cargo");
                    String horario = request.getParameter("horario");

                    Cargo objCargo=objCargoService.bucarPorNombre(cargo);

                    //Llena el Bean
                    Personal personal2 = new Personal(nombres, apellidos, direccion, dni, telefono, correo, usuario, clave, objCargo);
                    personal2.setIdPersonal(cod);

                    //Actualizar Bean
                    objPersonalService.actualizar(personal2);

                }else if(strTipo.equals("eliminar_personal")){
                    int cod = Integer.parseInt(request.getParameter("idcod"));
                    System.out.println("codigo: "+cod);
                    objPersonalService.cambiarEstado(cod,0);
                }

                response.sendRedirect("PersonalMsg.jsp");

            }catch(Exception e){
                response.sendRedirect("AlumnoError.jsp");
            }
    }
}
