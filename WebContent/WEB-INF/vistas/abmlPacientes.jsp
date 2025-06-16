<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pacientes</title>
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
		<h1 class="contenedor">PACIENTES</h1>
<div class="contenedor">
	<c:if test="${mensaje!=null}">
		<div class="mensaje" id="mensaje">
			
			<label id="labelAlerta" class="uno">${mensaje}</label>
			
			<button type="button" onclick="cerrarMensaje()" class="btnMensaje">x</button>
		</div>
		</c:if>
		<div>
		<form action="altaPaciente.html">
			<input type=submit value= Agregar class="btn btnVerde bmediano">
		</form>
		</div>
		<table id="tabla" class="display">
	    <thead>
	        <tr>
						<th>Dni</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Fecha Nacimiento</th>
						<th>Direccion</th>
						<th>Localidad</th>
						<th>Correo Electronico</th>
						<th>Telefono</th>
						<th>Acciones</th>
	        </tr>
	    </thead>
	    <tbody>
	     	<c:forEach items="${listaPacientes}" var="paciente">
	     		<c:if test="${paciente.estado == true}">
	     			<tr>
	     			<td>${paciente.dni}</td>
				            <td>${paciente.nombre}</td>
				            <td>${paciente.apellido}</td>
				            <td><fmt:formatDate value="${paciente.fecha_nacimiento}" pattern="dd/MM/yyyy" /></td>
				            <td>${paciente.direccion}</td>
				            <td>${paciente.localidad}</td>
				            <td>${paciente.correo_electronico}</td>
				            <td>${paciente.telefono}</td>
							<td>
		                     <a href = "modificarPaciente${paciente.dni}.html" class = "btn btnAzul bchico">Actualizar</a>
		                     <button class="btn btnRojo bchico" type="button" onclick="abrirModalConfirmacion(${paciente.dni},'${paciente.nombre}','${paciente.apellido}')">Eliminar</button>
		                    </td>
	     		</tr>
	     		</c:if>
	     	</c:forEach>
	    </tbody>
	</table>
		</div>
	</div>
		<div id="modalConfirmacion" class="modal-overlay" style="display: none;">
  <div class="modal-content">
    <h2 id="h2Modal"></h2>
     <br>
     <input type="text" hidden>
     <label>Seguro que desea eliminar el paciente?</label><br>
     <label id="infoModal"></label>
    <br> <br>
    <input id="agarraId" type="text" readonly hidden>
    <div class="botonera">
    <a id="linkEliminar" class="btn btnAzul bchico" href="#">Eliminar</a>
    <button class="btn btnRojo bchico" onclick="cerrarModal()">Cancelar</button>
    </div>
    
  </div>
</div>
	<script type="text/javascript">
function abrirModalConfirmacion(id,nombre,apellido) {
	
 const h2 = document.getElementById('h2Modal');
 const info = document.getElementById('infoModal');
 const agarraId = document.getElementById('agarraId');
 const link = document.getElementById('linkEliminar');
 agarraId.value = id;
 h2.textContent = 'Paciente '+id;
 info.textContent = apellido+", "+nombre+".";
 link.href = 'bajaPaciente' + id + '.html';
	
  $('#modalConfirmacion').show();
}

function cerrarModal() {
  $('#modalConfirmacion').hide();
}

</script>
	<script>
	function cerrarMensaje()
	{
		const alerta = document.getElementById('mensaje');
		mensaje.style.display = 'none';
	}
	</script>

</body>
</html>