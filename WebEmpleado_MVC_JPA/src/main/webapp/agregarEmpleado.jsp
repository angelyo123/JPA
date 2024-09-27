<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Agregar Empleado</title>
</head>
<body>
	<c:if test="${not empty errores}">
		<div style="color: red;">
			<c:out value="${errores}" escapeXml="false" />
		</div>
	</c:if>

	<h2>Agregar Empleado</h2>
	<form action="ServletInsertar" method="post">
		Nombre: <input type="text" name="nombre" required /><br /> Apellido:
		<input type="text" name="apellido" required /><br /> Salario: <input
			type="number" name="salario" required /><br /> Departamento: <select
			name="departamento" required>
			<option value="">Seleccione un Departamento</option>
			<c:forEach var="departamento" items="${departamentos}">
				<option value="${departamento.id}">${departamento.nombre}</option>
			</c:forEach>
		</select><br /> <input type="submit" value="Agregar Empleado" />
	</form>
</body>
</html>
