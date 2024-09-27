package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Departamento;
import modelo.Empleado;
import modelo.dao.DepartamentoDAO;
import modelo.dao.EmpleadoDAO;

public class ServletInsertar extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ServletInsertar() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener la lista de departamentos
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        List<Departamento> departamentos = departamentoDAO.listar();

        // Enviar la lista de departamentos al JSP
        request.setAttribute("departamentos", departamentos);
        request.getRequestDispatcher("agregarEmpleado.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros del formulario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String salarioStr = request.getParameter("salario");
        String idDepartamentoStr = request.getParameter("departamento");

        // Validaciones
        StringBuilder errores = new StringBuilder();

        // Validar nombre (solo caracteres alfabéticos)
        if (nombre == null || nombre.trim().isEmpty() || !nombre.matches("[a-zA-Z]+")) {
            errores.append("El nombre debe contener solo caracteres alfabéticos.<br>");
        }

        // Validar apellido (solo caracteres alfabéticos)
        if (apellido == null || apellido.trim().isEmpty() || !apellido.matches("[a-zA-Z]+")) {
            errores.append("El apellido debe contener solo caracteres alfabéticos.<br>");
        }

        // Validar salario (debe ser un número decimal con hasta dos decimales)
        double salario = 0;
        if (salarioStr == null || salarioStr.trim().isEmpty()) {
            errores.append("El salario no puede estar vacío.<br>");
        } else {
            try {
                salario = Double.parseDouble(salarioStr);
                if (salario <= 0) {
                    errores.append("El salario debe ser un valor positivo.<br>");
                } else if (!salarioStr.matches("\\d+(\\.\\d{1,2})?")) {
                    errores.append("El salario debe tener hasta dos decimales.<br>");
                }
            } catch (NumberFormatException e) {
                errores.append("El salario debe ser un número válido.<br>");
            }
        }
        
        if (salario < 1200 || salario > 52000) {
            errores.append("El salario debe estar entre 1200 y 52000.<br>");
        }

        // Validar ID de departamento (debe ser un entero)
        int idDepartamento = 0;
        if (idDepartamentoStr == null || idDepartamentoStr.trim().isEmpty()) {
            errores.append("El ID de departamento no puede estar vacío.<br>");
        } else {
            try {
                idDepartamento = Integer.parseInt(idDepartamentoStr);
                if (idDepartamento <= 0) {
                    errores.append("El ID de departamento debe ser un entero positivo.<br>");
                }
            } catch (NumberFormatException e) {
                errores.append("El ID de departamento debe ser un número entero válido.<br>");
            }
        }

        // Si hay errores, recargar la lista de departamentos y mostrar los errores
        if (errores.length() > 0) {
            DepartamentoDAO departamentoDAO = new DepartamentoDAO();
            List<Departamento> departamentos = departamentoDAO.listar();

            request.setAttribute("departamentos", departamentos);  // Volver a cargar los departamentos
            request.setAttribute("errores", errores.toString());  // Enviar los errores
            request.getRequestDispatcher("agregarEmpleado.jsp").forward(request, response);
            return;
        }

        // Obtener el objeto Departamento correspondiente
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();  // Declaración única
        Departamento nomDepartamento = departamentoDAO.obtenerPorId(idDepartamento);

        // Validar que el departamento exista
        if (nomDepartamento == null) {
            List<Departamento> departamentos = departamentoDAO.listar();  // Reutilizar la variable

            request.setAttribute("departamentos", departamentos);  // Volver a cargar los departamentos
            request.setAttribute("errores", "El departamento seleccionado no existe.<br>");
            request.getRequestDispatcher("agregarEmpleado.jsp").forward(request, response);
            return;
        }

        // Crear un objeto Empleado con el constructor adecuado
        Empleado nuevoEmpleado = new Empleado(nombre, apellido, salario, nomDepartamento);

        // Intentar insertar el empleado en la base de datos
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        boolean exito = empleadoDAO.insertar(nuevoEmpleado) > 0;

        // Mostrar mensaje de éxito o error
        if (exito) {
            request.setAttribute("mensaje", "Registro exitoso.");
        } else {
            request.setAttribute("errores", "Error al registrar el empleado. Intente nuevamente.");
        }

        // Redirigir al JSP para mostrar el mensaje
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }

}
