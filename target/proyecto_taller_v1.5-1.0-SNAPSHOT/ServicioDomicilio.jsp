<%@ page import="java.util.List" %>
<%@ page import="com.java.Model.entidades.*" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="com.java.service.*" %>
<%@ page import="com.java.service.impl.*" %>
<%@ page import="java.util.ArrayList" %>

<%--
    Document   : CambiarHorario
    Created on : 29 may. 2022, 12:47:47
    Author     : 
--%>



<%
    if (request.getSession().getAttribute("strAdmCodigo") == null) {
        response.sendRedirect("index.html");
    }
%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href="css/myStyle2.css">
<link rel="stylesheet" href="css/myStyle.css" >
<jsp:include page="Header.jsp"/>
<%
    int strCodigo= Integer.parseInt(request.getParameter("codigo"));
    String idSession=String.valueOf(session.getAttribute("strAdmCodigo"));

    HorarioTecnicoService objHorarioTecnico= new HorarioTecnicoServiceImpl();
    List<HorarioTecnico> listaHorariosTecnicos= objHorarioTecnico.mostrar();

    EspecialidadTecnicoService objEspecialidad= new EspecialidadTecnicoServiceImpl();
    EspecialidadService objEspecialidades= new EspecialidadServiceImpl();

    List<Especialidad> nueva=objEspecialidades.mostrar().stream().filter(e->e.getIdEspecialidad()==strCodigo).collect(Collectors.toList());
    List<EspecialidadTecnico> listaEspecialidad= objEspecialidad.mostrar().stream().filter(r->r.getEspecialidad().getIdEspecialidad()==strCodigo).collect(Collectors.toList());

    String hora="";
    List<HorarioTecnico> listaFiltrada=new ArrayList<>();
    for (EspecialidadTecnico obj:listaEspecialidad) {
        for (HorarioTecnico ht:listaHorariosTecnicos ) {
            if (obj.getTecnico().getIdTecnico()==ht.getTecnico().getIdTecnico()){
                listaFiltrada.add(ht);
            }
        }

    }



%>


<div class="container">

    <form action="servicioMan" method="post">

        <input type="hidden"  name="idPersonal" value="<%=idSession%>">

        <div class="table-responsive col-md-12">
            <div class="row form-group">
                <div class="form-group col-md-12 d-flex justify-content-center">
                    <label class="h1 text-center "> <%=nueva.get(0).getNombre().substring(0,12)+"s"+nueva.get(0).getNombre().substring(12,nueva.get(0).getNombre().length())%></label>
                </div>
                <%--<div class="form-group col-md-2">
                    <label for="inputFecha">Fecha</label>
                    <input type="date" class="form-control" id="inputFecha" name="txtFecha" placeholder="" required>
                </div>

                <div class="form-group col-md-2">
                    <label for="inputHora">Hora</label>
                    <input type="time" class="form-control" id="inputHora" name="txtHora" placeholder="" required>
                </div>
                <div class="form-group col-md-4">
                 </div>--%>
            </div>
            <div class="row">
            <%
                int x=1;
                if (listaFiltrada != null) {
                    for (HorarioTecnico aux : listaFiltrada) {
            %>

                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title"><i class="fa fa-user mr-2"></i><%= aux.getTecnico().getNombre() + " " +aux.getTecnico().getApellido()%></h5>
                            <a class="card-link"><i class="fa fa-phone-square mr-2 "></i><%= aux.getTecnico().getTelefono()%></a> <br/>
                            <a class="card-link"><i class="fa fa-envelope mr-2"></i><%= aux.getTecnico().getCorreo()%></a>

                            <p class="card-text">Exp. <%= aux.getTecnico().getExperiencia()%> </p>
                            <input type="hidden" id="tecnicoId" name="tecnicoId" value="<%= aux.getTecnico().getIdTecnico()%>">
                            <input type="hidden" id="horarioTecnico" name="horarioTecnico" value="<%= aux.getHorario().getHorarioEntrada()%>">
                            <input type="hidden" id="diaInicio" name="diaInicio" value="<%= aux.getHorario().getDiaInicio()%>">
                            <input type="hidden" id="diaFin" name="diaFin" value="<%= aux.getHorario().getDiaFin()%>">
                            <a href="#" class="btn btn-primary"onclick="muestravalor(<%=aux.getTecnico().getIdTecnico()%>)" id="idTecnico<%=x++%>" value="<%= aux.getIdHorarioTecnico()%>" >Agendar Visita</a>
                        </div>
                    </div>
                </div>


            <% }

            } %>
            </div>
           <%-- <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <!-- Modal content-->
                    <div class="modal-content">

                        <div class="modal-body">
                            <div class="mb-3">
                                <label  class="col-form-label">Horario:</label>
                                <input  class="col-form-label" id="tecnico" ></input>
                            </div>
                            <div class="table-responsive">
                                <table class="table table-sm align-middle text-xsmall" id="divTable">
                                    <thead>
                                    <tr>
                                        <th>Lunes</th>
                                        <th>Martes</th>
                                        <th>Miercoles</th>
                                        <th>Jueves</th>
                                        <th>Viernes</th>
                                        <th>Sabado</th>
                                    </tr>
                                    </thead>
                                    <tbody id="divHorario">

                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="hidden" id="tipo" name="tipo" value="registrar_personal">
                            <div class="d-flex justify-content-center">
                                <button type="submit" class="btn btn-success mr-2">Registrar</button>
                                <button type="reset" class="btn btn-secondary pl-4 pr-4" data-dismiss="modal" id="cancelar">Salir</button>


                            </div>
                        </div>
                    </div>

                </div>
            </div>
--%>
            <!-- Button trigger modal -->
            <!-- Modal -->
            <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document" style="width: 450px">
                    <div class="modal-content">
                       <%-- <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>--%>
                        <div class="modal-body" id="divBody">
                            <div class="row ">
                                <label class="col-sm-2 col-form-label">Mes: </label>
                                <div class="col-sm-4">
                                    <select class="form-control" name="mesEntrada" id="mesEntrada">
                                        <option value="enero" >Enero</option>
                                        <option value="febrero">Febrero</option>
                                        <option value="marzo">Marzo</option>
                                        <option value="abril">Abril</option>
                                        <option value="mayo">Mayo</option>
                                        <option value="junio">Junio</option>
                                        <option value="julio" >Julio</option>
                                        <option value="agosto">Agosto</option>
                                        <option value="septiembre">Setiembre</option>
                                        <option value="octubre">octubre</option>
                                        <option value="noviembre">noviembre</option>
                                        <option value="diciembre">Diciembre</option>
                                    </select>
                                </div>
                            </div>
                            <input type="hidden" id="tipo" name="tipo" value="mostrar_tecnico_servicio">
                            <input type="hidden" id="enviarIdTecnico" name="enviarIdTecnico">
                            <div id="calendario" class="divs">


                            </div>

                        </div>
                      <%--  <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>--%>
                    </div>
                </div>
            </div>



            <%--<hr/>
            <div class="row form-group">

                <div class="form-group col-md-7">
                    <label class="h3 text-center ">Datos Cliente</label>
                </div>

                    <form action="clienteMan" class="form-inline"method="post dentro ">

                        <input type="search" name="txtBuscar" class="form-control col-sm-3 mr-1" placeholder="DNI"/>
                        <a href="clienteMan?tipo=buscar_cliente&dn" class="btn btn-success" onclick="">Buscar</a>

                    </form>



                <div class="form-group col-md-6">
                    <label for="inputNombreCliente">Nombre</label>
                    <input type="text" class="form-control" id="inputNombreCliente" name="txtNombre"
                           placeholder="Nombre" required>
                </div>

                <div class="form-group col-md-6">
                    <label for="inputApellidoCliente">Apellido</label>
                    <input type="text" class="form-control" id="inputApellidoCliente" name="txtApellido"
                           placeholder="Apellido" required>
                </div>

                <div class="form-group col-md-6">
                    <label for="inputTelefonoCliente">Telefono</label>
                    <input type="text" class="form-control" id="inputTelefonoCliente" name="txtTelefono"
                           placeholder="Telefono" required>
                </div>

                <div class="form-group col-md-6">
                    <label for="inputDireccionCliente">Direccion</label>
                    <input type="text" class="form-control" id="inputDireccionCliente" name="txtDireccion"
                           placeholder="Direccion" required>
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
                           placeholder="Nombre" required>
                </div>

                <div class="form-group col-md-2">
                    <label for="inputMarcaCliente">Marca</label>
                    <input type="text" class="form-control" id="inputMarcaCliente" name="txtMarca" placeholder="Marca"
                           required>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputModeloCliente">Modelo</label>
                    <input type="text" class="form-control" id="inputModeloCliente" name="txtModelo"
                           placeholder="Modelo" required>
                </div>
                <div class="form-group col-md-3">
                    <label for="inputSerieCliente">Serie</label>
                    <input type="text" class="form-control" id="inputSerieCliente" name="txtSerie" placeholder="Serie"
                           required>
                </div>

               &lt;%&ndash; <div class="form-group col-md-2">
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
                </div>&ndash;%&gt;

                <div class="form-group col-md-12">
                    <label for="floatingTextarea">Descripcion Problema</label>
                    <textarea class="form-control" placeholder="Detalle" id="floatingTextarea" name="txtDescripcion"
                              required></textarea>
                </div>

            </div>

            <hr/>--%>

           <%-- <div class="d-flex justify-content-between ">
                <div class="d-inline-block mb-2">
                    <h4>Tecnicos Disponibles</h4>
                </div>
                <div class="d-inline-block mb-2">
                    <input class="form-control mr-sm-2" id="searchTerm" onkeyup="doSearch()" type="text"
                           placeholder="Buscar"/>
                </div>
            </div>--%>

            <%--<table class="table table-striped table " id="datos">
                <thead class="thead-dark">
                <tr>
                    <th>Codigo</th>
                    <th>Hora Inicio</th>
                    <th>hora Fin</th>

                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Telefono</th>
                    <th>Experiencia</th>
                    <th>Seleccionar</th>

                </tr>
                </thead>
                <tbody>
                <input type="hidden" id="tipo" name="tipo" value="registrar_servicio">
                <%

                    if (listaFiltrada != null) {
                        for (HorarioTecnico aux : listaFiltrada) {

                %>
                <tr>
                    <td><%= aux.getHorario().getIdHorario()%>
                    </td>

                    <td><%= aux.getHorario().getHorarioEntrada()%>
                    </td>
                    <td><%= aux.getHorario().getHoraSalida()%>
                    </td>
                    <td><%= aux.getTecnico().getNombre()%>
                    </td>
                    <td><%= aux.getTecnico().getApellido()%>
                    </td>
                    <td><%= aux.getTecnico().getTelefono()%>
                    </td>
                    <td><%= aux.getTecnico().getExperiencia()%>
                    </td>
                    <td><a href="registerElectro.jsp?codigo=<%=aux.getIdHorarioTecnico()%>" class="btn btn-success">Agregar</a></td>
                 </tr>


                <% }

                } %>


                </tbody>

            </table>--%>

            <%--<nav aria-label="Page navigation example">
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
            </nav>--%>



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

<script src="js/calendario.js" type="text/javascript"></script>
<script src="js/BuscarPersonal.js" type="text/javascript"></script>
<jsp:include page="Footer.jsp"/>

