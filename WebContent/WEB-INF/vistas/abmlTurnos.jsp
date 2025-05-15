<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Proyecto Clinica</title>
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/2.2.2/css/dataTables.dataTables.css" />

<script src="https://cdn.datatables.net/2.2.2/js/dataTables.js"></script>
<script type="text/javascript">

$(document).ready( function () {
    $('#tabla').DataTable();
} );
</script>
</head>
<body>
	<%@include file="adminSideBar.jsp" %>

	<div class="main-content">
		<h1 class="contenedor">TURNOS</h1>
<div class="contenedor">
		<div>
		<form action="altaTurno.html">
			<input type=submit value= Agregar class="btn btnVerde bmediano">
		</form>
		</div>
		<table id="tabla" class="display">
	    <thead>
	        <tr>
						<th>Id</th>
						<th>Fecha</th>
						<th>Hora</th>
						<th>Dni paciente</th>
						<th>Legajo Medico</th>
						<th>Estado</th>
						<th>Acciones</th>
	        </tr>
	    </thead>
	    <tbody>
	     	<c:forEach items="${listaTurnos}" var="turno">
	     			<tr>
	     				<td>${turno.id}</td>
				            <td><fmt:formatDate value="${turno.fecha}" pattern="dd/MM/yyyy" /></td>
				            <td>${turno.hora}</td>
				            <td>${turno.paciente.dni}</td>
				            <td>${turno.medico.legajo}</td>
				            <td>${turno.estado}</td>
							<td>
		                     <a href = "modificarTurno${turno.id}.html" class = "btn btnAzul bchico">Actualizar</a>
		                     <a href = "bajaTurno${turno.id}.html" class = "btn btnRojo bchico">Delete</a><br/>
		                    </td>
	     		</tr>
	     	</c:forEach>
	    </tbody>
	</table>
		</div>
	</div>
</body>
</html>