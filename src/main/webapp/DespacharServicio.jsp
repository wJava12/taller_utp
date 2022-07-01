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
<%@ page import="com.java.service.impl.ServicioServiceImpl" %>
<%@ page import="com.java.service.ServicioService" %>
<%@ page import="com.java.Model.entidades.Servicio" %>

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
    int strCodigo= Integer.parseInt(request.getParameter("codigo"));
    TipoElectroService serElectro = new TipoElectroServiceImpl();
    HorarioTecnicoService horarioTecnico = new HorarioTecnicoServiceImpl();
    List<HorarioTecnico> listaHorarios = horarioTecnico.mostrar();
    List<TipoElectro> listElectro = serElectro.mostrar();
    TipoServicioService objTipoServicioService= new TipoServicioServiceImpl();
    List<TipoServicio> listaServicios= objTipoServicioService.mostrar();
    ServicioService objServicioService= new ServicioServiceImpl();
    Servicio serviciosPendiente= objServicioService.buscar(strCodigo);
%>
`
<div class="container">

    <form action="servicioMan" method="post">
        <div class="table-responsive col-md-12">
            <div class="row form-group">
                <div class="form-group col-md-12 d-flex justify-content-center">
                    <label class="h1 text-center ">Despachar Servicio</label>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputFecha">Fecha</label>
                    <input type="text" class="form-control" id="inputFecha" name="txtFecha" value="<%=serviciosPendiente.getFecha()%>">
                </div>

                <div class="form-group col-md-2">
                    <label for="inputHora">Hora</label>
                    <input type="text" class="form-control" id="inputHora" name="txtHora" value="<%=serviciosPendiente.getHora()%>">
                </div>
                <div class="form-group col-md-4">
                 </div>
                <div class="form-group col-md-4 ">
                    <label for="inputHora">Servicios</label>
                    <select class="form-control" name="tipoServicio">

                        <%
                            if (listaServicios != null) {
                                for (TipoServicio tipSer : listaServicios) {
                        %>
                        <option value="<%=tipSer.getIdTipoServicio()%>"><%= tipSer.getNombre()%>
                        </option>
                        <% }
                        }%>

                    </select>
                </div>
            </div>
            <hr/>
            <div class="row form-group">

                <div class="form-group col-md-12">
                    <label class="h3 text-center ">Datos Cliente</label>
                </div>

                <div class="form-group col-md-6">
                    <label for="inputNombreCliente">Nombre</label>
                    <input type="text" class="form-control" id="inputNombreCliente" name="txtNombre"
                           value="<%=serviciosPendiente.getCliente().getNombre()%>">
                </div>

                <div class="form-group col-md-6">
                    <label for="inputApellidoCliente">Apellido</label>
                    <input type="text" class="form-control" id="inputApellidoCliente" name="txtApellido"
                           value="<%=serviciosPendiente.getCliente().getApelldos()%>">
                </div>

                <div class="form-group col-md-6">
                    <label for="inputTelefonoCliente">Telefono</label>
                    <input type="text" class="form-control" id="inputTelefonoCliente" name="txtTelefono"
                           value="<%=serviciosPendiente.getCliente().getTelefono()%>">
                </div>

                <div class="form-group col-md-6">
                    <label for="inputDireccionCliente">Direccion</label>
                    <input type="text" class="form-control" id="inputDireccionCliente" name="txtDireccion"
                           value="<%=serviciosPendiente.getCliente().getDireccion()%>">
                </div>
            </div>
            <hr/>

            <div class="row form-group">
                <div class="form-group col-md-12">
                    <label class="h3 text-center ">Datos Electrodomestico</label>
                </div>
                <div class="form-group col-md-3">
                    <label for="inputNombreElectro">Nombre</label>
                    <input type="text" class="form-control" id="inputNombreElectro" name="txtNombreElectro"
                           value="<%=serviciosPendiente.getCliente().getElectrodomestico().getNombre()%>">
                </div>

                <div class="form-group col-md-2">
                    <label for="inputMarcaCliente">Marca</label>
                    <input type="text" class="form-control" id="inputMarcaCliente" name="txtMarca" value="<%=serviciosPendiente.getCliente().getElectrodomestico().getMarca()%>">
                </div>
                <div class="form-group col-md-2">
                    <label for="inputModeloCliente">Modelo</label>
                    <input type="text" class="form-control" id="inputModeloCliente" name="txtModelo"
                           alue="<%=serviciosPendiente.getCliente().getElectrodomestico().getModelo()%>">
                </div>
                <div class="form-group col-md-3">
                    <label for="inputSerieCliente">Serie</label>
                    <input type="text" class="form-control" id="inputSerieCliente" name="txtSerie" value="<%=serviciosPendiente.getCliente().getElectrodomestico().getSerie()%>">
                </div>

                <div class="form-group col-md-2">
                    <label>Tipo</label>
                    <select class="form-control" name="tipoElectro">

                        <%
                            if (listElectro != null) {
                                for (TipoElectro aux2 : listElectro) {
                        %>
                        <option value="<%= aux2.getIdTipoElectro()%>"><%= aux2.getNombre()%>
                        </option>
                        <% }
                        }%>

                    </select>
                </div>

                <div class="form-group col-md-12">
                    <label for="floatingTextarea">Descripcion Problema</label>
                    <textarea class="form-control" id="floatingTextarea" name="txtDescripcion"
                              value="<%=serviciosPendiente.getCliente().getElectrodomestico().getDescripcion()%>"></textarea>
                </div>

            </div>

            <hr/>

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

                    <th>Telefono</th>
                    <th>Horario</th>
                    <th>Especialidad</th>
                    <th>Experiencia</th>
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

                    <td><%= aux.getTecnico().getTelefono()%>
                    </td>
                    <td><%= aux.getHorario().getHorarioEntrada() + " - " + aux.getHorario().getHoraSalida()%>
                    </td>
                    <td><%= aux.getTecnico().getEspecialidad()%>
                    </td>
                    <td><%= aux.getTecnico().getExperiencia()%>
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