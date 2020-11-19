package databaselayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import controllayer.DataAccessException;

public class DBConnection {
	private Connection connection = null;
	private static DBConnection dbConnection;

	private static final String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String dbName = "dmaa0220_1083803";
	//private static final String serverAddress = "localhost";
	private static final String serverAddress = "hildur.ucn.dk";
	private static final int serverPort = 1433;
	private static final String userName = "dmaa0220_1083803";
	private static final String password = "Password1!";

	private DBConnection() throws DataAccessException {
		// Cheat sheet for the printf() method, the format is also used in the
		// String.format() method
		// http://alvinalexander.com/programming/printf-format-cheat-sheet
		String connectionString = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s",
				serverAddress, serverPort, dbName, userName, password);
		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(connectionString);
		} catch (ClassNotFoundException e) {
			throw new DataAccessException("Missing JDBC driver", e);
			// System.err.println("Could not load JDBC driver");
			// e.printStackTrace();

		} catch (SQLException e) {
			throw new DataAccessException(String.format("Could not connect to database %s@%s:%d user %s", dbName,
					serverAddress, serverPort, userName), e);
			// System.out.println("Connection string was: " + connectionString.substring(0,
			// connectionString.length() - password.length()) + "....");
			// e.printStackTrace();
		}
	}

	public static synchronized DBConnection getInstance() throws DataAccessException {
		if (dbConnection == null) {
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}

	public void startTransaction() throws DataAccessException {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not start transaction.", e);
		}
	}

	public void commitTransaction() throws DataAccessException {
		try {
			try {
				connection.commit();
			} catch (SQLException e) {
				throw e;
			} finally {
				connection.setAutoCommit(true);
			}
		} catch (SQLException e) {
			throw new DataAccessException("Could not commit transaction", e);
		}
	}

	public void rollbackTransaction() throws DataAccessException {
		try {
			try {
				connection.rollback();
			} catch (SQLException e) {
				throw e;
			} finally {
				connection.setAutoCommit(true);
			}
		} catch (SQLException e) {
			throw new DataAccessException("Could not rollback transaction", e);
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void disconnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
