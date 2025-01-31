package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.base.GenericDao;
import persistence.Item;
import persistence.ItemGroup;

import static utils.SqlUtils.*;

public class JdbcItemDao extends GenericDao implements ItemDao {
	
	private static final String Q_GET_ALL = """
				SELECT * FROM T01_ITEM AS t1
				LEFT JOIN T02_ITEM_GROUP AS t2
				ON t1.C01_ITEM_GROUP_ID = t2.C02_ITEM_GROUP_ID;
			""";
	
	@Override
	public List<Item> getAll() {
		List<Item> items = new ArrayList<Item>();
		try {
			this.pst = this.connection.prepareStatement(Q_GET_ALL);
			this.rs = this.pst.executeQuery();
			while(rs.next()) {
				ItemGroup itemGroup = new ItemGroup();
				itemGroup.setId(rs.getInt("C02_ITEM_GROUP_ID"));
				itemGroup.setName(rs.getNString("C02_ITEM_GROUP_NAME"));
				
				Item item = new Item();
				item.setId(rs.getInt("C01_ITEM_ID"));
				item.setName(rs.getNString("C01_ITEM_NAME"));	
				item.setItemGroup(itemGroup);
				
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(this.rs, this.pst);
		}
		
		return items;
	}

}
