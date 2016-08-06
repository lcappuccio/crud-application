package org.systemexception.crudapplication.test;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.systemexception.crudapplication.servlet.BadWorld;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * @author leo
 * @date 27/12/15 01:25
 */
public class BadWorldTest {

	public static final String FILE_NAME = System.getProperty("user.dir") + File.separator + "output.txt";

	@Test
	public void testServlet() throws Exception {
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		PrintWriter writer = new PrintWriter(FILE_NAME);
		when(response.getWriter()).thenReturn(writer);

		new BadWorld().doGet(request, response);

		writer.flush();
		assertTrue(FileUtils.readFileToString(new File(FILE_NAME), "UTF-8").contains("Bad World!"));
	}
}