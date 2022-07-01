package com.java.Controller;


import com.google.gson.Gson;
import com.java.Model.entidades.Horario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.MINUTES;

@WebServlet(name = "ServletHorario", value = "/horMan")
public class ServletHorario extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strTipo=request.getParameter("tipo");
        System.out.println("tipo"+strTipo);
        Gson gson= new Gson();

        if (strTipo.equals("calcular")){
            String fecha=request.getParameter("fecha");
            String horaEntrada=request.getParameter("he");
            String horaSalida=request.getParameter("hs");
            String diaInicio=request.getParameter("dI");
            String diaFin=request.getParameter("dF");

            Horario objHorario= new Horario();
            objHorario.setHorarioEntrada(horaEntrada);
            objHorario.setHoraSalida(horaSalida);

            String json=gson.toJson(objHorario.getCalculoHoras());
            // PrintWriter out = response.getWriter();
            //  out.println("<h1>" + json + "</h1>");
            response.getWriter().println(json);
        }



    }
}
