package org.systemexception.crudapplication.test;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.systemexception.crudapplication.exception.PojoMapperException;
import org.systemexception.crudapplication.impl.EmployeeDaoImpl;
import org.systemexception.crudapplication.pojo.Employee;
import org.systemexception.crudapplication.pojo.PojoMapper;

/**
 *
 * @author leo
 * @date Feb 18, 2015 12:33:37 AM
 */
public class TestPojoMapper {

	Employee emp;
	EmployeeDaoImpl empDao = new EmployeeDaoImpl();
	PojoMapper sut = new PojoMapper();

	@Before
	public void setUp() {
		emp = empDao.findById(1);
	}

	@Test
	public void testEmpToJson() throws PojoMapperException {
		assertTrue("{\"empId\":1,\"empName\":\"Homer\",\"empSurname\":\"Simpson\"}".equals(sut.empToJson(emp)));
	}

	@Test
	public void testJsonToEmp() throws PojoMapperException {
		emp = empDao.findById(1);
		Employee empJson = sut.jsonToEmp("{\"empId\":1,\"empName\":\"Homer\",\"empSurname\":\"Simpson\"}");
		assertTrue(emp.equals(empJson));
	}

}
