package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.DbConnection;
import persistence.ItemGroup;
import utils.SqlUtils;

public class JdbcItemGroupDao implements ItemGroupDao {
	
	private static final String Q_GET_ALL = "SELECT * FROM t02_item_group";
	
	private Connection connection;
	private Statement st;
	private ResultSet rs;
	
	public JdbcItemGroupDao() {
		this.connection = DbConnection.getConnection();
	}

	@Override
	public List<ItemGroup> getAll() {
		List<ItemGroup> result = new ArrayList<ItemGroup>();
		try {
			st = this.connection.createStatement();
			rs = st.executeQuery(Q_GET_ALL);
			while(rs.next()) {
				Integer id = rs.getInt("C02_ITEM_GROUP_ID");
				String name = rs.getString("C02_ITEM_GROUP_NAME");
				result.add(new ItemGroup(id,name));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs,st);
		}
		
		return result;
	}

}
