package org.systemexception.crudapplication.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.systemexception.crudapplication.dao.EmployeeDao;
import org.systemexception.crudapplication.dao.EmployeeDaoImpl;
import org.systemexception.crudapplication.model.Employee;
import org.systemexception.crudapplication.pojo.PojoConstants;

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

	private static final Logger LOG = LogManager.getLogger(InsertEmployee.class);
	private final EmployeeDao empDao = new EmployeeDaoImpl();

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	private void processRequest(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {
		response.setContentType(ServletConstants.SERVLET_CONTENT.toString());
		LOG.info(ServletConstants.REQUEST_FROM.toString() + request.getRemoteAddr());
		try (PrintWriter out = response.getWriter()) {
			out.println(PojoConstants.PAGE_HEADER);
			out.println("<div class=\"container\">");
			out.println("<h2>Insert New Employee</h2><hr>");
			out.println("<form class=\"form-insert\" action=\"InsertEmployee\" method=\"POST\">");

			out.println("<div class=\"form-group\">"
					+ "<label class=\"sr-only\" for=\"employeeName\">Name</label>"
					+ "<input type=\"text\" class=\"form-control\" id=\"employeeName\" placeholder=\"Enter employee " +
					"name\" name=\"employeeName\"></div>");

			out.println("<div class=\"form-group\">"
					+ "<label class=\"sr-only\" for=\"employeeSurname\">Surname</label>"
					+ "<input type=\"text\" class=\"form-control\" id=\"employeeSurname\" placeholder=\"Enter " +
					"employee name\" name=\"employeeSurname\"></div>");

			out.println("<button type=\"submit\" class=\"btn btn-default\">Submit</button>");

			out.println("</form>");
			out.println("</div>");
			out.println(PojoConstants.PAGE_END);
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
	public void doGet(final HttpServletRequest request, final HttpServletResponse response)
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
	public void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {

		String empName = request.getParameter(ServletConstants.PARAMETER_EMP_FIRST_NAME.toString());
		String empSurname = request.getParameter(ServletConstants.PARAMETER_EMP_LAST_NAME.toString());
		Employee emp = new Employee(empName, empSurname);
		empDao.insertEmployee(emp);
		processRequest(request, response);
		LOG.info("Insert employee: " + empName + ", " + empSurname + ", remote IP: " + request.getRemoteAddr());
	}

}
