package br.com.voeairlines.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMVC {

	public Connection getConnetion() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/voeairlines?useTimezone=true&serverTimezone=UTC",
					"root", "1234");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
