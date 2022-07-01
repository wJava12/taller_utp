package com.java.Controller;

import com.java.Model.entidades.Cargo;
import com.java.Model.entidades.Cliente;
import com.java.service.CargoService;
import com.java.service.ClienteService;
import com.java.service.impl.CargoServiceImpl;
import com.java.service.impl.ClienteServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ServletLogeo", value = "/clienteLogeo")
public class ServletLogeo extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strTipo=request.getParameter("tipo");
        System.out.println("tipo: "+strTipo);

            ClienteService objClienteService=new ClienteServiceImpl();
            CargoService objCargoService= new CargoServiceImpl();
            try {

                    if(strTipo.equals("registrar_cliente")){
                        String dni= request.getParameter("txtDni");
                        Cliente cliente1=objClienteService.mostrarClientePorDni(dni);
                        if(cliente1==null){
                            //Captura los parametros que llegan de la Web.
                            String nombres = request.getParameter("txtNombre");
                            String apellidos = request.getParameter("txtApellido");
                            String telefono = request.getParameter("txtTelefono");
                            String direccion = request.getParameter("txtDireccion");
                            String correo = request.getParameter("txtCorreo");
                            String usuario = request.getParameter("txtUsuario");
                            String clave = request.getParameter("txtClave");
                            Cargo objCargo=objCargoService.bucarPorNombre("CLIENTE");

                            //Llena el Bean
                            Cliente cliente = new Cliente(nombres,apellidos,dni,direccion,telefono,correo,usuario,clave,objCargo);
                            //Inserta el Bean.
                            objClienteService.insertar(cliente);
                            RequestDispatcher destinos=request.getRequestDispatcher("index.html");
                            destinos.forward(request, response);
                        }else {
                            RequestDispatcher destinos=request.getRequestDispatcher("ClientError.jsp");
                            destinos.forward(request, response);
                        }

                    }


            }catch(Exception e){
                Logger.getLogger(ServletLogeo.class.getName()).log(Level.SEVERE, null, e);
                //response.sendRedirect("ClienteError.jsp");
            }
    }
}
