package org.systemexception.crudapplication.servlet;

import org.systemexception.crudapplication.api.EmployeeDao;
import org.systemexception.crudapplication.impl.EmployeeDaoImpl;
import org.systemexception.crudapplication.model.Employee;
import org.systemexception.crudapplication.pojo.Constants;
import org.systemexception.logger.impl.LoggerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author leo
 */
public class InsertEmployee extends HttpServlet {

	private static final org.systemexception.logger.api.Logger LOG = LoggerImpl.getFor(InsertEmployee.class);
	private final EmployeeDao empDao = new EmployeeDaoImpl();

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		LOG.info("request from " + request.getRemoteAddr());
		try {
			out.println(Constants.PAGE_HEADER);
			out.println("<div class=\"container\">");
			out.println("<h2>Insert New Employee</h2><hr>");
			out.println("<form class=\"form-insert\" action=\"InsertEmployee\" method=\"POST\">");

			out.println("<div class=\"form-group\">"
					+ "<label class=\"sr-only\" for=\"employeeName\">Name</label>"
					+ "<input type=\"text\" class=\"form-control\" id=\"employeeName\" placeholder=\"Enter employee " +
					"name\" name=\"employeeName\"></div>");

			out.println("<div class=\"form-group\">"
					+ "<label class=\"sr-only\" for=\"employeeSurname\">Surname</label>"
					+ "<input type=\"text\" class=\"form-control\" id=\"employeeSurname\" placeholder=\"Enter employee" +
					" name\" name=\"employeeSurname\"></div>");

			out.println("<button type=\"submit\" class=\"btn btn-default\">Submit</button>");

			out.println("</form>");
			out.println("</div>");
			out.println(Constants.PAGE_END);
		} finally {
			out.close();
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the
	// code.">

	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String empName = request.getParameter("employeeName");
		String empSurname = request.getParameter("employeeSurname");
		Employee emp = new Employee(empName, empSurname);
		empDao.insertEmployee(emp);
		processRequest(request, response);
		LOG.info("Insert employee: " + empName + ", " + empSurname + ", remote IP: " + request.getRemoteAddr());
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
