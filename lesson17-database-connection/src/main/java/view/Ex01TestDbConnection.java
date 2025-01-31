package view;

public class Ex01TestDbConnection {

	public static void main(String[] args) {
		
//		System.out.println("MySql connection: " + DbConnection.getConnection());
		
		
		 Object error = new Error();
		    Object runtimeException = new RuntimeException();
		    System.out.print((error instanceof Exception) + ",");
		    System.out.print(runtimeException instanceof Exception);
	}
}
