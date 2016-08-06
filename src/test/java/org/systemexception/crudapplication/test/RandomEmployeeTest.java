package org.systemexception.crudapplication.test;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.systemexception.crudapplication.servlet.RandomEmployee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author leo
 * @date 27/12/15 02:54
 */
public class RandomEmployeeTest {

	@Test
	public void testServlet() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = new PrintWriter(BadWorldTest.FILE_NAME);
		when(response.getWriter()).thenReturn(writer);

		new RandomEmployee().doGet(request, response);

		writer.flush();
		assertTrue(FileUtils.readFileToString(new File(BadWorldTest.FILE_NAME), "UTF-8").contains("Random Employee"));
	}
}