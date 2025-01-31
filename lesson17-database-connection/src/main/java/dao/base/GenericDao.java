package dao.base;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import connection.DbConnection;

/**
 * Generic base for all DAO classes
 */
public class GenericDao {

	protected Connection connection;
	
	protected Statement st;
	protected PreparedStatement pst;
	protected CallableStatement cst;
	
	protected ResultSet rs;
	
	public GenericDao() {
		this.connection = DbConnection.getConnection();
	}
	
}
