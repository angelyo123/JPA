<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MENSAJE DE REGISTRO</title>
</head>
<body>
    <h1>Resultado de Registro</h1>
    <%
        String mensaje = (String) request.getAttribute("mensaje");
        String errores = (String) request.getAttribute("errores");

        if (mensaje != null) {
            out.println("<p style='color: green;'>" + mensaje + "</p>");
        }

        if (errores != null) {
            out.println("<p style='color: red;'>" + errores + "</p>");
        }
    %>
    <a href="agregarEmpleado.jsp">Volver a agregar empleado </a>
    <a href="ServletListar">Volver a la lista ;b</a>
    
</body>
</html>