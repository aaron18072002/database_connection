package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class DbConnection {
	
	private static Connection connection;
	
	private DbConnection() {
		
	}
	
	public static Connection getConnection() {
		if(connection == null) {
			try {
				Properties dbProperties = DbProvider.getProperties();
				Class.forName(Driver.class.getName());
				connection = DriverManager.getConnection(
						dbProperties.getProperty("DB_CONFIG_URL"), 
						dbProperties.getProperty("DB_USER"),
						dbProperties.getProperty("DB_PASSWORD"));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		return connection;
	}
	
}
