package com.java.Controller;

import com.java.Model.entidades.Articulo;
import com.java.Model.entidades.Cargo;
import com.java.Model.entidades.Tecnico;
import com.java.service.ArticuloService;
import com.java.service.CargoService;
import com.java.service.PersonalService;
import com.java.service.TecnicoService;
import com.java.service.impl.ArticuloServiceImpl;
import com.java.service.impl.CargoServiceImpl;
import com.java.service.impl.PersonalServiceImpl;
import com.java.service.impl.TecnicoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletArticulo", value = "/articuloMan")
public class ServletArticulo extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strTipo=request.getParameter("tipo");
        System.out.println("tipo"+strTipo);

            PersonalService objPersonalService = new PersonalServiceImpl();
            CargoService objCargoService=new CargoServiceImpl();
            TecnicoService objTecnicoService= new TecnicoServiceImpl();
            ArticuloService objArticuloService= new ArticuloServiceImpl();
             Integer strCodigo;
            try {
                if(strTipo.equals("registrar_articulo")){

                    //Declaracion de variables
                    String nombre = request.getParameter("txtNombre");
                    int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                    Double precio = Double.parseDouble(request.getParameter("txtPrecio"));

                    //llenado de bean
                    Articulo articulo = new Articulo(nombre, cantidad, precio);

                    //registro de bean
                    objArticuloService.insertar(articulo);

                }else if (strTipo.equals("actualizar_articulo")){
                    //Inicializar parametros
                    int cod = Integer.parseInt(request.getParameter("txtId"));
                    String nombre = request.getParameter("txtNombre");
                    int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                    Double precio = Double.parseDouble(request.getParameter("txtPrecio"));

                    //llenar bean
                    Articulo articulo = new Articulo(nombre, cantidad, precio);
                    articulo.setIdArticulo(cod);

                    //actualizar bean
                    objArticuloService.actualizar(articulo);

                }else if(strTipo.equals("eliminar_articulo")){
                    int cod = Integer.parseInt(request.getParameter("txtId"));
                    System.out.println(cod);
                    objArticuloService.eliminar(cod);
                }

                response.sendRedirect("ArticuloMsg.jsp");

            }catch(Exception e){
                response.sendRedirect("ArticuloError.jsp");
            }
    }
}
