
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.format.FormatStyle" %>
<%@ page import="java.time.ZonedDateTime" %><%--
    Document   : Header
    Created on : 29 may. 2022, 09:32:24
    Author     : 
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%
    if (request.getSession().getAttribute("strAdmCodigo") == null) {
        response.sendRedirect("login.jsp");
    }
    ZonedDateTime now = ZonedDateTime.now();
    String strAdministrador = String.valueOf(session.getAttribute("strAdmNombre"));
    String strCargo = String.valueOf(session.getAttribute("strCargo"));
    /*Date dNow = new Date();
    SimpleDateFormat ft =  new SimpleDateFormat("dd/MM/yyyy");
    String currentDate = ft.format(dNow);*/
    DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
    formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
    System.out.println(now.format(formatter));
%>


<!DOCTYPE html>
<html lang="en">

<head>

    <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″ />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Menus</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top ">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-success sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class=" sidebar-brand d-flex align-items-center justify-content-center " href=".html">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-home"></i>
            </div>
            <div class="sidebar-brand-text mx-3"><%=strCargo%>
            </div>

        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
            <a class="nav-link" href="index.html">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Panel de control</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">


        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
               aria-expanded="true" aria-controls="collapseTwo">
                <i class="fas fa-fw fa-cog"></i>
                <span>Personal</span>
            </a>
            <%
                if(strCargo.equals("ADMINISTRADOR"))
                {
            %>
            <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <a class="collapse-item" href="mantenimientoPersonal.jsp">Mantenimiento</a>

                </div>
            </div>
            <%

                } %>
        </li>

        <!-- Nav Item - Utilities Collapse Menu -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities1"
               aria-expanded="true" aria-controls="collapseUtilities1">
                <i class="fas fa-fw fa-wrench"></i>
                <span>Repuestos</span>
            </a>
                    <%
                        if(strCargo.equals("ADMINISTRADOR"))
                        {
                    %>
            <div id="collapseUtilities1" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                    <a class="collapse-item" href="mantenimientoArticulo.jsp">Mantenimiento</a>
                    </div>
            </div>
                        <%

                    } %>


         </li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
               aria-expanded="true" aria-controls="collapseUtilities">
                <i class="fas fa-fw fa-wrench"></i>
                <span>Servicios</span>
            </a>
            <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <a class="collapse-item" href="ServicioPendiente.jsp">Servicio pendientes</a>
                    <a class="collapse-item" href="Principal.jsp">Servicio a Domicilo</a>
                    <a class="collapse-item" href="EstadoDeServicios.jsp">Servicio en Taller</a>

                </div>

            </div>

        </li>
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities6"
               aria-expanded="true" aria-controls="collapseUtilities">
                <i class="fas fa-fw fa-wrench"></i>
                <span>Tecnicos</span>
            </a>
            <%
                if(strCargo.equals("ADMINISTRADOR"))
                {
            %>
            <div id="collapseUtilities6" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <a class="collapse-item" href="mantenimientoTecnico.jsp">Mantenimiento</a>
                    <a class="collapse-item" href="RegistrarProgramacion.jsp">Registro Horario</a>
                    <a class="collapse-item" href="HorariosTecnicos.jsp">Ver Horarios</a>
                </div>

            </div>
            <%

                } %>

        </li>
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities7"
               aria-expanded="true" aria-controls="collapseUtilities">
                <i class="fas fa-fw fa-wrench"></i>
                <span>Clientes</span>
            </a>
            <div id="collapseUtilities7" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <a class="collapse-item" href="mantenimientoCliente.jsp">Mantenimiento</a>

                </div>

            </div>

        </li>
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities8"
               aria-expanded="true" aria-controls="collapseUtilities">
                <i class="fas fa-fw fa-wrench"></i>
                <span>Electrodomestico</span>
            </a>
            <div id="collapseUtilities8" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <a class="collapse-item" href="mantenimientoArtefacto.jsp">Mantenimiento</a>

                </div>

            </div>

        </li>
        <!-- Divider -->
        <hr class="sidebar-divider">


    </ul>
    <!-- End of Sidebar -->


    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">


            <!-- Topbar -->
            <nav class="  navbar navbar-expand navbar-light bg-white topbar mb-3 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>


                <!-- Topbar Navbar -->
                <ul class=" navbar-nav ml-auto">
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link"
                            aria-haspopup="true" aria-expanded="false">

                            <div class="mr-2 d-none d-lg-inline text-gray-600 small">Fecha: <%=now.format(formatter)%></div>

                        </a>
                    </li>

                    <div class="topbar-divider d-none d-sm-block"></div>

                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">

                            <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=strAdministrador%></span>

                            <img class="img-profile rounded-circle"
                                 src="img/undraw_profile.svg">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Perfil
                            </a>

                            <a class="dropdown-item" href="#">
                                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                Configuraciones
                            </a>

                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Cerrar
                            </a>
                        </div>
                    </li>

                </ul>

            </nav>
            <!-- End of Topbar -->