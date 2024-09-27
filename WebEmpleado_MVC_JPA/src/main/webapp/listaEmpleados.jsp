<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Empleados</title>
</head>
<body>
    <h2>Lista de Empleados</h2>
    <a href="ServletListarDepartamentos">Agregar Empleado</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Salario</th>
            <th>Departamento</th>
            <th>Acciones</th>
        </tr>
        <c:if test="${not empty listaEmpleados}">
            <c:forEach var="empleado" items="${listaEmpleados}">
                <tr>
                    <td>${empleado.id}</td>
                    <td>${empleado.nombre}</td>
                    <td>${empleado.apellido}</td>
                    <td>${empleado.salario}</td>
                    <td>${empleado.departamento.nombre}</td>
                    <td>
                        <a href="editarEmpleado?id=${empleado.id}">Editar</a>
                        <a href="eliminarEmpleado?id=${empleado.id}" onclick="return confirm('¿Estás seguro de que deseas eliminar este empleado?');">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${empty listaEmpleados}">
            <tr>
                <td colspan="6">No hay empleados registrados.</td>
            </tr>
        </c:if>
    </table>
</body>
</html>
