package org.systemexception.crudapplication.test;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.systemexception.crudapplication.impl.EmployeeDaoImpl;
import org.systemexception.crudapplication.pojo.Employee;
import org.systemexception.crudapplication.test.impl.TestEmployeeDaoImpl;

/**
 *
 * @author leo
 * @date Feb 18, 2015 12:33:13 AM
 */
public class TestInsertDeleteEmployee {

	TestEmployeeDaoImpl empDao;
	Employee emp;

	@Before
	public void setUp() {
		empDao = new TestEmployeeDaoImpl();
		emp = new Employee(999, "Test", "Test");
	}

	@After
	public void tearDown() {
		empDao.deleteEmployee(emp);
	}

	@Test
	public void test_1_EmployeeDaoInsert() {
		assertTrue(empDao.insertEmployeeWithId(emp));
		empDao.deleteEmployee(emp);
	}

	@Test
	public void test_2_EmployeeDaoDelete() {
		empDao.insertEmployeeWithId(emp);
		assertTrue(empDao.deleteEmployee(emp));
	}

}
