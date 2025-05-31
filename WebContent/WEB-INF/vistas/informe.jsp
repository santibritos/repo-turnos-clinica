<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Informe</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
<%@ include file="adminSideBar.jsp" %>
<div class="main-content">
	<h1 class="contenedor">Informe</h1>
	
		<div  style="width: 500px; height: 400px;" class="contenedor">
			<h2>Turnos por día</h2>
			<canvas id="gTorta" width="400px" height="200px"></canvas>
		</div>
		<div  style="width: 500px; height: 400px;" class="contenedor">
			<h2>Grafico Barra</h2>
			<canvas id="gBarra" width="400px" height="200px"></canvas>
		</div>
	


</div>
<script>
    const ctx = document.getElementById('gTorta').getContext('2d');
    const gTorta = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: ${labels},
            datasets: [{
                label: 'Cantidad de turnos',
                data: ${data},
            }]
        },
        options: {
            scales: {
                y: { beginAtZero: true }
            }
        }
    });
    const ctx2 = document.getElementById('gBarra').getContext('2d');
    const gBarra = new Chart(ctx2, {
        type: 'bar',
        data: {
            labels: ${labels},
            datasets: [{
                label: 'Cantidad de turnos',
                data: ${data},
            }]
        },
        options: {
            scales: {
                y: { beginAtZero: true }
            }
        }
    });
    
</script>
</body>
</html>