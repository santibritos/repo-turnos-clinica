<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	<jsp:include page="/WEB-INF/css/adminSideBar.css"></jsp:include>
</style>

<style type="text/css">
	<jsp:include page="/WEB-INF/css/content.css"></jsp:include>
</style>
</head>
<body>
	  <div id="sideBar">
    <div id="brand">
      <img src="${pageContext.request.contextPath}/resources/imagenes/logo.png" class="logoImg"><span>ProyectoClinica</span>
    </div>
   
    <ul class="sidebar">
      <li class="sideItem">
        <a class="sideLink" href="cargarWorkplace.html"><img src="${pageContext.request.contextPath}/resources/imagenes/dashboard_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24.png" class="sideImg"><span>Workplace</span></a>
      </li>
        <li class="sideItem">
          
          <a class="sideLink" href="misPacientes.html"><img src="${pageContext.request.contextPath}/resources/imagenes/groups_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24.png" class="sideImg"><span>Pacientes</span></a>
        </li>
        <li class="sideItem">
          
         <div class="sideUser"><img src="${pageContext.request.contextPath}/resources/imagenes/account_circle_24dp_D9D9D9_FILL0_wght400_GRAD0_opsz24.png" class="sideImg userImg"><span>${user.getUsuario()}</span></div> 
          <a class="sideLink" href="login.html"><img src="${pageContext.request.contextPath}/resources/imagenes/logout_24dp_D9D9D9_FILL0_wght400_GRAD0_opsz24.png" class="sideImg"><span>Cerrar Sesion</span></a>
        </li>
      </ul>
  </div>
</body>
</html>