<%@ page import="com.java.Model.entidades.TipoServicio" %>
<%@ page import="com.java.service.TipoServicioService" %>
<%@ page import="com.java.service.impl.TipoServicioServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.java.Model.entidades.Especialidad" %>
<%@ page import="com.java.service.EspecialidadService" %>
<%@ page import="com.java.service.impl.EspecialidadServiceImpl" %><%--
    Document   : mantenimientoArticulos
    Created on : 29 may. 2022, 14:38:42
    Author     :
--%>



<jsp:include page="Header.jsp"/>
<%
  EspecialidadService objEspecialidadServicio=new EspecialidadServiceImpl();
  List<Especialidad> tipos= objEspecialidadServicio.mostrar();

%>
`
<div class="p-0 ml-2 mr-2 row d-flex justify-content-center">
  <div class="card col-md-3 m-2 " style="width: 18rem;">
    <img class="img-fluid" src="" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">INSTALACIONES</h5>
      <p class="card-text">Deja la instalacion de tus artefactos en manos de los expertos</p>
      <a href="ServicioDomicilio.jsp?codigo=<%=tipos.get(0).getIdEspecialidad()%>" class="btn btn-primary">Ver
        Tecnicos
      </a>
    </div>
  </div>
  <div class="card col-md-3 m-2" style="width: 18rem;">
    <img src="..." class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">REPARACIONES</h5>
      <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
      <a href="ServicioDomicilio.jsp?codigo=<%=tipos.get(1).getIdEspecialidad()%>" class="btn btn-primary">Ver
        Tecnicos
      </a>
    </div>
  </div>
  <div class="card col-md-3 m-2" style="width: 18rem;">
    <img src="..." class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">CONVERSIONES</h5>
      <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
      <a href="ServicioDomicilio.jsp?codigo=<%=tipos.get(2).getIdEspecialidad()%>" class="btn btn-primary">Ver
        Tecnicos
      </a>
    </div>
  </div>

</div>
<div class="ml-2 mr-2 row d-flex justify-content-center">
  <div class="card col-md-3 m-2 " style="width: 18rem;">
    <img src="..." class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">MANTENIMIENTO</h5>
      <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
      <a href="ServicioDomicilio.jsp?codigo=<%=tipos.get(3).getIdEspecialidad()%>" class="btn btn-primary">Ver
        Tecnicos
      </a>
    </div>
  </div>
  <div class="card col-md-3 m-2" style="width: 18rem;">
    <img src="..." class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">ASESORIA TECNICA</h5>
      <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
      <a href="ServicioDomicilio.jsp?codigo=<%=tipos.get(4).getIdEspecialidad()%>" class="btn btn-primary">Ver
        Tecnicos
      </a>
    </div>
  </div>
  <div class="card col-md-3 m-2" style="width: 18rem;">
    <img src="..." class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">ESTUDIO DE FACTIBILIDAD</h5>
      <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
      <a href="ServicioDomicilio.jsp?codigo=<%=tipos.get(5).getIdEspecialidad()%>" class="btn btn-primary">Ver
        Tecnicos
      </a>
    </div>
  </div>



</div>


<jsp:include page="Footer.jsp"/>
