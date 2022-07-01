<%@ page import="com.java.service.ArticuloService" %>
<%@ page import="com.java.Model.entidades.Articulo" %>
<%@ page import="com.java.service.impl.ArticuloServiceImpl" %>
<!DOCTYPE html>
<html lang="en">
<%
    
%>



<%
    int strCodigo= Integer.parseInt(request.getParameter("codigo"));
//Cargo los datos del alumno.
    ArticuloService articuloServic = new ArticuloServiceImpl();
    Articulo articulo=articuloServic.buscar(strCodigo);
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

    <div class="container w-50">
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
                                        <h1 class="h4 text-gray-900 mb-4">Eliminar Articulo</h1>
                                    </div>
                                    
                                    <form action="articuloMan" class="user" method="post">
                                        <input type="hidden" name="txtId"  value="<%=articulo.getIdArticulo()%>">
                                        <div class="form-group row">
                                            
                                            <label for="inputNombre" class="col-sm-4 col-form-label">Nombre</label>
                                            <div class="col-sm-8">
                                                
                                              <input readonly type="text" name="txtNombre" class="form-control" id="inputNombre" placeholder="Nombre" value="<%=articulo.getNombre()%>">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputApellido" class="col-sm-4 col-form-label">Cantidad</label>
                                            <div class="col-sm-8">
                                                <input readonly type="text" name="txtCantidad" class="form-control" id="inputApellido" placeholder="Cantidad" value="<%=articulo.getCantidad()%>">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputTelefono"  class="col-sm-4 col-form-label">Precio</label>
                                            <div class="col-sm-8">
                                              <input readonly type="text" name="txtPrecio" class="form-control" id="inputTelefono" placeholder="Precio" value="<%=articulo.getPrecio()%>">
                                            </div>
                                        </div>
                                                                              
                                        
                                       
                                        <input type="hidden" id="tipo" name="tipo" value="eliminar_articulo">
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