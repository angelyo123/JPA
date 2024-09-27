package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.EmpleadoDAO;

public class ServletEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletEliminar() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		empleadoDAO.eliminar(id);

		response.sendRedirect("ServletListar");
	}
}
