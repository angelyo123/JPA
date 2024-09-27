package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empleado;
import modelo.dao.EmpleadoDAO;

public class ServletEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletEditar() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		Empleado empleado = empleadoDAO.BuscarPorId(id);

		request.setAttribute("empleado", empleado);
		request.getRequestDispatcher("editarEmpleado.jsp").forward(request, response);
	}
}
