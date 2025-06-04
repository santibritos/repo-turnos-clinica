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
		
		<div>
			<div class="contenedor" style="height:50px; width: 400px; gap:5px; display: flex; flex-direction: column" >
			<h4>Turnos por especialidad: </h4> 
			<select id="selectTorta">
			<option value="15">Ultimos 15 dias</option>
			<option value="30">Ultimos 30 dias</option>
			<option value="365">Año actual</option>
			<option value="730">Año pasado</option>
			</select>
			</div>
			
			<div  style="width: 400px; height: 400px; padding: 20px" class="contenedor">
				<canvas id="gTorta"></canvas>
			</div>
		</div>
		
		<div  style="width: 700px; height: 400px;" class="contenedor">
			<h4>Turnos totales:</h4>
			<select id="selectLinea">
			<option value="todos">Todos</option>
			<option value="cancelado">Cancelados</option>
			<option value="pendiente">Pendientes</option>
			<option value="completado">Completados</option>
			</select>
			<canvas id="gLinea" width="400px" height="200px"></canvas>
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
        	  responsive: true,
        	  plugins: {
        	    legend: {
        	      position: 'top',
        	    },
        	    title: {
        	      display: true,
        	      text: 'Turnos por Especialidad'
        	    }
        	  }
        	}
    });
 

const options = document.getElementById('selectTorta');

options.addEventListener('change',()=>{
	
	fetch('devuelveTurnosHaceXdias.html?dias='+options.value)
	.then(response => response.json())
	 .then(data => {
		 console.log("Respuesta cruda:", data)
		 
	 		let especialidades = new Array();
		 	let turnos = new Array();
		 
		 	data.forEach(reg =>{
		 		
		 		turnos.push(reg[0]);
		 		especialidades.push(reg[1]);
		 	})
		 
		 	console.log('LABELS '+especialidades);
		 	console.log('DATA '+turnos);
		 
		 	gTorta.data.labels = especialidades;
		 	gTorta.data.datasets[0].data = turnos;
		 	gTorta.update();
		 
	 })
	.catch(error => console.error('Error:', error))
});

</script>

<script>
    const ctx2 = document.getElementById('gLinea').getContext('2d');
    const añoActual = new Date().getFullYear();
	const añoPasado = añoActual-1;
    const gLinea = new Chart(ctx2, {
        type: 'line',
        data: {
          labels: ${meses},
          datasets: [
            {
              label: añoPasado,
              data: ${turnosAñoPasado},
              borderColor: 'rgba(54, 162, 235, 1)',
              backgroundColor: 'rgba(54, 162, 235, 0.2)',
              tension: 0.3,
              fill: false
            },
            {
              label: añoActual,
              data: ${turnosAñoActual},
              borderColor: 'rgba(255, 99, 132, 1)',
              backgroundColor: 'rgba(255, 99, 132, 0.2)',
              tension: 0.3,
              fill: false
            }
          ]
        },
        options: {
          responsive: true,
          plugins: {
            title: {
              display: true,
              text: 'Comparativa de Ventas Mensuales'
            },
            tooltip: {
              mode: 'index',
              intersect: false
            },
            legend: {
              position: 'top'
            }
          },
          interaction: {
            mode: 'nearest',
            axis: 'x',
            intersect: false
          },
          scales: {
            y: {
              beginAtZero: true
            }
          }
        }
      });
    
    const selectLinea = document.getElementById('selectLinea');
    
    selectLinea.addEventListener('change', () => {
    	
    	console.log(añoActual);
    	console.log(añoPasado);
    	  Promise.all([
    	    fetch('devuelveTurnosPorEstadoYyear.html?estado=' + selectLinea.value + '&year='+añoActual).then(r => r.json()),
    	    fetch('devuelveTurnosPorEstadoYyear.html?estado=' + selectLinea.value + '&year='+añoPasado).then(r => r.json())
    	  ])
    	  .then(([datosActuales, datosPasados]) => {
    	    console.log('data de glinea año Actual: ' + datosActuales);
    	    console.log('data de glinea año Pasado: ' + datosPasados);

    	    gLinea.data.datasets[0].data = datosPasados;
    	    gLinea.data.datasets[1].data = datosActuales;
    	    gLinea.update();
    	  })
    	  .catch(error => console.error('Error al obtener los datos:', error));
    	});
    
</script>
</body>
</html>