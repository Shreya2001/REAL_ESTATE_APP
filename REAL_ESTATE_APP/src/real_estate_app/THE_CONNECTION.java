package real_estate_app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class THE_CONNECTION {
	
	private static String jdbcURL = "jdbc:mysql://localhost:3306/java_rst_db";
	private static String username = "root";
	private static String password = "2708";
	
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
		connection = DriverManager.getConnection(jdbcURL, username, password);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return connection;
	}
}
