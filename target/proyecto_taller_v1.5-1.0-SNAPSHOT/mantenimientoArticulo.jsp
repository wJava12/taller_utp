<%@ page import="com.java.service.ArticuloService" %>
<%@ page import="com.java.service.impl.ArticuloServiceImpl" %>
<%@ page import="com.java.Model.entidades.Articulo" %>
<%@ page import="java.util.List" %><%--
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

<jsp:include page="Header.jsp"/>      
<%
ArticuloService ser = new ArticuloServiceImpl();
                    List<Articulo> list=ser.mostrar();
%>
<script src="js/BuscarPersonal.js" type="text/javascript"></script>

<div class="container">
      <div class="text-center mt-4">
                                        <h1 class="h4 text-gray-900 mb-4">MANTENIMIENTO DE REPUESTOS</h1>
                                    </div>
    <div class="d-flex justify-content-between ml-3 mr-3">
        
        <div class="d-inline-block">
                   <a href="registerArticulo.jsp" class="btn btn-success" name="registrarse" id="registrarse">Crear Articulo</a>
            </div>
        <div class="d-inline-block">
        
           
             <input class="form-control mr-sm-2" id="searchTerm" onkeyup="doSearch()"type="text" placeholder="Buscar">
             
            
           </div>
    </div>
 
 <div class="table-responsive col-md-12">
     <hr/>
     <table class="table table-striped table-de " id="datos">
            <thead class="thead-dark">
                <tr>
                    <th>Codigo</th>
                    <th>Nombres</th>
                    <th>Cantidad</th>
                    <th>Precio</th>
                    
                    <th><div class="d-flex justify-content-center">
                               Operacion
                          </div></th>
                  
                </tr>
            </thead>
            <tbody>

                
                
                
                    <%

                  
                    if(list != null)
                    {
                            for(Articulo aux : list)
                            {
                               
                    %>
                    <tr>
                        <td ><%= aux.getIdArticulo()%></td>
                        <td ><%= aux.getNombre()%></td>
                        <td ><%= aux.getCantidad()%></td>
                        <td ><%= aux.getPrecio()%></td>
                        
                        
                      <td>
                          <div class="d-flex justify-content-center">
                               <a href="jsp/ActualizarArticulo.jsp?codigo=<%=aux.getIdArticulo()%>" class="btn btn-success btn-sm mr-2">Actualizar</a>
                        <a href="EliminarArticulo.jsp?codigo=<%=aux.getIdArticulo()%>" class="btn btn-danger btn-sm">Eliminar</a>
                       
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
