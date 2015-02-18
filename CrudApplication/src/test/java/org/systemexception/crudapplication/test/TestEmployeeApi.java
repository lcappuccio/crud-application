package org.systemexception.crudapplication.test;

import static junit.framework.Assert.assertTrue;
import org.junit.Test;
import org.systemexception.crudapplication.impl.EmployeeDaoImpl;

/**
 *
 * @author leo
 * @date Feb 18, 2015 12:31:09 AM
 */
public class TestEmployeeApi {

	EmployeeDaoImpl sut = new EmployeeDaoImpl();

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
