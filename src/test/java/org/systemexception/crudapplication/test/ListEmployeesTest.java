package org.systemexception.crudapplication.test;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.systemexception.crudapplication.servlet.ListEmployees;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author leo
 * @date 27/12/15 02:50
 */
public class ListEmployeesTest {

	private final String fileName = System.getProperty("user.dir") + File.separator + "output.txt";

	@Test
	public void testForm() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		when(response.getWriter()).thenReturn(new PrintWriter(fileName));

		PrintWriter writer = new PrintWriter(fileName);

		new ListEmployees().doGet(request, response);

		writer.flush();
		assertTrue(FileUtils.readFileToString(new File(fileName), "UTF-8").contains("List Employees"));
	}

}