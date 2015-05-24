package org.systemexception.crudapplication.pojo;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.codehaus.jackson.map.ObjectMapper;
import org.systemexception.crudapplication.exception.PojoMapperException;

/**
 *
 * @author leo
 * @date Feb 18, 2015 12:33:50 AM
 */
public class PojoMapper {

	private final ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * Returns a JSON string representation of an employee
	 *
	 * @param emp
	 * @return
	 * @throws PojoMapperException
	 */
	public String employeeToJson(Employee emp) throws PojoMapperException {
		try {
			return objectMapper.writeValueAsString(emp);
		} catch (IOException e) {
			throw new PojoMapperException(exceptionToString(e));
		}
	}

	/**
	 * Returns an employee object given an employee JSON representation
	 *
	 * @param json
	 * @return
	 * @throws PojoMapperException
	 */
	public Employee jsonToEmployee(String json) throws PojoMapperException {
		try {
			return objectMapper.readValue(json, Employee.class);
		} catch (IOException e) {
			throw new PojoMapperException(exceptionToString(e));
		}
	}

	/**
	 * Returns a JSON string representation of an employee list
	 *
	 * @param employees
	 * @return
	 * @throws PojoMapperException
	 */
	public String employeesToJson(Employees employees) throws PojoMapperException {
		try {
			return objectMapper.writeValueAsString(employees);
		} catch (IOException e) {
			throw new PojoMapperException(exceptionToString(e));
		}
	}

	private String exceptionToString(Exception exception) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		exception.printStackTrace(pw);
		return (sw.toString());
	}
}
