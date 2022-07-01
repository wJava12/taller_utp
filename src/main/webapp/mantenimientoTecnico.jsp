    <%@ page import="com.java.service.TecnicoService" %>
<%@ page import="com.java.service.impl.TecnicoServiceImpl" %>
<%@ page import="com.java.Model.entidades.Tecnico" %>
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
TecnicoService ser = new TecnicoServiceImpl();
                    List<Tecnico> list=ser.mostrar();
%>
<script src="js/BuscarPersonal.js" type="text/javascript"></script>
<link href="css/myStyle.css">
<div class="container">
     <div class="text-center mt-4">
                                        <h1 class="h4 text-gray-900 mb-4">MANTENIMIENTO DE TECNICOS</h1>
                                    </div> 
    <div class="d-flex justify-content-between">
        <div class="d-inline-block ml-3">
                   <a href="registerTecnico.jsp" class="btn btn-success" name="registro" id="registro">Crear Tecnico</a>
            </div>
        <div class="d-inline-block">
         <nav class="navbar navbar-light bg-light">
           
             <input class="form-control mr-sm-2" id="searchTerm" onkeyup="doSearch()"type="text" placeholder="Buscar">
             
            
        </nav>
    </div>
    </div>
 
 <div class="table-responsive col-md-12">
     <hr/>
     <table class="table table-light table-striped text-xsmall table-hover" id="datos">
            <thead class="thead-dark">
                <tr>
                    <th class="text-xsmall">Codigo</th>
                    <th >Nombres</th>
                    <th >Apellidos</th>
                    <th >Dni</th>
                    <th>Telefono</th>
                    <th >Correo</th>

                    <th>Experiencia</th>
                    <th>Operacion</th>

                </tr>
            </thead>
            <tbody>

                
                
                
                    <%

                  
                    if(list != null)
                    {
                            for(Tecnico aux : list)
                            {
                               
                    %>
                    <tr>
                        <td ><%= aux.getIdTecnico()%></td>
                        <td><%= aux.getNombre()%></td>
                        <td><%= aux.getApellido()%></td>
                        <td><%= aux.getDni()%></td>
                        <td><%= aux.getTelefono()%></td>
                        <td><%= aux.getCorreo()%></td>

                        <td><%= aux.getExperiencia()%></td>

                        <td class="d-flex justify-content-between">
                            <a href="ActualizarTecnico.jsp?codigo=<%=aux.getIdTecnico()%>" class="btn btn-primary  btn-sm"><i class="fa fa-check-square" aria-hidden="true"></i></a>
                            <a href="EliminarTecnico.jsp?codigo=<%=aux.getIdTecnico()%>" class="btn btn-danger  btn-sm"><i class="fa fa-minus-square" aria-hidden="true"></i></a>

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
