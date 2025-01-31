package dao;

import java.sql.SQLException;
import java.time.LocalDate;
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
	private static final String Q_GET_ITEMS_BY_SALES_DATE = """
				SELECT DISTINCT t01.*
				FROM t01_item AS t01 
				JOIN t03_item_detail AS t03 ON t01.C01_ITEM_ID = t03.C03_ITEM_ID 
				JOIN t05_order_detail AS t05 ON t05.C05_ITEM_DETAIL_ID = t03.C03_ITEM_DETAIL_ID 
				JOIN t04_order AS t04 ON t04.C04_ORDER_ID = t05.C05_ORDER_ID
				WHERE date(t04.C04_ORDER_TIME) = ?;
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
	
	@Override
	public List<Item> getItems(LocalDate salesDate) {
		List<Item> items = new ArrayList<Item>();
		try {
			this.pst = this.connection.prepareStatement(Q_GET_ITEMS_BY_SALES_DATE);
			this.pst.setDate(1, toSqlDate(salesDate));
			this.rs = this.pst.executeQuery();
			while(this.rs.next()) {
				Item item = new Item
						(rs.getInt("C01_ITEM_ID"),rs.getNString("C01_ITEM_NAME"));
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return items;
	}

}
