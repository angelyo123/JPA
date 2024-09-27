package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Departamento;
import modelo.dao.DepartamentoDAO;

/**
 * Servlet implementation class ServletListarDepartamentos
 */
public class ServletListarDepartamentos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarDepartamentos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener la lista de departamentos
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        List<Departamento> departamentos = departamentoDAO.listar();

        // Enviar la lista de departamentos al JSP
        request.setAttribute("departamentos", departamentos);
        request.getRequestDispatcher("agregarEmpleado.jsp").forward(request, response);
        System.out.println(departamentos);
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);  // Redirigir el POST al método GET por si acaso
    }
}
