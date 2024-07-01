package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConn {
	static final String URL = "jdbc:postgresql://localhost/librosautores";
	static final String USER = "postgres";
	static final String PASSWORD = "12345";
	static final String DRIVER = "org.postgresql.Driver";
	
	static public Connection conn = null;
	
	static public Connection getConnection () {
		if (conn != null) {
			return conn;
		}
		try {
			Class.forName(DRIVER);
			conn = (Connection) DriverManager.getConnection(URL,USER,PASSWORD);

		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println(conn);
		return conn;
	}
}
