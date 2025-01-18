package utils;

public class SqlUtils {

	private SqlUtils() {

	}

	public static void close(AutoCloseable... closeableObjects) {
		try {
			for (AutoCloseable object : closeableObjects) {
				if (object != null) {
					object.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
