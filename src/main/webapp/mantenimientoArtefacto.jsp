<%@ page import="com.java.service.ArticuloService" %>
<%@ page import="com.java.service.impl.ArticuloServiceImpl" %>
<%@ page import="com.java.Model.entidades.Articulo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.service.ClienteService" %>
<%@ page import="com.java.service.impl.ClienteServiceImpl" %>
<%@ page import="com.java.Model.entidades.Cliente" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="com.java.service.impl.ElectrodomesticoServiceImpl" %>
<%@ page import="com.java.service.ElectrodomesticoService" %>
<%@ page import="com.java.Model.entidades.Electrodomestico" %><%--
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
ElectrodomesticoService ser = new ElectrodomesticoServiceImpl();
                    List<Electrodomestico> list=ser.mostrar();
%>
<script src="js/BuscarPersonal.js" type="text/javascript"></script>

<div class="container">
      <div class="text-center mt-4">
                                        <h1 class="h4 text-gray-900 mb-4">MANTENIMIENTO DE ELECTRODOMESTICOS</h1>
                                    </div>
    <div class="d-flex justify-content-between ml-3 mr-3">
        
        <div class="d-inline-block">
                   <a href="registerElectro.jsp" class="btn btn-success" name="registrarse" id="registrarse">Crear Electrodomestico</a>
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
                    <th>Nombre</th>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Serie</th>
                    <th>Descricion</th>
                    <th>Cliente</th>
                    <th>Dni</th>
                    <th>Operacion</th>
                </tr>
            </thead>
            <tbody>
                    <%
                    if(list != null)
                    {
                            for(Electrodomestico aux : list)
                            {
                    %>
                    <tr>
                        <td ><%= aux.getIdElectr()%></td>
                        <td ><%= aux.getNombre()%></td>
                        <td ><%= aux.getMarca()%></td>
                        <td ><%= aux.getModelo()%></td>
                        <td ><%= aux.getSerie()%></td>
                        <td ><%= aux.getDescripcion()%></td>
                        <td ><%= aux.getCliente().getNombre() + " "+ aux.getCliente().getApelldos()%></td>
                        <td ><%= aux.getCliente().getDni()%></td>
                      <td>
                          <div class="d-flex justify-content-center">
                               <a href="ActualizarElectrodomestico.jsp?codigo=<%=aux.getIdElectr()%>" class="btn btn-success btn-sm mr-2">Actualizar</a>
                        <a href="electroMan?tipo=eliminar_electro&idcod=<%=aux.getIdElectr()%>" class="btn btn-danger" id="myBtn" onclick="javascript:if(!confirm('Desea Eliminar: ?')) return false">Eliminar</a>
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
