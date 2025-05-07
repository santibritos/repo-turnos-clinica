<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		PAGINA 2
		<h3>Id: ${user.toString()}</h3>
		<h3>${user.getUsuario()}</h3>
		
		
		<form method="post" action="modificarNombre.html">
		<h4>${user.getUsuario()} edad: ${edad}</h4>
		<lablel>sesion:${session1.nombre}</lablel>
		<input type="submit" value="Hola">
		</form>
</body>
</html>