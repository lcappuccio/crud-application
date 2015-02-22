package org.systemexception.crudapplication.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.systemexception.crudapplication.exception.PojoMapperException;
import org.systemexception.crudapplication.pojo.Employees;
import org.systemexception.crudapplication.pojo.PojoMapper;
import org.systemexception.crudapplication.pojo.Util;

/**
 *
 * @author leo
 * @date 19/02/2015 23:04
 */
public class EmployeesJson extends HttpServlet {

	private static final long serialVersionUID = 8069911911112010811L;
	private static final Logger LOG = Logger.getLogger(EmployeesJson.class.getCanonicalName());
	private final PojoMapper pojoMapper = new PojoMapper();

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 * @throws org.systemexception.crudapplication.exception.PojoMapperException
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, PojoMapperException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Employees emp = new Employees();
		String empJson = pojoMapper.employeesToJson(emp);
		LOG.log(Level.INFO, "request from {0}", request.getRemoteAddr());
		LOG.log(Level.INFO, "retrieved {0} employees", emp.countEmployees());
		try {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println(Util.BOOTSTRAP_CSS_PATH);
			out.println("<title>Servlet EmployeesJson</title>");
			out.println("</head>");
			out.println("<body>");
			out.println(empJson);
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
		try {
			processRequest(request, response);
		} catch (PojoMapperException ex) {
			Logger.getLogger(EmployeesJson.class.getName()).log(Level.SEVERE, null, ex);
		}
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
		try {
			processRequest(request, response);
		} catch (PojoMapperException ex) {
			Logger.getLogger(EmployeesJson.class.getName()).log(Level.SEVERE, null, ex);
		}
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
