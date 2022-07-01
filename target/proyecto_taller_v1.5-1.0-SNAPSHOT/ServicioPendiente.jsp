<%-- 
    Document   : mantenimientoPersonal
    Created on : 29 may. 2022, 10:15:14
    Author     : 
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    if(request.getSession().getAttribute("strAdmCodigo")==null){
        response.sendRedirect("index.html");
    }
%>


<%@page import="java.util.List"%>
<%@ page import="com.java.service.ServicioService" %>
<%@ page import="com.java.service.impl.ServicioServiceImpl" %>
<%@ page import="com.java.Model.entidades.Servicio" %>

<jsp:include page="Header.jsp"/>      
<%
ServicioService ser = new ServicioServiceImpl();
                    List<Servicio> list=ser.mostrar();
                    
%>
<script src="js/BuscarPersonal.js" type="text/javascript"></script>

<div class="container">
      <div class="text-center mt-4">
                                        <h1 class="h4 text-gray-900 mb-4">SERVICIOS PENDIENTES</h1>
                                    </div>
    <div class="d-flex justify-content-between ml-3 mr-3">
        
        <div class="d-inline-block">
                   <a href="reporte" class="btn btn-success" target="_blank">PDF</a>
            </div>
        <div class="d-inline-block">
        
           
             <input class="form-control mr-sm-2" id="searchTerm" onkeyup="doSearch()"type="text" placeholder="Buscar">
             
            
           </div>
    </div>
 
 <div class="table-responsive col-md-12">
     <hr/>
     <table class="table table-striped table " id="datos">
            <thead class="thead-dark">
                <tr>
                    <th>Codigo</th>
                    <th>Fecha y Hora</th>
                    <th>Cliente</th>
                    <th>Electrodomestico</th>
                    <th>Observacion</th>
                    <th>Tecnico</th>
                    <th>Estado</th>
                    <th><div class="d-flex justify-content-center">
                               Operacion
                          </div></th>
                  
                </tr>
            </thead>
            <tbody>

                
                
                
                    <%

                  
                    if(list != null)
                    {
                            for(Servicio aux : list)
                            {
                            
                               
                    %>
                    <tr>
                        <td ><%= aux.getIdServicio()%></td>
                        <td ><%= aux.getFecha()+"-"+aux.getHora()%></td>
                        <td ><%= aux.getElectrodomestico().getCliente().getNombre()+" "+ aux.getElectrodomestico().getCliente().getApelldos()%></td>
                        <td ><%= aux.getElectrodomestico().getNombre()%></td>
                        <td ><%= aux.getElectrodomestico().getDescripcion()%></td>
                        <td ><%= aux.getHorarioTecnico().getTecnico().getNombre()+" "+aux.getHorarioTecnico().getTecnico().getApellido()%></td>
                        <td >pendiente</td>

                        
                        
                      <td>
                          <div class="d-flex justify-content-center">
                               <a href="DespacharServicio.jsp?codigo=<%=aux.getIdServicio()%>" class="btn btn-success btn-sm mr-2">Despachar</a>
                        <a href="DespacharServicio.jsp?codigo=<%=aux.getIdServicio()%>" class="btn btn-danger btn-sm">Eliminar</a>
                       
                          </div>
                      </td>
                       

                    </tr>


                    <%      }

                    } %>	
                 

            </tbody>
            
        </table>
         <nav aria-label="Page navigation example">
                 <ul class="pagination">
                      <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                      <%
                          for (int x = 0; x < 2; x++) {%>
                                  <li class="page-item"><a class="page-link" href="#"> <%= x+1%> </a></li>

                             <% }
                      %>
         
                      <li class="page-item"><a class="page-link" href="#">Next</a></li>
                  </ul>
       </nav>
    </div>

    
</div>


 
 <jsp:include page="Footer.jsp"/>      
