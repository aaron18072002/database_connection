package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import connection.DbConnection;
import persistence.ItemGroup;
import utils.SqlUtils;

public class JdbcItemGroupDao implements ItemGroupDao {
	
	private static final String Q_GET_ALL = "SELECT * FROM t02_item_group";
	private static final String Q_GET_ITEM_GROUP_BY_ID =
			"SELECT * FROM t02_item_group WHERE C02_ITEM_GROUP_ID = ?";
	private static final String Q_GET_ITEM_GROUP_BY_NAME =
			"SELECT * FROM t02_item_group WHERE C02_ITEM_GROUP_NAME = ?";
	private static final String Q_INSERT_INTO_ITEM_GROUP =
			"""
				INSERT INTO t02_item_group(C02_ITEM_GROUP_NAME)
				VALUES (?);
			""";
	private static final String Q_UPDATE_INTO_ITEM_GROUP =
			"""
				UPDATE t02_item_group
				SET C02_ITEM_GROUP_NAME = ?
				WHERE C02_ITEM_GROUP_ID = ?;
			""";
	private static final String Q_MERGE_ITEM_GROUP =
			"""
				CALL mergeNewItemGroup(?,?);
			""";
	
	private Connection connection;
	private Statement st;
	// thực thi câu sql có tham số, trước khi execute..., truyền tham số rồi mới execute
	private PreparedStatement pst;
	private CallableStatement cst;
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
	public ItemGroup get(String name) {
		ItemGroup itemGroup = null;
		try {
			pst = this.connection.prepareStatement(Q_GET_ITEM_GROUP_BY_NAME); // sql có tham số
			pst.setString(1, name); // set giá trị cho tham số
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
	
	@Override
	public void save(List<ItemGroup> itemGroups) {
		try {
			pst = this.connection.prepareStatement(Q_INSERT_INTO_ITEM_GROUP); // sql có tham số
			for(ItemGroup itemGroup : itemGroups) {
				pst.setString(1, itemGroup.getName());
				pst.addBatch(); // mới
			}
			int[] affectedRows = pst.executeBatch(); // mới
			System.out.println("affectedRows --> " + Arrays.toString(affectedRows));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(pst);
		}
	}
	
	@Override
	public void update(ItemGroup itemGroup) {
		try {
			pst = this.connection.prepareStatement(Q_UPDATE_INTO_ITEM_GROUP); 
			pst.setString(1, itemGroup.getName()); 
			pst.setInt(2, itemGroup.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(pst);
		}
	}
	
	@Override
	public void merge(ItemGroup itemGroup) {
		try {
			cst = this.connection.prepareCall(Q_MERGE_ITEM_GROUP);
			cst.setObject(1, itemGroup.getId()); // có thể null nếu insert
			cst.setString(2, itemGroup.getName());
			cst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtils.close(cst);
		}
	}

	@Override
	public void saveOrUpdate(ItemGroup itemGroup) {
		
	}

}
