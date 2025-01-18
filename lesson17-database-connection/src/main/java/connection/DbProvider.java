package connection;

import java.io.IOException;
import java.util.Properties;

public class DbProvider {
	
	private static final String DB_CONFIG_PATH = "config.properties";

	private DbProvider() {
		
	}
	
	public static Properties getProperties() {
		Properties properties = new Properties();
		
		ClassLoader classLoader = DbProvider.class.getClassLoader();
		try {
			properties.load(classLoader.getResourceAsStream(DB_CONFIG_PATH));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
	}
	
}
