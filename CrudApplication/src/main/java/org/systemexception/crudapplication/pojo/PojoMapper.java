package org.systemexception.crudapplication.pojo;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author leo
 * @date Feb 18, 2015 12:33:50 AM
 */
public class PojoMapper {

	private final ObjectMapper objectMapper = new ObjectMapper();

	public String empToJson(Employee emp) {
		try {
			return objectMapper.writeValueAsString(emp);
		} catch (IOException e) {
			System.out.println(exceptionToString(e));
			return "";
		}
	}

	public Employee jsonToEmp(String json) {
		try {
			return objectMapper.readValue(json, Employee.class);
		} catch (IOException e) {
			System.out.println(exceptionToString(e));
			return new Employee();
		}
	}

	private String exceptionToString(Exception exception) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		exception.printStackTrace(pw);
		return (sw.toString());
	}
}
