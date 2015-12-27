package org.systemexception.crudapplication.test;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.systemexception.crudapplication.impl.EmployeeDaoImpl;
import org.systemexception.crudapplication.model.Employee;
import org.systemexception.crudapplication.servlet.EmployeesJson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author leo
 * @date 27/12/15 02:26
 */
public class EmployeesJsonTest {

	private final EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
	private final Employee employee = new Employee(999, "Test", "Test");
	private final String fileName = System.getProperty("user.dir") + File.separator + "output.txt";

	@Before
	public void setUp() {
		employeeDao.insertEmployeeWithId(employee);
	}

	@After
	public void tearDown() {
		employeeDao.deleteEmployee(employee);
	}

	@Test
	public void testServlet() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = new PrintWriter(fileName);
		when(response.getWriter()).thenReturn(writer);

		new EmployeesJson().doGet(request, response);

		writer.flush();
		assertTrue(FileUtils.readFileToString(new File(fileName), "UTF-8").contains("Servlet EmployeesJson"));
		assertTrue(FileUtils.readFileToString(new File(fileName), "UTF-8").contains("{\"empId\":999," +
				"\"empName\":\"Test\",\"empSurname\":\"Test\"}"));
	}
}