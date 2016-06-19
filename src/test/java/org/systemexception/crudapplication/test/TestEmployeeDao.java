package org.systemexception.crudapplication.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.systemexception.crudapplication.dao.EmployeeDao;
import org.systemexception.crudapplication.dao.EmployeeDaoImpl;
import org.systemexception.crudapplication.model.Employee;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * @author leo
 * @date Feb 18, 2015 12:33:13 AM
 */
public class TestEmployeeDao {

	private EmployeeDao sut;
	private Employee employee;

	@Before
	public void setUp() {
		sut = new EmployeeDaoImpl();
		employee = new Employee(999, "Test", "Test");
	}

	@After
	public void tearDown() {
		sut.deleteEmployee(employee);
	}

	@Test
	public void testGetHomer() {
		assertTrue("Homer".equals(sut.findById(0).getEmpName()));
	}

	@Test
	public void testGetEmployeeList() {
		assertTrue("Homer".equals(sut.findByName("HoMeR").get(0).getEmpName()));
	}

	@Test
	public void testCountEmployees() {
		assertTrue(sut.countEmployees() > 0);
	}

	/**
	 * tests are run in consecutive order
	 */
	@Test
	public void test_1_EmployeeDaoInsert() {
		assertTrue(sut.insertEmployeeWithId(employee));
		assertEquals(employee, sut.findById(employee.getEmpId()));
		assertEquals(employee.hashCode(), sut.findById(employee.getEmpId()).hashCode());
	}

	@Test
	public void test_2_EmployeeDaoAutoInsert() {
		assertTrue(sut.insertEmployee(employee));
		List<Employee> byName = sut.findByName(employee.getEmpName());
		assert(byName.size() > 0);
		sut.cleanTests();
	}

	@Test
	public void test_3_FindEmployeeByName() {
		List<Employee> employee = sut.findByName("Test");
		assertEquals("Test", employee.get(0).getEmpName());
	}

	@Test
	public void test_4_FindEmployeeById() {
		Employee employee = sut.findById(0);
		assertEquals(0, employee.getEmpId());
	}

	@Test
	public void test_5_EmployeeDaoDelete() {
		sut.insertEmployeeWithId(employee);
		assertTrue(sut.deleteEmployee(employee));
	}

	@Test
	public void test_6_EmployeeDaoUpdate() {
		sut.insertEmployeeWithId(employee);
		employee.setEmpName("TestNameUpdate");
		employee.setEmpSurname("TestNameUpdate");
		sut.updateEmployee(employee);
		Employee employeeUpdated = sut.findById(employee.getEmpId());
		assertEquals(employeeUpdated, employee);
		assertEquals(employeeUpdated.hashCode(), sut.findById(employee.getEmpId()).hashCode());
	}
}
