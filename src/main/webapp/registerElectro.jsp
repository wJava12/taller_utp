<%@ page import="com.java.service.TipoElectroService" %>
<%@ page import="com.java.service.impl.TipoElectroServiceImpl" %>
<%@ page import="com.java.Model.entidades.Electrodomestico" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.Model.entidades.TipoElectro" %>
<%@ page import="com.java.service.ClienteService" %>
<%@ page import="com.java.Model.entidades.Cliente" %>
<%@ page import="com.java.service.impl.ClienteServiceImpl" %>
<%@ page import="java.util.stream.Collectors" %>
<!DOCTYPE html>
<html lang="en">
<%

    TipoElectroService tipoElectroService= new TipoElectroServiceImpl();
    List<TipoElectro> listElectro = tipoElectroService.mostrar();
    ClienteService ser = new ClienteServiceImpl();
    List<Cliente> list=ser.mostrar().stream().filter(e->e.getEstado()==1).collect(Collectors.toList());
%>




<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>taller utp</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-success vh-100 d-flex align-items-center ">

    <div class="container w-75 ">
        <!-- Outer Row -->
        <div class="row justify-content-center ">
            <div class="col-xl-8 col-lg-12 col-md-9">
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                         
                        <div class="row">
                           
                            <div class="col-lg-12">
                                <div class="ml-3 mr-3 p-4">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Registro de Electrodomesticos</h1>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Cliente</label>
                                        <div class="col-sm-4">
                                            <input type="text" placeholder="Buscar Por Dni" id="clientDni" class="form-control" >
                                        </div>
                                        <div class="col-sm-3">
                                            <a class="btn btn-danger form-control" id="myBtn" >Buscar</a>
                                        </div>
                                        <div class="col-sm-3">
                                            <a  class="btn btn-danger form-control" id="myBtn2" data-toggle="modal" data-target="#myModal">Ver Clientes</a>
                                        </div>
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
                                    <form action="electroMan" class="user" method="post" >

                                        <div class="form-group row" id="divBody">

                                        </div>
                                        <div class="form-group row" id="divBody2">

                                        </div>

                                        <div class="form-group row">
                                            <label for="inputNombre" class="col-sm-12 col-form-label text-center">ELECTRODOMESTICO</label>
                                        </div>
                                        <hr>
                                        <div class="form-group row">
                                            <label for="inputNombre" class="col-sm-2 col-form-label">Nombre</label>
                                            <div class="col-sm-10">
                                            <input type="text" pattern="[a-zA-Z ]{3,45}" name="txtNombre" class="form-control" id="inputNombre" placeholder="Nombre">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputMarca" class="col-sm-2 col-form-label">Marca</label>
                                            <div class="col-sm-4">
                                                <input type="text" pattern="[a-zA-Z0-9 ]{3,45}" name="txtMarca" class="form-control" id="inputMarca" placeholder="Marca">
                                            </div>
                                            <label for="inputMarca" class="col-sm-2 col-form-label">Modelo</label>
                                            <div class="col-sm-4">
                                                <input type="text" pattern="[a-zA-Z0-9 ]{3,45}" name="txtModelo" class="form-control" id="inputModelo" placeholder="Modelo">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputSerie" class="col-sm-2 col-form-label">Serie</label>
                                            <div class="col-sm-4">
                                              <input type="text" name="txtSerie" pattern="^[0-9]+" class="form-control" id="inputSerie" placeholder="Serie">
                                            </div>
                                            <label class="col-sm-2 col-form-label">Tipo</label>
                                            <div class="col-sm-4">
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

                                        </div>

                                        <div class="form-group row">
                                            <label for="floatingTextarea" class="col-sm-2 col-form-label">Descrip.</label>
                                            <div class="col-sm-10">
                                            <textarea class="form-control" placeholder="Detalle De Problema" id="floatingTextarea" name="txtDescripcion"
                                                      required></textarea>
                                            </div>
                                        </div>

                                        <input type="hidden" id="tipo" name="tipo" value="registrar_electro">
                                        <div class="d-flex justify-content-center">
                                            <button type="submit" class="btn btn-success m-3">Registrar</button>
                                           <input type="reset" value="Regresar" name="btnRegresar"class="btn btn-secondary m-3"  onClick="history.back();">
                                        </div>  


                                    </form>
                                    <!-- Modal Registrar Personal -->
                                    <div class="modal fade" id="myModal" role="dialog">
                                        <div class="modal-dialog  "style="max-width: 700px">
                                            <!-- Modal content-->
                                            <div class="modal-content row">

                                                <div class="modal-body">

                                                    <div class="row">

                                                        <div class="col-lg-12">
                                                            <div class="d-flex flex-column">
                                                                <div class="text-center">
                                                                    <h1 class="h4 text-gray-900 mb-4">Clientes</h1>
                                                                </div>


                                                                <div class="table-responsive col-ms-12">
                                                                    <div class="form-group row justify-content-end mr-2">
                                                                        <a href="registerCliente.jsp" class="col-sm-2 btn btn-success">Agregar</a>
                                                                    </div>
                                                                    <hr/>
                                                                    <table class="table table-striped" id="datos">
                                                                        <thead class="thead-dark">
                                                                        <tr>
                                                                            <th>Codigo</th>
                                                                            <th>Nombres</th>
                                                                            <th>Apellidos</th>
                                                                            <th>Dni</th>
                                                                            <th>Direccion</th>
                                                                            <th>Telefono</th>


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
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>

                                        </div>
                                    </div>
                                    <!-- Fin Modal -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>
    <script src="js/Nuevo.js" type="text/javascript"></script>
    <script src="js/BuscarCliente.js"></script>
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

</body>

</html>