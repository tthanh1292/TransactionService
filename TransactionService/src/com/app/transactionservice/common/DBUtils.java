package com.app.transactionservice.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author Thanh Trieu
 */
public class DBUtils {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			String url = "jdbc:hsqldb:MyDB;readonly=true";
			String name = "sa";
			String password = "";

			conn = DriverManager.getConnection(url, name, password);
		}
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
