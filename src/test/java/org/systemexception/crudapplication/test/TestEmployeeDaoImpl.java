/**
 * @author leo
 * @date 20/02/2015 20:05
 */
package org.systemexception.crudapplication.test;

import com.zaxxer.hikari.HikariDataSource;
import org.systemexception.crudapplication.impl.EmployeeDaoImpl;
import org.systemexception.crudapplication.model.Employee;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestEmployeeDaoImpl extends EmployeeDaoImpl {

	private final Logger LOG = Logger.getLogger(EmployeeDaoImpl.class.getCanonicalName());
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
		dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/myapp_test");
		dataSource.setUsername("travis");
		dataSource.setPassword(null);
		dataSource.setConnectionTimeout(5000);
		dataSource.setIdleTimeout(10000);
		dataSource.setMaximumPoolSize(2);
		dataSource.setAutoCommit(false);
		conn = dataSource.getConnection();
		return (conn);
	}

	/**
	 * Insert employee with a given ID, used in test
	 *
	 * @param emp
	 * @return
	 */
	public boolean insertEmployeeWithId(Employee emp) {
		LOG.info("Insert employee");
		boolean operationResult = false;
		PreparedStatement pss = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pss = conn.prepareStatement(
					"insert into EMPLOYEES (EMPLOYEE_ID, EMPLOYEE_NAME, EMPLOYEE_SURNAME) values (?,?,?)",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			pss.setInt(1, emp.getEmpId());
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

	/**
	 * Test that exception handler
	 *
	 * @return
	 */
	public boolean testBadQuery() {
		PreparedStatement pss = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pss = conn.prepareStatement(
					"terribly wrong query",
					ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = pss.executeQuery();
			int countRows = pss.executeUpdate();
		} catch (SQLException e) {
			exceptionHandler(e);
			return (true);
		} finally {
			closeAll(conn, pss, rs);
		}
		return (false);
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
	 * @param exception
	 */
	private void exceptionHandler(SQLException exception) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		exception.printStackTrace(pw);
		LOG.log(Level.SEVERE, "Error in DAO\n{0}", sw.toString());
	}
}
