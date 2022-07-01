<%@ page import="com.java.service.TecnicoService" %>
<%@ page import="com.java.service.HorarioService" %>
<%@ page import="com.java.service.impl.TecnicoServiceImpl" %>
<%@ page import="com.java.service.impl.HorarioServiceImpl" %>
<%@ page import="com.java.Model.entidades.Horario" %>
<%@ page import="com.java.Model.entidades.Tecnico" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.stream.Collectors" %><%--
    Document   : CambiarHorario
    Created on : 29 may. 2022, 12:47:47
    Author     : 
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>


<%
    if (request.getSession().getAttribute("strAdmCodigo") == null) {
        response.sendRedirect("index.html");
    }
%>


<jsp:include page="Header.jsp"/>
<%
    TecnicoService ser = new TecnicoServiceImpl();
    List<Tecnico> list = ser.mostrar();
    int total=(list!=null)?1:0;
%>
`
<div class="container">
    <div class="row">
        <div class="form-group col-md-12 d-flex justify-content-center">
            <label class="h1 text-center ">HORARIOS DE TECNICOS</label>
        </div>

    </div>
    <form action="horarioTecnicoMan" class="user" method="post">
        <div class="form-group row justify-content-end">
            <div class="col-sm-2">
                <a class="btn btn-danger form-control" id="myBtn" >Calcular Horas de Laborales</a>
            </div>
        </div>

        <div class="form-group row ">
                <label for="inputFecha" class="col-sm-2 col-form-label">Fecha Ingreso</label>
                <div class="col-sm-2">
                    <input type="date" class="form-control" id="inputFecha" name="txtFecha" placeholder="" required>
                </div>
            <label class="col-sm-2 col-form-label">De: </label>
            <div class="col-sm-2">
                <select class="form-control" name="diaEntrada">
                    <option value="Lunes" >Lunes</option>
                    <option value="Martes">Martes</option>
                    <option value="Miercoles">Miercole</option>
                    <option value="Jueves">Jueves</option>
                    <option value="Viernes">Viernes</option>
                    <option value="Sabado">Sabado</option>

                </select> </div>
            <label  class="col-sm-2 col-form-label">A: </label>
            <div class="col-sm-2">
                <select class="form-control" name="diaSalida">
                    <option value="Lunes" >Lunes</option>
                    <option value="Martes">Martes</option>
                    <option value="Miercoles">Miercole</option>
                    <option value="Jueves">Jueves</option>
                    <option value="Viernes">Viernes</option>
                    <option value="Sabado">Sabado</option>
                </select>
              </div>
        </div>

        <div class="form-group row ">
                <label for="inputEntrada" class="col-sm-2 col-form-label">Hora Entrada</label>
                <div class="col-sm-2">
                    <input type="time" class="form-control" id="inputEntrada" name="txtHoraEntrada" placeholder="" required>
                </div>
                <label for="inputSalida" class="col-sm-2 col-form-label">Hora Salida</label>
                <div class="col-sm-2">
                    <input type="time" class="form-control" id="inputSalida" name="txtHoraSalida" placeholder="" required>
                </div>
                <label for="inputHoraRef" class="col-sm-2 col-form-label">Hora Almuerzo</label>
                <div class="col-sm-2">
                    <input type="time" class="form-control" id="inputHoraRef" name="txtHoraAlmuerzo" placeholder="" required>
                </div>
        </div>
        <div class="form-group row"id="divBody">
            <label class="col-sm-2 col-form-label">Horas diarias</label>
            <div class="col-sm-2">
                <input  readonly type="text" class="form-control" id="inputTotal" name="txtTotalHoras" placeholder="">
            </div>
         </div>

        <div class="table-responsive col-md-12">

            <table class="table table-striped table " id="datos2">
                <thead class="thead-dark">
                <tr>
                    <th>Codigo</th>
                    <th>Lunes</th>
                    <th>Martes</th>
                    <th>Miercoles</th>
                    <th>Jueves</th>
                    <th>Viernes</th>
                    <th>Sabado</th>
                </tr>
                </thead>
                <tbody>

                <tr>
                    <td>
                    </td>

                    <td>
                        <div class="form-check d-flex justify-content-center">
                            <input class="form-check-input text-center" type="checkbox" name="Horario3"
                                   value="Lunes" id="flexCheckDefault3">
                        </div>
                    </td>
                    <td>
                        <div class="form-check d-flex justify-content-center">
                            <input class="form-check-input text-center" type="checkbox" name="Horario4"
                                   value="Martes" id="flexCheckDefault4">
                        </div>
                    </td>

                    <td>
                        <div class="form-check d-flex justify-content-center">
                            <input class="form-check-input text-center" type="checkbox" name="Horario5"
                                   value="Miercoles" id="flexCheckDefault5">
                        </div>
                    </td>
                    <td>
                        <div class="form-check d-flex justify-content-center">
                            <input class="form-check-input text-center" type="checkbox" name="Horario6"
                                   value="Jueves" id="flexCheckDefault6">
                        </div>
                    </td>
                    <td>
                        <div class="form-check d-flex justify-content-center">
                            <input class="form-check-input text-center" type="checkbox" name="Horario7"
                                   value="Viernes" id="flexCheckDefault7">
                        </div>
                    </td>

                    <td>
                        <div class="form-check d-flex justify-content-center">
                            <input class="form-check-input text-center" type="checkbox" name="Horario8"
                                   value="Sabado" id="flexCheckDefault2">
                        </div>
                    </td>
                </tr>




                </tbody>

            </table>


            <table class="table table-striped table " id="datos">
                <thead class="thead-dark">
                <tr>
                    <th>Codigo</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Telefono</th>
                    <th>Correo</th>
                    <th>Especialidad</th>
                    <th>Exxperiencia</th>
                    <th>Seleccionar</th>
                </tr>
                </thead>
                <tbody>
                <%
                    if (list != null) {
                        for (Tecnico aux : list) {
                %>
                <tr>
                    <td><%= aux.getIdTecnico()%>
                    </td>
                    <td><%= aux.getNombre()%>
                    </td>
                    <td><%= aux.getApellido()%>
                    </td>

                    <td><%= aux.getTelefono()%>
                    </td>

                    <td><%= aux.getCorreo()%>
                    </td>

                    <td><%= aux.getExperiencia()%>
                    </td>

                    <td>
                        <div class="form-check d-flex justify-content-center">
                            <input class="form-check-input text-center" type="checkbox" name="tecnicos"
                                   value="<%=aux.getIdTecnico()%>" id="flexCheckDefault">
                        </div>
                    </td>
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

        <c:choose>
        <c:when test="${total ==0}">
            <div class="d-flex justify-content-center">
                <button disabled type="submit" class="btn btn-success m-3">Agregar</button>
            </div>
        </c:when>

        </c:choose>
        <c:choose>
            <c:when test="${total==1}">
                <div class="d-flex justify-content-center">
                    <button   type="submit" class="btn btn-success m-3">Agregar</button>
                </div>
            </c:when>

        </c:choose>

        <input type="hidden" id="tipo" name="tipo" value="registrar_horarioTecnico">


    </form>
    <script src="js/CalculoHora.js"></script>
    <script src="js/BuscarPersonal.js" type="text/javascript"></script>

    <jsp:include page="Footer.jsp"/>
