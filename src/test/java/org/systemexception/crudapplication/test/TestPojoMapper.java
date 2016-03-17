package org.systemexception.crudapplication.test;

import org.junit.Before;
import org.junit.Test;
import org.systemexception.crudapplication.dao.EmployeeDao;
import org.systemexception.crudapplication.exception.PojoMapperException;
import org.systemexception.crudapplication.dao.EmployeeDaoImpl;
import org.systemexception.crudapplication.model.Employee;
import org.systemexception.crudapplication.model.Employees;
import org.systemexception.crudapplication.pojo.PojoMapper;

import static org.junit.Assert.assertTrue;

/**
 * @author leo
 * @date Feb 18, 2015 12:33:37 AM
 */
public class TestPojoMapper {

	private Employee emp;
	private Employees employees;
	private final EmployeeDao empDao = new EmployeeDaoImpl();
	private final PojoMapper sut = new PojoMapper();

	@Before
	public void setUp() {
		emp = empDao.findById(0);
		employees = new Employees();
	}

	@Test
	public void testEmpToJson() throws PojoMapperException {
		assertTrue("{\"empId\":0,\"empName\":\"Homer\",\"empSurname\":\"Simpson\"}".equals(sut.employeeToJson(emp)));
	}

	@Test
	public void testJsonToEmp() throws PojoMapperException {
		emp = empDao.findById(0);
		Employee empJson = sut.jsonToEmployee("{\"empId\":0,\"empName\":\"Homer\",\"empSurname\":\"Simpson\"}");
		assertTrue(emp.equals(empJson));
	}

	@Test
	public void testEmployeesToJson() throws PojoMapperException {
		System.out.println(sut.employeesToJson(employees));
	}

	@Test(expected = PojoMapperException.class)
	public void testException() throws PojoMapperException {
		sut.jsonToEmployee("{\"empOID\":1,\"empName\":\"Homer\",\"empSurname\":\"Simpson\"}");
	}
}
