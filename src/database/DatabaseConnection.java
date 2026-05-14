package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	public Connection getConnection() throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/biblioteca";
		String user = "postgres";
		String password = "123";
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

}
