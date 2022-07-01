<%@ page import="com.java.service.TecnicoService" %>
<%@ page import="com.java.Model.entidades.Tecnico" %>
<%@ page import="com.java.service.impl.TecnicoServiceImpl" %>
<!DOCTYPE html>
<html lang="en">
<%
    
%>


<%
    int strCodigo= Integer.parseInt(request.getParameter("codigo"));
//Cargo los datos.
    TecnicoService tecnicoService = new TecnicoServiceImpl();
    Tecnico tecnico=tecnicoService.buscar(strCodigo);
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

<body class="bg-gradient-success vh-100 d-flex align-items-center">

    <div class="container w-75">
        <!-- Outer Row -->
        <div class="row justify-content-center">
            <div class="col-xl-8 col-lg-12 col-md-9">
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                         
                        <div class="row">
                           
                            <div class="col-lg-12">
                                <div class="ml-3 mr-3 p-4">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Eliminar Cliente</h1>
                                    </div>
                                    
                                   <form action="tecnicoMan" class="user" method="post">
                                        <input  type="hidden" name="txtId"  value="<%=tecnico.getIdTecnico()%>">
                                        <div class="form-group row">
                                            
                                            <label for="inputNombre" class="col-sm-2 col-form-label">Nombre</label>
                                            <div class="col-sm-10">
                                                
                                              <input readonly type="text" name="txtNombre" class="form-control" id="inputNombre" placeholder="Nombre" value="<%=tecnico.getNombre()%>">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputApellido" class="col-sm-2 col-form-label">Apellido</label>
                                            <div class="col-sm-10">
                                              <input readonly  type="text" name="txtApellido" class="form-control" id="inputApellido" placeholder="Apellido" value="<%=tecnico.getApellido()%>">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputTelefono"  class="col-sm-2 col-form-label">Telefono</label>
                                            <div class="col-sm-4">
                                              <input readonly  type="text" name="txtTelefono" class="form-control" id="inputTelefono" placeholder="Telefono" value="<%=tecnico.getTelefono()%>">
                                            </div>
                                            <label for="ixputEsperiencia"  class="col-sm-2 col-form-label">Expe.</label>
                                            <div class="col-sm-4">
                                              <input readonly  type="text" name="txtExperiencia" class="form-control" id="ixputEsperiencia" placeholder="Experiencia" value="<%=tecnico.getExperiencia()%>">
                                            </div>
                                        </div>
                                         
                                        <div class="form-group row">
                                            <label for="inputCorreo"  class="col-sm-2 col-form-label">Correo</label>
                                            <div class="col-sm-10">
                                              <input readonly  type="text" name="txtCorreo" class="form-control" id="inputCorreo" placeholder="Correo"  value="<%=tecnico.getCorreo()%>">
                                            </div>
                                        </div>
                                       

                                      
                                        <div class="form-group row">
                                            <label for="inputUsuario"  class="col-sm-2 col-form-label">Usuario</label>
                                            <div class="col-sm-4">
                                              <input readonly  type="text" name="txtUsuario" class="form-control" id="inputUsuario" placeholder="Usuario" value="<%=tecnico.getUsuario()%>">
                                            </div>
                                            <label for="inputClave"  class="col-sm-2 col-form-label">Clave</label>
                                            <div class="col-sm-4">
                                              <input  readonly type="text" name="txtClave" class="form-control" id="inputClave" placeholder="Clave" value="<%=tecnico.getClave()%>">
                                            </div>
                                        </div>
                                       
                                        
                                        <div class="form-group row">
                                            <label for="inputCargo" class="col-sm-2 col-form-label">Cargo</label>
                                            <div class="col-sm-10">
                                              <input  readonly type="text" name="txtClave" class="form-control" id="inputCargo" placeholder="Clave" value="<%=tecnico.getCargo().getNombre()%>">
                                            </div>
                                        </div>    
                                            
                                        
                                       
                                        <input type="hidden" id="tipo" name="tipo" value="eliminar_tecnico">
                                        <div class="d-flex justify-content-center">
                                            <button type="submit" class="btn btn-danger m-3">Eliminar</button>
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