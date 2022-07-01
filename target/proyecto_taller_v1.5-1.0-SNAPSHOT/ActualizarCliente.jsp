<%@ page import="com.java.service.PersonalService" %>
<%@ page import="com.java.Model.entidades.Personal" %>
<%@ page import="com.java.service.impl.PersonalServiceImpl" %>
<%@ page import="com.java.service.impl.CargoServiceImpl" %>
<%@ page import="com.java.service.CargoService" %>
<%@ page import="com.java.Model.entidades.Cargo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.service.ClienteService" %>
<%@ page import="com.java.service.impl.ClienteServiceImpl" %>
<%@ page import="com.java.Model.entidades.Cliente" %>
<!DOCTYPE html>
<html lang="en">
<%
    
%>



<%
    int strCodigo= Integer.parseInt(request.getParameter("codigo"));
//Cargo los datos del alumno.
    ClienteService codigoCliente = new ClienteServiceImpl();
    Cliente cliente=codigoCliente.buscar(strCodigo);
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

<body class="bg-gradient-success">

    <div class="container w-75 mt-4">
        <!-- Outer Row -->
        <div class="row justify-content-center">
            <div class="col-xl-8 col-lg-12 col-md-9">
                <div class="card o-hidden border-0 shadow-lg mt-4">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                         
                        <div class="row">
                           
                            <div class="col-lg-12">
                                <div class="ml-3 mr-3 p-4">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Actualizar Cliente</h1>
                                    </div>
                                    
                                    <form action="clienteMan" class="user" method="post">
                                        <input type="hidden" name="txtId"  value="<%=cliente.getIdCLiente()%>">
                                        <div class="form-group row">
                                            
                                            <label for="inputNombre" class="col-sm-2 col-form-label">Nombre</label>
                                            <div class="col-sm-10">
                                                
                                              <input required type="text" pattern="[a-zA-Z ]{3,45}" name="txtNombre" class="form-control" id="inputNombre" placeholder="Nombre" value="<%=cliente.getNombre()%>">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputApellido" class="col-sm-2 col-form-label">Apellido</label>
                                            <div class="col-sm-10">
                                              <input required pattern="[a-zA-Z ]{3,45}" type="text" name="txtApellido" class="form-control" id="inputApellido" placeholder="Apellido" value="<%=cliente.getApelldos()%>">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputTelefono"  class="col-sm-2 col-form-label">Celular</label>
                                            <div class="col-sm-4">
                                              <input pattern="^\d{9}$" type="text" name="txtTelefono" class="form-control" id="inputTelefono" placeholder="Celular" value="<%=cliente.getTelefono()%>">
                                            </div>
                                            <label for="inputDni" class="col-sm-2 col-form-label">Dni</label>
                                            <div class="col-sm-4">
                                              <input required pattern="^\d{8}$" type="text" class="form-control" name="txtDni"id="inputDni" placeholder="DNI"value="<%=cliente.getDni()%>">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputCorreo" class="col-sm-2 col-form-label">Correo</label>
                                            <div class="col-sm-10">
                                              <input type="email" pattern="[a-zA-Z0-9!#$%&'*_+-]([\.]?[a-zA-Z0-9!#$%&'*_+-])+@[a-zA-Z0-9]([^@&%$\/()=?¿!.,:;]|\d)+[a-zA-Z0-9][\.][a-zA-Z]{2,4}([\.][a-zA-Z]{2})?" name="txtCorreo"class="form-control" id="inputCorreo" placeholder="Correo"value="<%=cliente.getCorreo()%>">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputDireccion" class="col-sm-2 col-form-label">Direccion</label>
                                            <div class="col-sm-10">
                                              <input type="text" name="txtDireccion" class="form-control" id="inputDireccion" placeholder="Direccion"value="<%=cliente.getDireccion()%>">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputUsuario" class="col-sm-2 col-form-label">Usuario</label>
                                            <div class="col-sm-4">
                                              <input type="text" class="form-control" name="txtUsuario"id="inputUsuario" placeholder="Usuario" value="<%=cliente.getUsuario()%>">
                                            </div>
                                            <label for="inputPassword" class="col-sm-2 col-form-label">Clave</label>
                                            <div class="col-sm-4">
                                                <input type="password" class="form-control" name="txtClave"id="inputPassword" placeholder="Password" value="<%=cliente.getClave()%>" >
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            
                                        </div>

                                        
                                        
                                        
                                       
                                        <input type="hidden" id="tipo" name="tipo" value="actualizar_cliente">
                                        <div class="d-flex justify-content-center">
                                            <button type="submit" class="btn btn-success m-3">Actualizar</button>
                                           <input type="reset" value="Regresar" name="btnRegresar"class="btn btn-secondary m-3"  onClick="history.back();">
                                        </div>  
                                    
                                       
                                    </form>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

</body>

</html>