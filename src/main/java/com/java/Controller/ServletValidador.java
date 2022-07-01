package com.java.Controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.Model.entidades.Cliente;
import com.java.Model.entidades.Personal;
import com.java.service.ClienteService;
import com.java.service.PersonalService;
import com.java.service.impl.ClienteServiceImpl;
import com.java.service.impl.PersonalServiceImpl;


@WebServlet(name = "ServletValidador", value = "/sValidador")
public class ServletValidador extends HttpServlet {

    private static final long serialVersionUID = 1L;
    PersonalService servicio = new PersonalServiceImpl();
    ClienteService clienteServicio= new ClienteServiceImpl();
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
      @Override
      protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String recibe=request.getParameter("destinos");
                              
      
            System.out.println("heoos"+recibe);
        
        RequestDispatcher destinos=request.getRequestDispatcher(acceso);
        destinos.forward(request, response);
    }
 
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String us = request.getParameter("txtUsuario");
        String ps = request.getParameter("txtPassword");

        
        Personal administrador = servicio.validar(us, ps);
        System.out.println(administrador);
        HttpSession sesion = request.getSession();

        if(administrador!=null){
            sesion.setAttribute("strAdmNombre", administrador.getNombre()+" "+administrador.getApellidos());
            sesion.setAttribute("strAdmCodigo",administrador.getIdPersonal());
            sesion.setAttribute("strCargo",administrador.getCargo().getNombre());
            response.sendRedirect("Principal.jsp");
        }else{
            Cliente cliente =clienteServicio.validar(us,ps);
            if(cliente!=null){
                sesion.setAttribute("strAdmNombre", cliente.getNombre()+" "+cliente.getApelldos());
                sesion.setAttribute("strAdmCodigo",cliente.getIdCLiente());
                sesion.setAttribute("strCargo",cliente.getCargo().getNombre());
                response.sendRedirect("Principal.jsp");
            }else{
                response.sendRedirect("error.jsp");
            }

        }
    }
    


    


}
