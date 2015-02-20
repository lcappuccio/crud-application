package org.systemexception.crudapplication.test;

import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import org.systemexception.crudapplication.api.EmployeeDao;
import org.systemexception.crudapplication.test.impl.TestEmployeeDaoImpl;

/**
 *
 * @author leo
 * @date Feb 18, 2015 12:31:09 AM
 */
public class TestEmployeeApi {

	EmployeeDao sut = new TestEmployeeDaoImpl();

	@Test
	public void testGetHomer() {
		assertTrue("Homer".equals(sut.findById(1).getEmpName()));
	}

	@Test
	public void testGetEmployeeList() {
		assertTrue("Homer".equals(sut.findByName("HoMeR").get(0).getEmpName()));
	}

	@Test
	public void testCountEmployees() {
		assertTrue(sut.countEmployees() > 0);
	}
}
