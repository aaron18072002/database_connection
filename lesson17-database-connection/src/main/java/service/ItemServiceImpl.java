package service;

import java.util.List;

import dao.ItemDao;
import dao.JdbcItemDao;
import persistence.Item;

public class ItemServiceImpl implements ItemService {
	
	private final ItemDao itemDao;
	
	public ItemServiceImpl() {
		this.itemDao = new JdbcItemDao();
	}

	@Override
	public List<Item> getAll() {
		return this.itemDao.getAll();
	}

}
