package utils;

import java.time.LocalDate;
import java.util.Objects;

public class SqlUtils {

	private SqlUtils() {

	}
	
	public static java.sql.Date toSqlDate(LocalDate ldate) {
		Objects.requireNonNull(ldate, "ldate should not be null");
		return java.sql.Date.valueOf(ldate);
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
