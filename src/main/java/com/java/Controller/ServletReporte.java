package com.java.Controller;



import com.java.util.Reporteador;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servletReporte", value = "/reporte")
public class ServletReporte extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {response.setContentType(CONTENT_TYPE);
        
        Reporteador reporteador = new Reporteador();
        reporteador.generaPDF("cjava",getServletContext());
        response.sendRedirect("reporte.pdf");
    }
}
