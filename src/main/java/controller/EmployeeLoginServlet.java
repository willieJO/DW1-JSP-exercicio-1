package controller;

import java.io.IOException;

import dao.EmployeeDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee; 


/**
 * Servlet implementation class EmployeeLoginServlet
 */
@WebServlet("/EmployeeLogin")
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLoginServlet() {
        super();
        dao = new EmployeeDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeeLogin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");

            Employee employee = new Employee();
            employee.setUsername(login);
            employee.setPassword(senha);
            System.err.println("Entrarei no dao");
            int id = dao.loginEmployee(employee);
            if (id > 0) {
            	System.err.println("if");
            	request.setAttribute("id", id );
            	System.out.println(id);
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/dadosEmpregado.jsp");
        		dispatcher.forward(request, response);
            } else {
            	System.err.println("else");
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeeLogin.jsp");
        		dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

	}

}
