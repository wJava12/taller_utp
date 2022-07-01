<%@ page import="com.java.service.TipoElectroService" %>
<%@ page import="com.java.service.HorarioTecnicoService" %>
<%@ page import="com.java.Model.entidades.HorarioTecnico" %>
<%@ page import="com.java.Model.entidades.TipoElectro" %>
<%@ page import="com.java.service.impl.TipoElectroServiceImpl" %>
<%@ page import="com.java.service.impl.HorarioTecnicoServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.Model.entidades.TipoServicio" %>
<%@ page import="com.java.service.TipoServicioService" %>
<%@ page import="com.java.service.impl.TipoServicioServiceImpl" %>

<%--
    Document   : CambiarHorario
    Created on : 29 may. 2022, 12:47:47
    Author     : 
--%>

<%@ page contentType="text/html;charset=UTF-8"  %>

<%
    if (request.getSession().getAttribute("strAdmCodigo") == null) {
        response.sendRedirect("index.html");
    }
%>


<jsp:include page="Header.jsp"/>
<%
    String idSession=String.valueOf(session.getAttribute("strAdmCodigo"));

    HorarioTecnicoService horarioTecnico = new HorarioTecnicoServiceImpl();
    List<HorarioTecnico> listaHorarios = horarioTecnico.mostrar();

%>
`
<div class="container">

    <form action="servicioMan" method="post">

        <input type="hidden"  name="idPersonal" value="<%=idSession%>">

        <div class="table-responsive col-md-12">

            <div class="d-flex justify-content-between ">
                <div class="d-inline-block mb-2">
                    <h4>Tecnicos Disponibles</h4>
                </div>
                <div class="d-inline-block mb-2">
                    <input class="form-control mr-sm-2" id="searchTerm" onkeyup="doSearch()" type="text"
                           placeholder="Buscar"/>
                </div>
            </div>

            <table class="table table-striped table " id="datos">
                <thead class="thead-dark">
                <tr>
                    <th>Codigo</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Dni</th>
                    <th>Fecha Ingreso</th>
                    <th>Hora Ingreso</th>
                    <th>Hora Salida</th>
                    <th>Horas Diarias</th>
                    <th>Dias Trabajados</th>
                    <th>Seleccionar</th>

                </tr>
                </thead>
                <tbody>
                <input type="hidden" id="tipo" name="tipo" value="registrar_servicio">
                <%

                    if (listaHorarios != null) {
                        for (HorarioTecnico aux : listaHorarios) {

                %>
                <tr>
                    <td><%= aux.getIdHorarioTecnico()%>
                    </td>
                    <td><%= aux.getTecnico().getNombre()%>
                    </td>
                    <td><%= aux.getTecnico().getApellido()%>
                    </td>
                    <td><%= aux.getTecnico().getDni()%>
                    </td>
                    <td><%= aux.getHorario().getFechaIngreso()%>
                    </td>
                    <td><%= aux.getHorario().getHorarioEntrada().substring(0,5)%>
                    </td>
                    <td><%= aux.getHorario().getHoraSalida().substring(0,5)%>
                    </td>

                    <td><%= aux.getHorario().getCalculoHoras().getHour()%></td>
                    <td><%= aux.getHorario().diasHabiles()%>
                    </td>


                    <!--<td><a type="submit" href="servicioMan?tipo=registrar_servicio&idcod=<%=aux.getIdHorarioTecnico()%>"
                           class="btn btn-success">Agregar</a></td>-->
                    <td><button type="submit" class="btn btn-success" value="<%=aux.getIdHorarioTecnico()%>" name="idTec">Agregar</button></td>
                </tr>


                <% }

                } %>


                </tbody>

            </table>


            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                    <%
                        for (int x = 0; x < 2; x++) {%>
                    <li class="page-item"><a class="page-link" href="#"><%= x + 1%>
                    </a></li>

                    <% }
                    %>

                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
            </nav>
        </div>
        <!-- Modal -->
        <!-- Modal
        <div class="modal fade " id="myModal" role="dialog">
            <div class="modal-dialog modal-sm">
                <div class="modal-content bg-gradient-light">
                    <div class="modal-header">
                        <button type="button" class="close bg-gradient-danger pl-2 pr-2 pt-1 pb-1" data-dismiss="modal">&times;</button>
                       
                    </div>
                    <div class="row modal-body justify-content-center">
                        <h4 class="pl-5">Se registro Correctamente..</h4>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>-->

    </form>
</div>


<jsp:include page="Footer.jsp"/>
<script src="js/BuscarPersonal.js" type="text/javascript"></script>