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

	public String employeeToJson(Employee emp) throws PojoMapperException {
		try {
			return objectMapper.writeValueAsString(emp);
		} catch (IOException e) {
			throw new PojoMapperException(exceptionToString(e));
		}
	}

	public Employee jsonToEmployee(String json) throws PojoMapperException {
		try {
			return objectMapper.readValue(json, Employee.class);
		} catch (IOException e) {
			throw new PojoMapperException(exceptionToString(e));
		}
	}

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
