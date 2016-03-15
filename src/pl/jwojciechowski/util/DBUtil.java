package pl.jwojciechowski.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection dbConnection = null;

	public static void init() {
		try {
			Class.forName("org.postgresql.Driver");
			dbConnection = DriverManager.getConnection("jdbc:postgresql://192.168.0.10/db_products", "postgres",
					"raspberry");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return dbConnection;
	}

	public static void closeConnection() {
		try {
			dbConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
