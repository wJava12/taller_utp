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
<link href="css/myStyle2.css">
<div class="form-group row ">
<label class="col-sm-2 col-form-label">Mes: </label>
<div class="col-sm-2">
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
 <div id="calendario" class="divs">


</div>


<script src="js/calendario.js">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</script>
<jsp:include page="Footer.jsp"/>
