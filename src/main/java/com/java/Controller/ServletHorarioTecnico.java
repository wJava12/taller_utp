package com.java.Controller;

import com.java.Model.entidades.Articulo;
import com.java.Model.entidades.Horario;
import com.java.Model.entidades.HorarioTecnico;
import com.java.Model.entidades.Tecnico;
import com.java.service.*;
import com.java.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletHorarioTecnico", value = "/horarioTecnicoMan")
public class ServletHorarioTecnico extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strTipo=request.getParameter("tipo");
        System.out.println("tipo"+strTipo);

            TecnicoService objTecnicoService= new TecnicoServiceImpl();
            HorarioTecnicoService objHoraTecnicoService = new HorarioTecnicoServiceImpl();
            HorarioService horarioService= new HorarioServiceImpl();

            try {
                if(strTipo.equals("registrar_horarioTecnico")){

                    String fecha=request.getParameter("txtFecha");
                    String diaEntrada=request.getParameter("diaEntrada");
                    String diaSalida=request.getParameter("diaSalida");
                    String horaEntrada=request.getParameter("txtHoraEntrada");
                    String horaSalida=request.getParameter("txtHoraSalida");
                    String horaAlmuerzo= request.getParameter("txtHoraAlmuerzo");
                    String[] tecnicos = request.getParameterValues("tecnicos");
                    Horario objHorario= new Horario(fecha,horaEntrada,horaSalida,diaEntrada,diaSalida,horaAlmuerzo);

                    horarioService.insertar(objHorario);
                    objHorario.setIdHorario(horarioService.mostrarIdHorario());

                    for (String tecnico : tecnicos) {
                        Tecnico tec= objTecnicoService.buscar(Integer.parseInt(tecnico));
                        System.out.println(tec);
                        HorarioTecnico obj= new HorarioTecnico(objHorario, tec);
                        objTecnicoService.cambiarEstadoTecnico(tec.getIdTecnico(),0);
                        objHoraTecnicoService.insertar(obj);
                    }

                }
                response.sendRedirect("HorarioTecnicoMsg.jsp");

            }catch(Exception e){
                response.sendRedirect("ArticuloError.jsp");
            }
    }
}
