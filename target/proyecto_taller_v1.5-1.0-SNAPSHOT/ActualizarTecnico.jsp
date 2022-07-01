<%@ page import="com.java.service.TecnicoService" %>
<%@ page import="com.java.Model.entidades.Tecnico" %>
<%@ page import="com.java.service.impl.TecnicoServiceImpl" %>
<%@ page import="com.java.service.CargoService" %>
<%@ page import="com.java.service.impl.CargoServiceImpl" %>
<%@ page import="com.java.Model.entidades.Cargo" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.Model.entidades.Especialidad" %>
<%@ page import="com.java.service.EspecialidadService" %>
<%@ page import="com.java.service.impl.EspecialidadServiceImpl" %>
<!DOCTYPE html>
<html lang="en">
<%
    
%>



<%
    int strCodigo= Integer.parseInt(request.getParameter("codigo"));
//Cargo los datos del alumno.
    TecnicoService tecnicoServic = new TecnicoServiceImpl();
    Tecnico tecnico=tecnicoServic.buscar(strCodigo);

    EspecialidadService especialidad=new EspecialidadServiceImpl();
    List<Especialidad> listEspecialidad= especialidad.mostrar();
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
                                        <h1 class="h4 text-gray-900 mb-4">Actualizar Tecnico</h1>
                                    </div>
                                    
                                    <form action="tecnicoMan" class="user" method="post">
                                        <input type="hidden" name="txtId"  value="<%=tecnico.getIdTecnico()%>">
                                        <div class="form-group row">
                                            
                                            <label for="inputNombre" class="col-sm-2 col-form-label">Nombre</label>
                                            <div class="col-sm-10">
                                                
                                              <input required type="text" pattern="[a-zA-Z ]{3,45}" name="txtNombre" class="form-control" id="inputNombre" placeholder="Nombre" value="<%=tecnico.getNombre()%>">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputApellido" class="col-sm-2 col-form-label">Apellido</label>
                                            <div class="col-sm-10">
                                              <input required pattern="[a-zA-Z ]{3,45}" type="text" name="txtApellido" class="form-control" id="inputApellido" placeholder="Apellido" value="<%=tecnico.getApellido()%>">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="inputTelefono"  class="col-sm-2 col-form-label">Celular</label>
                                            <div class="col-sm-2">
                                              <input pattern="^\d{9}$" type="text" name="txtTelefono" class="form-control" id="inputTelefono" placeholder="Celular" value="<%=tecnico.getTelefono()%>">
                                            </div>
                                            <label for="inputDni" class="col-sm-2 col-form-label">Dni</label>
                                            <div class="col-sm-2">
                                                <input required pattern="^\d{8}$" type="text" class="form-control" name="txtDni"id="inputDni" placeholder="DNI"value="<%=tecnico.getDni()%>">
                                            </div>
                                            <label for="ixputEsperiencia"  class="col-sm-2 col-form-label">Exp. Lab</label>
                                            <div class="col-sm-2">
                                              <input type="text" name="txtExperiencia" class="form-control" id="ixputEsperiencia" placeholder="Experiencia" value="<%=tecnico.getExperiencia()%>">
                                            </div>
                                        </div>
                                         
                                        <div class="form-group row">
                                            <label for="inputCorreo"  class="col-sm-2 col-form-label">Correo</label>
                                            <div class="col-sm-10">
                                              <input type="email" pattern="[a-zA-Z0-9!#$%&'*_+-]([\.]?[a-zA-Z0-9!#$%&'*_+-])+@[a-zA-Z0-9]([^@&%$\/()=?¿!.,:;]|\d)+[a-zA-Z0-9][\.][a-zA-Z]{2,4}([\.][a-zA-Z]{2})?" name="txtCorreo" class="form-control" id="inputCorreo" placeholder="Correo"  value="<%=tecnico.getCorreo()%>">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-3">Especialidades</div>
                                        </div>
                                        <div class="form-group row">

                                            <%
                                                if (listEspecialidad != null) {
                                                    for (Especialidad aux : listEspecialidad) {
                                            %>
                                            <div class="form-check col-sm-12 d-flex flex-column" style="margin-left:100px">
                                                <div class="ml-5">
                                                    <input class="form-check-input" type="checkbox" id="gridCheck1" name="especialidades" value="<%=aux.getIdEspecialidad()%>">
                                                </div>
                                                <div class="ml-5">
                                                    <label class="form-check-label" for="gridCheck1">
                                                        <%=aux.getNombre()%>
                                                    </label>
                                                </div>
                                            </div>
                                            <% }

                                            } %>

                                        </div>
                                     
                                        <div class="form-group row">
                                            <label for="inputUsuario"  class="col-sm-2 col-form-label">Usuario</label>
                                            <div class="col-sm-4">
                                              <input type="text" name="txtUsuario" class="form-control" id="inputUsuario" placeholder="Usuario" value="<%=tecnico.getUsuario()%>">
                                            </div>
                                            <label for="inputClave"  class="col-sm-2 col-form-label">Clave</label>
                                            <div class="col-sm-4">
                                              <input type="text" name="txtClave" class="form-control" id="inputClave" placeholder="Clave" value="<%=tecnico.getClave()%>">
                                            </div>
                                        </div>
                                     
                                        
                                        <div class="form-group row">
                                            <label  class="col-sm-2 col-form-label">Cargo</label>
                                            <div class="col-sm-10">
                                               <select class="form-control" name="cargo">
            
                                                <%
                                                    CargoService car = new CargoServiceImpl();
                                                    List<Cargo> cargos = car.mostrar().stream().filter(e->e.getNombre().equalsIgnoreCase("tecnico"))
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
                                            
                                        
                                       
                                        <input type="hidden" id="tipo" name="tipo" value="actualizar_tecnico">
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