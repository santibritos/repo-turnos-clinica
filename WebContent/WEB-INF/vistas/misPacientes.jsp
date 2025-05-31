<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mis Pacientes</title>
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
<style>
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 999;
  display: flex;
  align-items: center;
  justify-content: center;
}

.modal-content {
  background-color: white;
  padding: 20px;
  border-radius: 10px;
}
</style>
</head>
<body>
<%@include file="clienteSideBar.jsp"%>
<div class="main-content">
	<h1 class="contenedor">Mis Pacientes</h1>
	<div class="contenedor">
	
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
		                     <button class="btn btnAzul bmediano"
  							 onclick="abrirModalHistoriaClinica('${paciente.dni}','${medico.legajo}')">Historia Clinica</button>
		                    </td>
	     		</tr>
	     		</c:if>
	     	</c:forEach>
	    </tbody>
	</table>
	</div>
	<!-- Modal -->
<div id="modalHistoriaClinica" class="modal-overlay" style="display: none;">
  <div class="modal-content">
    <h2>Historia Clínica</h2>
     <br> <br>
    <textarea id="textareaHistoria" rows="10" cols="60" readonly></textarea>
    <br> <br>
    <button class="btn btnAzul bchico" onclick="cerrarModal()">Cerrar</button>
  </div>
</div>


</div>
<script type="text/javascript">
function abrirModalHistoriaClinica(dni, legajo) {
  // Mostrar el modal
  $('#modalHistoriaClinica').show();

  // Llamar al backend para obtener la historia clínica
  $.ajax({
    url: 'traerHistoriaClinica.html', // endpoint 
    method: 'GET',
    data: { medicoId: legajo,pacienteId: dni },
    success: function(respuesta) {
      $('#textareaHistoria').val(respuesta);
    },
    error: function() {
      $('#textareaHistoria').val("Error al cargar historia clínica.");
    }
  });
}

function cerrarModal() {
  $('#modalHistoriaClinica').hide();
  $('#textareaHistoria').val('');
}
</script>
</body>
</html>