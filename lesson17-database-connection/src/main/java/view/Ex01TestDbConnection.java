package view;

import connection.DbConnection;

public class Ex01TestDbConnection {

	public static void main(String[] args) {
		
		System.out.println("MySql connection: " + DbConnection.getConnection());
		
	}
	
}
