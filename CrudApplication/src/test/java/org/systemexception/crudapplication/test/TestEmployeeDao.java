package org.systemexception.crudapplication.test;

import static junit.framework.Assert.assertTrue;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.systemexception.crudapplication.pojo.Employee;
import org.systemexception.crudapplication.test.impl.TestEmployeeDaoImpl;

/**
 *
 * @author leo
 * @date Feb 18, 2015 12:33:13 AM
 */
public class TestEmployeeDao {

	private TestEmployeeDaoImpl sut;
	private Employee emp;

	@Before
	public void setUp() {
		sut = new TestEmployeeDaoImpl();
		emp = new Employee(999, "Test", "Test");
	}

	@After
	public void tearDown() {
		sut.deleteEmployee(emp);
	}

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

	@Test
	public void test_1_EmployeeDaoInsert() {
		assertTrue(sut.insertEmployeeWithId(emp));
		sut.deleteEmployee(emp);
	}

	@Test
	public void test_2_EmployeeDaoDelete() {
		sut.insertEmployeeWithId(emp);
		assertTrue(sut.deleteEmployee(emp));
	}

	@Test
	public void test_bad_query() {
		assertTrue(sut.testBadQuery());
	}
}
