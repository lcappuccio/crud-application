/**
 *
 * @author leo
 * @date 24/02/2015 22:59
 *
 */
package org.systemexception.crudapplication.impl;

import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.systemexception.crudapplication.api.EmployeeDao;
import org.systemexception.crudapplication.pojo.Employee;
import org.systemexception.crudapplication.pojo.Util;

public class EmployeeDaoImpl implements EmployeeDao {

	private static final Logger LOG = Logger.getLogger(EmployeeDaoImpl.class.getCanonicalName());
	private final HikariDataSource dataSource = new HikariDataSource();
	private Connection conn;

	/**
	 * Returns a connection type
	 *
	 * @return
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		// TODO IP address, schema, user and password should be in external properties
		// for testing use ("jdbc:mysql://192.168.1.3:3306/test");
		// for production use ("jdbc:mysql://localhost:3306/test");
		dataSource.setJdbcUrl("jdbc:mariadb://192.168.1.3:3306/test");
		dataSource.setUsername("test");
		dataSource.setPassword("test");
		dataSource.setConnectionTimeout(5000);
		dataSource.setIdleTimeout(300000);
		dataSource.setMaximumPoolSize(8);
		dataSource.setAutoCommit(false);
		conn = dataSource.getConnection();
		return (conn);
	}

	@Override
	public Employee findById(int empId) {
		PreparedStatement pss = null;
		ResultSet rs = null;
		Employee emp = new Employee();
		try {
			conn = getConnection();
			pss = conn.prepareStatement(
					"select EMPLOYEE_ID, EMPLOYEE_NAME, EMPLOYEE_SURNAME from EMPLOYEES where EMPLOYEE_ID = ?",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			pss.setInt(1, empId);
			rs = pss.executeQuery();
			while (rs.next()) {
				emp.setEmpId(rs.getInt("EMPLOYEE_ID"));
				emp.setEmpName(rs.getString("EMPLOYEE_NAME"));
				emp.setEmpSurname(rs.getString("EMPLOYEE_SURNAME"));
			}
		} catch (SQLException e) {
			exceptionHandler(e);
		} finally {
			closeAll(conn, pss, rs);
		}
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		PreparedStatement pss = null;
		ResultSet rs = null;
		List<Employee> empList = new ArrayList<Employee>();
		try {
			conn = getConnection();
			pss = conn.prepareStatement("select EMPLOYEE_ID, EMPLOYEE_NAME, EMPLOYEE_SURNAME from EMPLOYEES",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = pss.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("EMPLOYEE_ID"));
				emp.setEmpName(rs.getString("EMPLOYEE_NAME"));
				emp.setEmpSurname(rs.getString("EMPLOYEE_SURNAME"));
				empList.add(emp);
			}
		} catch (SQLException e) {
			exceptionHandler(e);
		} finally {
			closeAll(conn, pss, rs);
		}
		return empList;
	}

	@Override
	public List<Employee> findByName(String empName) {
		PreparedStatement pss = null;
		ResultSet rs = null;
		List<Employee> empList = new ArrayList<Employee>();
		try {
			conn = getConnection();
			pss = conn
					.prepareStatement(
							"select EMPLOYEE_ID, EMPLOYEE_NAME, EMPLOYEE_SURNAME from EMPLOYEES where lower(EMPLOYEE_NAME) LIKE ?",
							ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			pss.setString(1, "%" + empName.toLowerCase(Util.LOCALE) + "%");
			rs = pss.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getInt("EMPLOYEE_ID"));
				emp.setEmpName(rs.getString("EMPLOYEE_NAME"));
				emp.setEmpSurname(rs.getString("EMPLOYEE_SURNAME"));
				empList.add(emp);
			}
		} catch (SQLException e) {
			exceptionHandler(e);
		} finally {
			closeAll(conn, pss, rs);
		}
		return empList;
	}

	@Override
	public int countEmployees() {
		PreparedStatement pss = null;
		ResultSet rs = null;
		int empCount = 0;
		try {
			conn = getConnection();
			pss = conn.prepareStatement("select count(*) from EMPLOYEES", ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = pss.executeQuery();
			while (rs.next()) {
				empCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			exceptionHandler(e);
		} finally {
			closeAll(conn, pss, rs);
		}
		return empCount;
	}

	@Override
	public boolean insertEmployee(Employee emp) {
		boolean operationResult = false;
		PreparedStatement pss = null;
		ResultSet rs = null;
		int maxEmpId = 0;
		try {
			conn = getConnection();
			pss = conn.prepareStatement("select max(EMPLOYEE_ID) as MAXEMPID from EMPLOYEES",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = pss.executeQuery();
			while (rs.next()) {
				maxEmpId = rs.getInt(1);
			}
			rs.close();
			pss.close();
			pss = conn.prepareStatement(
					"insert into EMPLOYEES (EMPLOYEE_ID,EMPLOYEE_NAME, EMPLOYEE_SURNAME) values (?,?,?)",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			pss.setInt(1, maxEmpId + 1);
			pss.setString(2, emp.getEmpName());
			pss.setString(3, emp.getEmpSurname());
			int countRows = pss.executeUpdate();
			if (countRows > 0) {
				operationResult = true;
				conn.commit();
			}
		} catch (SQLException e) {
			exceptionHandler(e);
		} finally {
			closeAll(conn, pss, rs);
		}
		return operationResult;
	}

	@Override
	public boolean deleteEmployee(Employee emp) {
		boolean operationResult = false;
		PreparedStatement pss = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pss = conn.prepareStatement("delete from EMPLOYEES where EMPLOYEE_ID = ?",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			pss.setInt(1, emp.getEmpId());
			int countRows = pss.executeUpdate();
			if (countRows > 0) {
				operationResult = true;
				conn.commit();
			}
		} catch (SQLException e) {
			exceptionHandler(e);
		} finally {
			closeAll(conn, pss, rs);
		}
		return operationResult;
	}

	/**
	 * Quietly close all database resources
	 *
	 * @param conn
	 * @param pss
	 * @param rs
	 */
	private void closeAll(Connection conn, PreparedStatement pss, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pss != null) {
				pss.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			exceptionHandler(e);
		}
	}

	/**
	 * Exception handler to log file
	 *
	 * @param e
	 */
	private void exceptionHandler(SQLException e) {
		LOG.log(Level.SEVERE, "Error in DAO\n{0}", e);
	}
}
