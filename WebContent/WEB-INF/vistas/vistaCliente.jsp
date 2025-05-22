<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/2.2.2/css/dataTables.dataTables.css" />

<script src="https://cdn.datatables.net/2.2.2/js/dataTables.js"></script>
</head>
<body>
<%@include file="clienteSideBar.jsp"%>
<div class="main-content">
	<h3 class="contenedor"> Turno siguiente:</h3>
	
	<div class="columnas-workplace">
		<div class="contenedor cards uno">
			
			<c:forEach items="${listaTurnos}" var="turno">
				<div class="card">
					<div class="card-content uno">
						<label>${turno.hora}</label>
						<label>${turno.paciente.nombre} ${turno.paciente.apellido}</label>
					</div>
					<a type="text" name="txtId" href="cargarTurnoActual.html?id=${turno.id}">Cargar</a>
				</div>
				<br>
			</c:forEach>
			
		</div>
		
		
		<div class="contenedor">
		
		
		<h1>PRUEBA PRUEBA</h1>
		
		<div>
		<c:if test="${turnoActual != null}">
			<table id="tabla">
				<thead>
					<tr>
						<th>Paciente</th>
						<th>Dni</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${turnoActual.paciente.nombre} ${turnoActual.paciente.apellido}</td>
						<td>${turnoActual.paciente.dni}</td>
					</tr>
				</tbody>
			
			</table>
			</c:if>
		</div>
		
		</div>




	</div>
</div>
</body>
</html>