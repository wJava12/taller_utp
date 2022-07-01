<%@ page import="com.java.service.ArticuloService" %>
<%@ page import="com.java.service.impl.ArticuloServiceImpl" %>
<%@ page import="com.java.Model.entidades.Articulo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.service.ClienteService" %>
<%@ page import="com.java.service.impl.ClienteServiceImpl" %>
<%@ page import="com.java.Model.entidades.Cliente" %>
<%@ page import="java.util.stream.Collectors" %><%--
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
ClienteService ser = new ClienteServiceImpl();
                    List<Cliente> list=ser.mostrar().stream().filter(e->e.getEstado()==1).collect(Collectors.toList());
%>
<script src="js/BuscarPersonal.js" type="text/javascript"></script>

<div class="container">
      <div class="text-center mt-4">
                                        <h1 class="h4 text-gray-900 mb-4">MANTENIMIENTO DE CLIENTES</h1>
                                    </div>
    <div class="d-flex justify-content-between ml-3 mr-3">
        
        <div class="d-inline-block">
                   <a href="registerCliente.jsp" class="btn btn-success" name="registrarse" id="registrarse">Crear Cliente</a>
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
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Dni</th>
                    <th>Direccion</th>
                    <th>Telefono</th>
                    <th>Operacion</th>
                  
                </tr>
            </thead>
            <tbody>

                    <%
                  
                    if(list != null)
                    {
                            for(Cliente aux : list)
                            {
                               
                    %>
                    <tr>
                        <td ><%= aux.getIdCLiente()%></td>
                        <td ><%= aux.getNombre()%></td>
                        <td ><%= aux.getApelldos()%></td>
                        <td ><%= aux.getDni()%></td>
                        <td ><%= aux.getDireccion()%></td>
                        <td ><%= aux.getTelefono()%></td>
                        
                      <td>
                          <div class="d-flex justify-content-center">
                               <a href="ActualizarCliente.jsp?codigo=<%=aux.getIdCLiente()%>" class="btn btn-success btn-sm mr-2">Actualizar</a>
                        <a href="clienteMan?tipo=eliminar_cliente&idcod=<%=aux.getIdCLiente()%>" class="btn btn-danger" id="myBtn" onclick="javascript:if(!confirm('Desea Eliminar: ?')) return false">Eliminar</a>
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
