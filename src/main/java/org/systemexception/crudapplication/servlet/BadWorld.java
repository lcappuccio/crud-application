package org.systemexception.crudapplication.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.systemexception.crudapplication.pojo.PojoConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * @author leo
 */
public class BadWorld extends HttpServlet {

	private static final Logger LOG = LogManager.getLogger(BadWorld.class);

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
		Random rnd = new Random();
		String rndStr = Long.toHexString(rnd.nextLong()).toUpperCase();
		LOG.info("request from " + request.getRemoteAddr());
		try (PrintWriter out = response.getWriter()) {
			out.println(PojoConstants.PAGE_HEADER);
			out.println("<div class=\"container\">");
			out.println("<h2>Bad World!</h2><hr>");
			out.println("Guess this: " + rndStr);
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
