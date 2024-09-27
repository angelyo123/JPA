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

public class ServletListar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletListar() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
	    List<Empleado> listaEmpleados = empleadoDAO.listar();
	    
	    // Imprimir en consola para depuración
	    System.out.println("Lista de Empleados: " + listaEmpleados);
	    
	    request.setAttribute("listaEmpleados", listaEmpleados);
	    request.getRequestDispatcher("listaEmpleados.jsp").forward(request, response);
	}


}
