package com.java.Controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.java.Model.entidades.Articulo;
import com.java.Model.entidades.Cliente;
import com.java.Model.entidades.Electrodomestico;
import com.java.Model.entidades.TipoElectro;
import com.java.service.*;
import com.java.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@WebServlet(name = "ServletElectro", value = "/electroMan")
public class ServletElectro extends HttpServlet {

    private Gson gson= new Gson();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strTipo=request.getParameter("tipo");
        System.out.println("tipo"+strTipo);

            ClienteService objClienteService = new ClienteServiceImpl();
            TipoElectroService objTipoService= new TipoElectroServiceImpl();
            ElectrodomesticoService objElectroService= new ElectrodomesticoServiceImpl();
            try {
                if(strTipo.equals("buscar_cliente")){
                    String dni = request.getParameter("idcod");

                    Cliente cliente=objClienteService.mostrarClientePorDni(dni);
                    System.out.println(cliente);
                    String json=gson.toJson(cliente);
                    //Type listType= new TypeToken<Cliente>(){}.getType();
                    response.getWriter().println(json);

                //response.sendRedirect("ArticuloMsg.jsp");
                }else if(strTipo.equals("registrar_electro")){
                    String dni = request.getParameter("txtDni");
                    String nombre = request.getParameter("txtNombre");
                    String marca = request.getParameter("txtMarca");
                    String serie = request.getParameter("txtSerie");
                    String modelo = request.getParameter("txtModelo");
                    int tipo = Integer.parseInt(request.getParameter("tipoElectro"));
                    String descripcion = request.getParameter("txtDescripcion");
                    Cliente cliente=objClienteService.mostrarClientePorDni(dni);
                    TipoElectro tipoEl=objTipoService.buscar(tipo);

                    Electrodomestico objElectr= new Electrodomestico(nombre,marca,modelo,serie,tipoEl,descripcion,cliente);
                    objElectroService.insertar(objElectr);
                    response.sendRedirect("ElectroMsg.jsp");
                }
               // response.sendRedirect("ElectroMsg.jsp");
            }catch(Exception e){
                response.sendRedirect("ArticuloError.jsp");
            }
    }
}
