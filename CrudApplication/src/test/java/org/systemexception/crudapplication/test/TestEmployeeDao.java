package org.systemexception.crudapplication.test;

import static junit.framework.Assert.assertEquals;
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
	private Employee employee;

	@Before
	public void setUp() {
		sut = new TestEmployeeDaoImpl();
		employee = new Employee(999, "Test", "Test");
	}

	@After
	public void tearDown() {
		sut.deleteEmployee(employee);
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
		assertTrue(sut.insertEmployeeWithId(employee));
		sut.deleteEmployee(employee);
	}

	@Test
	public void test_2_EmployeeDaoDelete() {
		sut.insertEmployeeWithId(employee);
		assertTrue(sut.deleteEmployee(employee));
	}

	@Test
	public void test_3_EmployeeDaoUpdate() {
		sut.insertEmployeeWithId(employee);
		employee.setEmpName("TestNameUpdate");
		employee.setEmpSurname("TestNameUpdate");
		sut.updateEmployee(employee);
		Employee employeeUpdated = sut.findById(employee.getEmpId());
		assertEquals(employeeUpdated, employee);
	}

	@Test
	public void test_bad_query() {
		assertTrue(sut.testBadQuery());
	}
}
