package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Departamento;
import modelo.Empleado;
import modelo.dao.DepartamentoDAO;
import modelo.dao.EmpleadoDAO;

public class ServletActualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletActualizar() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String nombre = request.getParameter("nombre");
	    String apellido = request.getParameter("apellido");
	    double salario = Double.parseDouble(request.getParameter("salario"));
	    int idDepartamento = Integer.parseInt(request.getParameter("idDepartamento"));

	    // Obtener el objeto Departamento usando el DAO
	    DepartamentoDAO departamentoDAO = new DepartamentoDAO();
	    Departamento departamento = departamentoDAO.obtenerPorId(idDepartamento); // Asegúrate de que este método existe

	    // Crear el objeto Empleado con el objeto Departamento
	    Empleado empleado = new Empleado(nombre, apellido, salario, departamento);
	    
	    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
	    empleadoDAO.actualizar(empleado);

	    response.sendRedirect("ServletListar");
	}
}
