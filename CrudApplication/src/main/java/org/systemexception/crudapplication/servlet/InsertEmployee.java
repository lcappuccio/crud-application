package org.systemexception.crudapplication.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.systemexception.crudapplication.impl.EmployeeDaoImpl;
import org.systemexception.crudapplication.pojo.Employee;
import org.systemexception.crudapplication.pojo.Util;

/**
 *
 * @author leo
 */
public class InsertEmployee extends HttpServlet {

	private static final Logger LOG = Logger.getLogger(InsertEmployee.class.getCanonicalName());
	private final EmployeeDaoImpl empDao = new EmployeeDaoImpl();
	private Employee emp;

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println(Util.BOOTSTRAP_CSS_PATH);
			out.println("<title>Insert Employee</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Insert Employee</h1>");
			out.println("<form class=\"form-inline\" action=\"InsertEmployee\" method=\"POST\">");

			out.println("<div class=\"form-group\">"
					+ "<label class=\"sr-only\" for=\"employeeName\">Name</label>"
					+ "<input type=\"text\" class=\"form-control\" id=\"employeeName\" placeholder=\"Enter employee name\" name=\"employeeName\"></div>");

			out.println("<div class=\"form-group\">"
					+ "<label class=\"sr-only\" for=\"employeeSurname\">Surname</label>"
					+ "<input type=\"text\" class=\"form-control\" id=\"employeeSurname\" placeholder=\"Enter employee name\" name=\"employeeSurname\"></div>");

			out.println("<button type=\"submit\" class=\"btn btn-default\">Submit</button>");

			out.println("</form>");
			out.println("<hr>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String empName = request.getParameter("employeeName");
		String empSurname = request.getParameter("employeeSurname");
		emp = new Employee(empName, empSurname);
		empDao.insertEmployee(emp);
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
