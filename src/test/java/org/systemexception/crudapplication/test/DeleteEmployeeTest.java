package org.systemexception.crudapplication.test;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.systemexception.crudapplication.dao.EmployeeDaoImpl;
import org.systemexception.crudapplication.model.Employee;
import org.systemexception.crudapplication.servlet.DeleteEmployee;
import org.systemexception.crudapplication.servlet.ServletConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * @author leo
 * @date 27/12/15 01:48
 */
public class DeleteEmployeeTest {

	private final EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
	private final Employee employee = new Employee(999, "Test", "Test");

	@Before
	public void setUp() {
		employeeDao.insertEmployeeWithId(employee);
	}

	@After
	public void tearDown() {
		employeeDao.deleteEmployee(employee);
	}

	@Test
	public void testForm() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		when(request.getParameter(ServletConstants.PARAMETER_EMP_ID.toString()))
				.thenReturn(String.valueOf(employee.getEmpId()));
		when(response.getWriter()).thenReturn(new PrintWriter(BadWorldTest.FILE_NAME));

		PrintWriter writer = new PrintWriter(BadWorldTest.FILE_NAME);

		new DeleteEmployee().doGet(request, response);

		writer.flush();
		assertTrue(FileUtils.readFileToString(new File(BadWorldTest.FILE_NAME), "UTF-8")
				.contains(ListEmployeesTest.LOG_LIST_EMPLOYEES));
	}

	@Test
	public void testDelete() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		when(request.getParameter(ServletConstants.PARAMETER_EMP_ID.toString()))
				.thenReturn(String.valueOf(employee.getEmpId()));
		when(response.getWriter()).thenReturn(new PrintWriter(BadWorldTest.FILE_NAME));

		PrintWriter writer = new PrintWriter(BadWorldTest.FILE_NAME);

		new DeleteEmployee().doPost(request, response);

		verify(request, atLeast(1)).getParameter(ServletConstants.PARAMETER_EMP_ID.toString());
		writer.flush();
		assertTrue(0 == employeeDao.findById(employee.getEmpId()).getEmpId());
	}

}