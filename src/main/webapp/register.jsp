<%@ page import="com.java.service.CargoService" %>
<%@ page import="com.java.service.impl.CargoServiceImpl" %>
<%@ page import="com.java.Model.entidades.Cargo" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<%
    
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

    <div class="container w-75 ">
        <!-- Outer Row -->
        <div class="row justify-content-center ">
            <div class="col-xl-8 col-lg-12 col-md-9 mt-4 ">
                <div class="card o-hidden border-0 shadow-lg mt-2 ">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                         
                        <div class="row bg-light " >
                           
                            <div class="col-lg-12">
                                <div class="ml-3 mr-3 p-4">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Registro de Personal</h1>
                                    </div>
                                    
                                    <form action="sRegistrar" class="user" method="post">
                                        <div class="form-group row">
                                            <label for="inputNombre" class="col-sm-2 col-form-label">Nombre</label>
                                            <div class="col-sm-10">
                                            <input type="text" name="txtNombre" class="form-control" id="inputNombre" placeholder="Nombre">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputApellido" class="col-sm-2 col-form-label">Apellido</label>
                                            <div class="col-sm-10">
                                              <input type="text" name="txtApellido" class="form-control" id="inputApellido" placeholder="Apellido">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputTelefono"  class="col-sm-2 col-form-label">Telefono</label>
                                            <div class="col-sm-4">
                                              <input type="text" name="txtTelefono" class="form-control" id="inputTelefono" placeholder="Telefono">
                                            </div>
                                            <label for="inputDni" class="col-sm-2 col-form-label">Dni</label>
                                            <div class="col-sm-4">
                                              <input type="text" class="form-control" name="txtDni"id="inputDni" placeholder="DNI">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputCorreo" class="col-sm-2 col-form-label">Correo</label>
                                            <div class="col-sm-10">
                                              <input type="text" name="txtCorreo"class="form-control" id="inputCorreo" placeholder="Correo">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputDireccion" class="col-sm-2 col-form-label">Direccion</label>
                                            <div class="col-sm-10">
                                              <input type="text" name="txtDireccion" class="form-control" id="inputDireccion" placeholder="Direccion">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputUsuario" class="col-sm-2 col-form-label">Usuario</label>
                                            <div class="col-sm-4">
                                              <input type="text" class="form-control" name="txtUsuario"id="inputUsuario" placeholder="Usuario">
                                            </div>
                                            <label for="inputPassword" class="col-sm-2 col-form-label">Clave</label>
                                            <div class="col-sm-4">
                                                <input type="password" class="form-control" name="txtClave"id="inputPassword" placeholder="Password">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">Cargo</label>
                                            <div class="col-sm-10">
                                               <select class="form-control" name="cargo">
            
                                                <%
                                                    CargoService car = new CargoServiceImpl();
                                                    List<Cargo> cargos = car.mostrar().stream().filter(e->e.getNombre().equalsIgnoreCase("administrador")||e.getNombre().equalsIgnoreCase("recepcionista"))
                .collect(Collectors.toList());


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
                                        
                                        
                                        
                                       
                                        <input type="hidden" id="operacion" name="operacion" value="registrar_personal">
                                        <div class="d-flex justify-content-center">
                                            <button type="submit" class="btn btn-success m-3">Registrar</button>
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