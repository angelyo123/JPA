<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Editar Empleado</h2>
<form action="actualizarEmpleado" method="post">
    <input type="hidden" name="id" value="${empleado.id}">
    
    <label for="nombre">Nombre:</label>
    <input type="text" name="nombre" value="${empleado.nombre}" required><br>

    <label for="apellido">Apellido:</label>
    <input type="text" name="apellido" value="${empleado.apellido}" required><br>

    <label for="salario">Salario:</label>
    <input type="number" name="salario" value="${empleado.salario}" step="0.01" required><br>

    <label for="idDepartamento">Departamento:</label>
    <input type="number" name="idDepartamento" value="${empleado.idDepartamento}" required><br>

    <button type="submit">Actualizar</button>
</form>
<a href="listarEmpleados">Cancelar</a>
</body>
</html>