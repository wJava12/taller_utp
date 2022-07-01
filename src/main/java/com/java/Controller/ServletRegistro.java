package com.java.Controller;




import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.java.Model.entidades.*;
import com.java.service.*;
import com.java.service.impl.*;

import javax.servlet.RequestDispatcher;


@WebServlet(name = "ServletRegistro", value = "/sRegistrar")
public class ServletRegistro extends HttpServlet {

    private static final long serialVersionUID = 1L;



 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
 
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
         String operacion=request.getParameter("operacion");
         System.out.println(operacion);

    }



}
