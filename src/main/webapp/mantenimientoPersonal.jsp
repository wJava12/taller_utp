<%@ page import="com.java.service.PersonalService" %>
<%@ page import="com.java.Model.entidades.Personal" %>
<%@ page import="com.java.service.impl.PersonalServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.service.CargoService" %>
<%@ page import="com.java.service.impl.CargoServiceImpl" %>
<%@ page import="com.java.Model.entidades.Cargo" %><%--
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
    PersonalService ser = new PersonalServiceImpl();
    List<Personal> list = ser.mostrar();
    CargoService car = new CargoServiceImpl();
    List<Cargo> cargos = car.mostrar();
%>

<script src="js/BuscarPersonal.js" type="text/javascript"></script>
<script src="js/validarForm.js" type="text/javascript"></script>
<div class="container bg-light m-2">

    <div class="form-group row m-2">
        <div class="col-sm-12 h2 mt-2 pt-4">
            <label>MANTENIMIENTO DE PERSONAL</label>
        </div>

    </div>

    <div class="form-group row d-flex justify-content-between m-2">
        <!--<div class=" col-sm-6 ">
            <a href="sValidador?destinos=registrar_personal" class="btn btn-success" name="registrarse" id="registrarse">Crear Personal</a>
        </div>-->
        <div class=" col-sm-6 ">
            <a href="" class="btn btn-success" name="registrarse" id="registrarse"data-toggle="modal" data-target="#myModal">Crear Personal</a>
        </div>

        <!-- Modal Registrar Personal -->
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content row">

                    <div class="modal-body">

                        <div class="row">

                            <div class="col-lg-12">
                                <div class="ml-3 mr-3 p-4">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Registrar Personal</h1>
                                    </div>

                                    <form id="basic-form" action="personalMan"  method="post">
                                        <input type="hidden" name="txtId"  value="">
                                        <div class="form-group row">

                                            <label for="txtNombre" class="col-sm-2 col-form-label">Nombre</label>
                                            <div class="col-sm-10">

                                                <input required type="text" pattern="[a-zA-Z ]{3,45}" name="txtNombre" class="form-control" id="txtNombre" placeholder="Nombre" value="">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputApellido" class="col-sm-2 col-form-label">Apellido</label>
                                            <div class="col-sm-10">
                                                <input required pattern="[a-zA-Z ]{3,45}" type="text" name="txtApellido" class="form-control" id="inputApellido" placeholder="Apellido" value="">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputTelefono"  class="col-sm-2 col-form-label">Celular</label>
                                            <div class="col-sm-4">
                                                <input  type="text" pattern="^\d{9}$" name="txtTelefono" class="form-control" id="inputTelefono" placeholder="Celular" value="">
                                            </div>
                                            <label for="inputDni" class="col-sm-2 col-form-label">Dni</label>
                                            <div class="col-sm-4">
                                                <input required pattern="^\d{8}$" type="text" class="form-control" name="txtDni"id="inputDni" placeholder="DNI"value="">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputCorreo" class="col-sm-2 col-form-label">Correo</label>
                                            <div class="col-sm-10">
                                                <input type="email" pattern="[a-zA-Z0-9!#$%&'*_+-]([\.]?[a-zA-Z0-9!#$%&'*_+-])+@[a-zA-Z0-9]([^@&%$\/()=?¿!.,:;]|\d)+[a-zA-Z0-9][\.][a-zA-Z]{2,4}([\.][a-zA-Z]{2})?" name="txtCorreo"class="form-control" id="inputCorreo" placeholder="Correo"value="">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputDireccion" class="col-sm-2 col-form-label">Direccion</label>
                                            <div class="col-sm-10">
                                                <input required type="text" name="txtDireccion" class="form-control" id="inputDireccion" placeholder="Direccion"value="">
                                            </div>
                                        </div>
                                        <div class="form-group row">

                                        </div>
                                        <div class="form-group row">
                                            <label for="inputUsuario" class="col-sm-2 col-form-label">Usuario</label>
                                            <div class="col-sm-4">
                                                <input required type="text" class="form-control" name="txtUsuario"id="inputUsuario" placeholder="Usuario" value="">
                                            </div>
                                            <label for="inputPassword" class="col-sm-2 col-form-label">Clave</label>
                                            <div class="col-sm-4">
                                                <input required type="password" class="form-control" name="txtClave"id="inputPassword" placeholder="Password" value="" >
                                            </div>
                                        </div>
                                        <div class="form-group row">

                                        </div>
                                        <div class="form-group row">
                                            <label  class="col-sm-2 col-form-label">Cargo</label>
                                            <div class="col-sm-10">
                                                <select class="form-control" name="cargo">
                                                    <%
                                                        if(cargos != null)
                                                        {
                                                            for(Cargo aux : cargos)
                                                            {

                                                    %>
                                                    <option><%= aux.getNombre()%></option>
                                                    <%      }

                                                    } %>

                                                </select>
                                            </div>
                                        </div>

                                        <input type="hidden" id="tipo" name="tipo" value="registrar_personal">
                                        <div class="d-flex justify-content-center">
                                            <button type="submit" class="btn btn-success mr-2">Registrar</button>
                                            <button type="button" class="btn btn-secondary pl-4 pr-4" data-dismiss="modal">Salir</button>
                                        </div>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </div>
        <!-- Fin Modal -->


        <div class="col-sm-3  ">

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
                    <th>Direccion</th>
                    <th>Telefono</th>
                    <th>Dni</th>
                    <th>Correo</th>
                    <th>Usuario</th>
                    <th>Contrase�a</th>

                    <th>Cargo</th>
                    <th>Actualizar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>




                <%
                    if (list != null) {
                        for (Personal aux : list) {

                %>
                <tr>
                    <td ><%= aux.getIdPersonal()%></td>
                    <td ><%= aux.getNombre()%></td>
                    <td ><%= aux.getApellidos()%></td>
                    <td ><%= aux.getDireccion()%></td>
                    <td ><%= aux.getTelefono()%></td>
                    <td ><%= aux.getDni()%></td>
                    <td ><%= aux.getCorreo()%></td>
                    <td ><%= aux.getUsuario()%></td>
                    <td ><%= aux.getClave()%></td>

                    <td ><%= aux.getCargo().getNombre()%></td>

                    <td><a href="PersonalActualizar.jsp?codigo=<%=aux.getIdPersonal()%>" class="btn btn-success">Actualizar</a></td>
                    <td><a href="personalMan?tipo=eliminar_personal&idcod=<%=aux.getIdPersonal()%>" class="btn btn-danger" id="myBtn" onclick="javascript:if(!confirm('�Desea Eliminar: ?')) return false">Eliminar</a></td>

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
                <li class="page-item"><a class="page-link" href="#"> <%= x + 1%> </a></li>

                <% }
                %>

                <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
        </nav>
    </div>


</div>
<hr/>


<jsp:include page="Footer.jsp"/>      
