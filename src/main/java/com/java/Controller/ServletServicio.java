package com.java.Controller;

import com.java.Model.entidades.*;
import com.java.service.*;
import com.java.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletServicio", value = "/servicioMan")
public class ServletServicio extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strTipo = request.getParameter("tipo");
        System.out.println("tipo de servicio: " + strTipo);
        HttpSession sesion = request.getSession();
        ElectrodomesticoService objEletroService= new ElectrodomesticoServiceImpl();
        TipoElectroServiceImpl objTipoElectroService = new TipoElectroServiceImpl();
        HorarioTecnicoService objHorarioTecnicoService = new HorarioTecnicoServiceImpl();
        ClienteService objClienteService= new ClienteServiceImpl();
        TipoServicioService objTipoServicioService= new TipoServicioServiceImpl();
        ServicioService objServicioService= new ServicioServiceImpl();
        PersonalService objPersonal= new PersonalServiceImpl();
        Integer strCodigo;
        try {
            if (strTipo.equals("registrar_servicio")) {

                int idPersonal=Integer.parseInt(request.getParameter("idPersonal"));
                int cod = Integer.parseInt(request.getParameter("idTec"));
                System.out.println("codigo: " + cod);
                            System.out.println("Entreeee");
                //Parametrizar Cliente
                String fecha = request.getParameter("txtFecha");
                String hora = request.getParameter("txtHora");
                int tipoSer= Integer.parseInt(request.getParameter("tipoServicio"));

                String nombre = request.getParameter("txtNombre");
                String apellido = request.getParameter("txtApellido");
                String dni = request.getParameter("txtDni");
                String telefono = request.getParameter("txtTelefono");
                String direccion = request.getParameter("txtDireccion");
                String correo = request.getParameter("txtCorreo");

                //Parametrizar Electrodomestico con Tipo
                String nombreElectro = request.getParameter("txtNombreElectro");
                String marca = request.getParameter("txtMarca");
                String modelo = request.getParameter("txtModelo");
                String serie = request.getParameter("txtSerie");
                int tipo = Integer.parseInt(request.getParameter("tipoElectro"));;
                String descripcion = request.getParameter("txtDescripcion");

                //Creando bean cliente e insertando en la BD
                Cliente objCliente = new Cliente();
                objClienteService.insertar(objCliente);


                //Mostrar el ultimo id cliente
                objCliente.setIdCLiente(objClienteService.mostrarIdCliente());

                //Creando bean electrodomestico con tipo
                Electrodomestico objElectro = new Electrodomestico(nombreElectro, marca, modelo, serie, objTipoElectroService.buscar(tipo), descripcion,objCliente);

                //Insertando electrodomestico en la BD
                objEletroService.insertar(objElectro);
                objElectro.setIdElectr(objEletroService.mostrarIdElectro());



                HorarioTecnico objHorarioTecnico=objHorarioTecnicoService.buscar(cod);
                TipoServicio objTipoServicio=objTipoServicioService.buscar(tipoSer);
                objHorarioTecnico.setEstado(0);
                System.out.println(objHorarioTecnico + " "+objTipoServicio);
                objHorarioTecnicoService.actualizar(objHorarioTecnico);

                //Creando bean Servicio
                Servicio objservicio= new Servicio(fecha,hora,objTipoServicio.getPrecio(),descripcion,"Telefono",objElectro,objTipoServicio);
                            objservicio.setHorarioTecnico(objHorarioTecnico);
                            objservicio.setPersonal(objPersonal.buscar(idPersonal));
                objServicioService.insertar(objservicio);
                response.sendRedirect("ArticuloMsg.jsp");

                //System.out.println(fecha + hora + nombre + apellido + telefono + direccion);
                //System.out.println(nombreElectro + marca + modelo + serie + tipo + descripcion);
            }else if (strTipo.equals("mostrar_tecnico_servicio")){
                int idTecnico =Integer.parseInt(request.getParameter("enviarIdTecnico"));
                String dia =request.getParameter("valueDia");
                String hora =request.getParameter("valueHora");
                String mes =request.getParameter("mesEntrada");

                System.out.println(idTecnico);
                System.out.println("mes:"+mes);
                System.out.println("dia:"+dia);
                System.out.println("hora:"+hora);
                System.out.println();
                request.setAttribute("strMes",mes);
                request.setAttribute("strDia",dia);
                request.setAttribute("strHora",hora);
                request.setAttribute("strId",idTecnico);
                request.getRequestDispatcher("registerElectro2.jsp").forward(request, response);

            }



        } catch (Exception e) {
            response.sendRedirect("ArticuloError.jsp");
        }
    }
}
