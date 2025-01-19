package service;

import java.util.List;
import java.util.Objects;

import dao.ItemGroupDao;
import dao.JdbcItemGroupDao;
import persistence.ItemGroup;

public class ItemGroupServiceImpl implements ItemGroupService {
	
	private final ItemGroupDao itemGroupDao;
	
	public ItemGroupServiceImpl() {
		this.itemGroupDao = new JdbcItemGroupDao();
	}

	@Override
	public List<ItemGroup> getAll() {
		return this.itemGroupDao.getAll();
	}
	
	@Override
	public ItemGroup get(Integer id) {
		Objects.requireNonNull(id, "group id should not be null");
		return this.itemGroupDao.get(id);
	}

}
