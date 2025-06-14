<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Medicos</title>
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/2.2.2/css/dataTables.dataTables.css" />

<script src="https://cdn.datatables.net/2.2.2/js/dataTables.js"></script>


	<script type="text/javascript">

$(document).ready( function () {
    $('#tabla').DataTable();
    console.log('hola');
} );

</script>
</head>
<body>
<%@include file="adminSideBar.jsp"%>

<div class="main-content">

	<h1 class="contenedor">MEDICOS</h1>


<div class="contenedor" >
		<div>
		<c:if test="${mensaje!=null}">
		<div class="mensaje" id="mensaje">
			
			<label id="labelAlerta" class="uno">${mensaje}</label>
			
			<button type="button" onclick="cerrarMensaje()" class="btnMensaje">x</button>
		</div>
		</c:if>
		<form action="AgregarMedico.html">
			<input type=submit value= Agregar class="btn btnVerde bmediano">
		</form>
		</div>
		<table id="tabla" class="display">
	    <thead>
	        <tr>
	          			<th>Legajo</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Direccion</th>
						<th>Localidad</th>
						<th>Correo Electronico</th>
						<th>Telefono</th>
						<th style="min-width:200px">Horarios</th>
						<th>Especialidad</th>
						<th>Usuario</th>
						<th>Acciones</th>
	        </tr>
	    </thead>
	    <tbody>
	     	<c:forEach items="${listaMedicos}" var="medico">
	     		<c:if test="${medico.estado == true}">
	     			<tr>
	     			<td>${medico.legajo}</td>
				            <td>${medico.nombre}</td>
				            <td>${medico.apellido}</td>
				            <td>${medico.direccion}</td>
				            <td>${medico.localidad}</td>
				            <td>${medico.correoElectronico}</td>
				            <td>${medico.telefono}</td>
				           
				            <td>
				            <c:forEach items="${medico.listaHorarios}" var="horario">
				            <c:if test="${horario.entrada != null}">
				            ${horario.dia}:<br>${horario.entrada}-${horario.salida}<br>
				            </c:if>
				            </c:forEach>
				            </td>
				            
				            <td>${medico.especialidad.nombre}</td>
				            <td>${medico.usuario.usuario}</td>
							<td>
		                        <a href = "modificarMedico${medico.legajo}.html" class = "btn btnAzul bchico">Actualizar</a>
		                     <button class="btn btnRojo bchico" type="button" onclick="abrirModalConfirmacion(${medico.legajo},'${medico.nombre}','${medico.apellido}','${medico.especialidad.nombre}')">Eliminar</button>
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
     <label>Seguro que desea eliminar el Medico?</label><br>
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
function abrirModalConfirmacion(id,nombre,apellido,especialidad) {
	
 const h2 = document.getElementById('h2Modal');
 const info = document.getElementById('infoModal');
 const agarraId = document.getElementById('agarraId');
 const link = document.getElementById('linkEliminar');
 agarraId.value = id;
 h2.textContent = 'Medico '+id;
 info.textContent = apellido+", "+nombre+" ("+especialidad+").";
 link.href = 'bajaMedico' + id + '.html';
	
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