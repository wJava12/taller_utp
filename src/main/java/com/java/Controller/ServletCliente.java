package com.java.Controller;

import com.java.Model.entidades.Cargo;
import com.java.Model.entidades.Cliente;
import com.java.Model.entidades.Personal;
import com.java.Model.entidades.Tecnico;
import com.java.service.CargoService;
import com.java.service.ClienteService;
import com.java.service.TecnicoService;
import com.java.service.impl.CargoServiceImpl;
import com.java.service.impl.ClienteServiceImpl;
import com.java.service.impl.TecnicoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletCliente", value = "/clienteMan")
public class ServletCliente extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strTipo=request.getParameter("tipo");
        System.out.println("tipo: "+strTipo);

        String mensaje="";
            ClienteService objClienteService=new ClienteServiceImpl();
            CargoService objCargoService= new CargoServiceImpl();
            try {
                if(strTipo.equals("buscar_cliente")){

                    //Captura los parametros que llegan de la Web.
                    String dni =request.getParameter("txtBuscar");
                    System.out.println(dni);
                    Cliente cliente=  objClienteService.mostrarClientePorDni(dni);
                    System.out.println(cliente);
                    request.setAttribute("cliente",cliente);
                    request.getRequestDispatcher("ServicioDomicilio.jsp").forward(request,response);
                }else if(strTipo.equals("registrar_cliente")){
                        String dni= request.getParameter("txtDni");
                        Cliente cliente1=objClienteService.mostrarClientePorDni(dni);
                        System.out.println(dni);
                        if(cliente1==null){
                        //Captura los parametros que llegan de la Web.
                        String nombres = request.getParameter("txtNombre");
                        String apellidos = request.getParameter("txtApellido");
                        String telefono = request.getParameter("txtTelefono");
                        String direccion = request.getParameter("txtDireccion");

                        String correo = request.getParameter("txtCorreo");
                        String usuario = request.getParameter("txtUsuario");
                        String clave = request.getParameter("txtClave");
                        String cargo = request.getParameter("cargo");
                        Cargo objCargo=objCargoService.bucarPorNombre(cargo);

                        //Llena el Bean
                        Cliente cliente = new Cliente(nombres,apellidos,dni,direccion,telefono,correo,usuario,clave,objCargo);
                        //Inserta el Bean.
                        objClienteService.insertar(cliente);
                        mensaje="Creado con exito";

                        }else{
                            mensaje="Dni ya existe";
                        }

                }else if(strTipo.equals("actualizar_cliente")){
                    String dni= request.getParameter("txtDni");
                    Integer id= Integer.parseInt(request.getParameter("txtId"));
                    Cliente cliente1= new Cliente();
                    cliente1=objClienteService.mostrarClientePorDni(dni);
                    System.out.println("actualizar: "+cliente1);

                        //Captura los parametros que llegan de la Web.
                        String nombres = request.getParameter("txtNombre");
                        String apellidos = request.getParameter("txtApellido");
                        String telefono = request.getParameter("txtTelefono");
                        String direccion = request.getParameter("txtDireccion");

                        String correo = request.getParameter("txtCorreo");
                        String usuario = request.getParameter("txtUsuario");
                        String clave = request.getParameter("txtClave");

                        if(cliente1!=null){
                            //Llena el Bean
                            System.out.println("Sin dni");
                            Cliente cliente = new Cliente(nombres,apellidos,direccion,telefono,correo,usuario,clave);
                            //Inserta el Bean.
                            cliente.setIdCLiente(id);
                            objClienteService.actualizarSinDni(cliente);
                        }else{
                            Cliente cliente = new Cliente(nombres,apellidos,dni,direccion,telefono,correo,usuario,clave);
                            //Inserta el Bean.
                            System.out.println("con dni");
                            cliente.setIdCLiente(id);
                            objClienteService.actualizar(cliente);
                        }

                        mensaje="Actualizado con exito";


                }else if(strTipo.equals("eliminar_cliente")){
                    int cod = Integer.parseInt(request.getParameter("idcod"));
                    System.out.println("codigo: "+cod);
                    objClienteService.cambiarEstado(cod,0);
                    mensaje="Eliminado con exito";
                }
                request.getSession().setAttribute("mensaje", mensaje);
                request.getRequestDispatcher("ClienteMsg.jsp").forward(request, response);

            }catch(Exception e){
                response.sendRedirect("ClienteError.jsp");
            }
    }
}
