package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	private static final String Q_GET_ITEM_GROUP_BY_ID =
			"SELECT * FROM t02_item_group WHERE C02_ITEM_GROUP_ID = ?";
	private static final String Q_INSERT_INTO_ITEM_GROUP =
			"""
				INSERT INTO t02_item_group(C02_ITEM_GROUP_NAME)
				VALUES (?);
			""";
	
	private Connection connection;
	private Statement st;
	// thực thi câu sql có tham số, trước khi execute..., truyền tham số rồi mới execute
	private PreparedStatement pst;
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
	
	@Override
	public ItemGroup get(Integer id) {
		ItemGroup itemGroup = null;
		try {
			pst = this.connection.prepareStatement(Q_GET_ITEM_GROUP_BY_ID); // sql có tham số
			pst.setInt(1, id); // set giá trị cho tham số
			rs = pst.executeQuery(); // thực thi câu sql của pst
			if(rs.next()) {
				Integer itemGroupId = rs.getInt("C02_ITEM_GROUP_ID");
				String itemGroupName = rs.getString("C02_ITEM_GROUP_NAME");
				itemGroup = new ItemGroup(itemGroupId, itemGroupName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(rs,pst);
		}
		
		return itemGroup;
	}
	
	@Override
	public void save(ItemGroup itemGroup) {
		try {
			pst = this.connection.prepareStatement(Q_INSERT_INTO_ITEM_GROUP); // sql có tham số
			pst.setString(1, itemGroup.getName()); // set giá trị cho tham số
			pst.executeUpdate(); // thực thi câu sql của pst
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(pst);
		}
	}

}
