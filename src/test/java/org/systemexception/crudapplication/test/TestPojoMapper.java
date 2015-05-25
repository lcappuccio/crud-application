package org.systemexception.crudapplication.test;

import org.junit.Before;
import org.junit.Test;
import org.systemexception.crudapplication.api.EmployeeDao;
import org.systemexception.crudapplication.exception.PojoMapperException;
import org.systemexception.crudapplication.impl.EmployeeDaoImpl;
import org.systemexception.crudapplication.pojo.Employee;
import org.systemexception.crudapplication.pojo.Employees;
import org.systemexception.crudapplication.pojo.PojoMapper;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author leo
 * @date Feb 18, 2015 12:33:37 AM
 */
public class TestPojoMapper {

	private Employee emp1;
	private Employee emp2;
	private Employee emp3;
	private Employees employees;
	private final EmployeeDao empDao = new EmployeeDaoImpl();
	private final PojoMapper sut = new PojoMapper();

	@Before
	public void setUp() {
		emp1 = empDao.findById(1);
		emp2 = empDao.findById(2);
		emp3 = empDao.findById(3);
		employees = new Employees();
	}

	@Test
	public void testEmpToJson() throws PojoMapperException {
		assertTrue("{\"empId\":1,\"empName\":\"Homer\",\"empSurname\":\"Simpson\"}".equals(sut.employeeToJson(emp1)));
	}

	@Test
	public void testJsonToEmp() throws PojoMapperException {
		emp1 = empDao.findById(1);
		Employee empJson = sut.jsonToEmployee("{\"empId\":1,\"empName\":\"Homer\",\"empSurname\":\"Simpson\"}");
		assertTrue(emp1.equals(empJson));
	}

	@Test
	public void testEmployeesToJson() throws PojoMapperException {
		System.out.println(sut.employeesToJson(employees));
	}

	@Test(expected = org.systemexception.crudapplication.exception.PojoMapperException.class)
	public void testException() throws PojoMapperException {
		Employee empJson = sut.jsonToEmployee("{\"empOID\":1,\"empName\":\"Homer\",\"empSurname\":\"Simpson\"}");

	}
}
