package org.systemexception.crudapplication.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.systemexception.crudapplication.model.Employees;
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
public class ListEmployees extends HttpServlet {

	private static final Logger LOG = LogManager.getLogger(ListEmployees.class);

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
		Employees employees = new Employees();
		LOG.info("request from " + request.getRemoteAddr());
		LOG.info("retrieved " + employees.countEmployees() + " employees");
		try (PrintWriter out = response.getWriter()) {
			out.println(PojoConstants.PAGE_HEADER);
			out.println("<div class=\"container\">");
			out.println("<h2>List Employees</h2><hr>");
			// Start printing table
			out.println("<table class=\"table table-striped\">");
			out.println(PojoConstants.TABLE_HEAD);
			for (int i = 0; i < employees.countEmployees(); i++) {
				String empID = String.valueOf(employees.getEmpList().get(i).getEmpId());
				String empName = employees.getEmpList().get(i).getEmpName();
				String empLastName = employees.getEmpList().get(i).getEmpSurname();
				out.println("<tr><td>" + empID + "</td><td>" + empName + "</td><td>" + empLastName + "</td></tr>");
			}
			out.println("</tbody></table>");
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

}
