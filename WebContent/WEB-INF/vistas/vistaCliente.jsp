<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
					<input class="dos" type="button" value="cargar">
				</div>
				<br>
			</c:forEach>
		</div>
		
		
		<div class="contenedor">
		
		
		<h1>PRUEBA PRUEBA</h1>
		
		</div>




	</div>
</div>
</body>
</html>