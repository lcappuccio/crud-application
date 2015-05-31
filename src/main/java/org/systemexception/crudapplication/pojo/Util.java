package org.systemexception.crudapplication.pojo;

import java.util.Locale;

/**
 *
 * @author leo
 * @date Feb 19, 2015 8:34:31 PM
 */
public class Util {

	public static final String BOOTSTRAP_CSS_PATH = "<link href=\"resources/css/bootstrap.min.css\" rel=\"stylesheet\">";
	public static final String JQUERY_PATH = "<script src=\"resources/js/jquery-1.11.3.min.js\"></script>";
	public static final String FAVICON_PATH = "<link rel=\"icon\" type=\"image/png\" sizes=\"96x96\" href=\"resources/images/favicon.png\">";

	public static final String PAGE_HEADER = "<html>"
			+ "<head>"
			+ " <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
			+ " <title>Basic Crud Application</title>\n"
			+ BOOTSTRAP_CSS_PATH + "\n"
			+ JQUERY_PATH + "\n"
			+ FAVICON_PATH + "\n"
			+ " </head>\n"
			// Body starts here
			+ "<body>\n"
			+ "<nav class=\"navbar navbar-inverse\" role=\"navigation\">"
			+ "  <div class=\"navbar-header\">\n"
			+ "    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#appnavbar\">\n"
			+ "      <span class=\"sr-only\">Toggle navigation</span>\n"
			+ "      <span class=\"icon-bar\"></span>\n"
			+ "      <span class=\"icon-bar\"></span>\n"
			+ "      <span class=\"icon-bar\"></span>\n"
			+ "      <span class=\"icon-bar\"></span>\n"
			+ "		 <span class=\"icon-bar\"></span>\n"
			+ "      <span class=\"icon-bar\"></span>\n"
			+ "      <span class=\"icon-bar\"></span>\n"
			+ "      <span class=\"icon-bar\"></span>\n"
			+ "    </button>\n"
			+ "    <a class=\"navbar-brand\" href=\"HelloWorld\">Basic Crud Application</a>\n"
			+ "  </div>"
			+ "<!-- Collect the nav links, forms, and other content for toggling -->\n"
			+ "  <div class=\"collapse navbar-collapse\" id=\"appnavbar\">\n"
			+ "    <ul class=\"nav navbar-nav\">\n"
			+ "      <li class=\"active\"><a href=\"HelloWorld\">Hello World</a></li>\n"
			+ "      <li class=\"active\"><a href=\"BadWorld\">Bad World</a></li>\n"
			+ "      <li class=\"active\"><a href=\"ListEmployees\">List Employees</a></li>\n"
			+ "      <li class=\"active\"><a href=\"RandomEmployee\">Random Employee</a></li>\n"
			+ "		 <li class=\"active\"><a href=\"InsertEmployee\">Insert New Employee</a></li>\n"
			+ "		 <li class=\"active\"><a href=\"UpdateEmployee\">Update Employee</a></li>\n"
			+ "		 <li class=\"active\"><a href=\"DeleteEmployee\">Delete Employee</a></li>\n"
			+ "		 <li class=\"active\"><a href=\"EmployeesJson\">JSON Employee API</a></li>\n"
			+ "    </ul>"
			+ "  </div><!-- /.navbar-collapse -->\n"
			+ "</nav>";

	public static final String PAGE_END = "<hr></body></html>";

	public static final Locale LOCALE = Locale.getDefault();

}
