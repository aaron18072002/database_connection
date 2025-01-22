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
	
	@Override
	public ItemGroup get(String name) {
		Objects.requireNonNull(name, "group name should not be null");
		ItemGroup itemGroup = this.itemGroupDao.get(name);
		return itemGroup;
	}
	
	@Override
	public void save(ItemGroup itemGroup) {
		Objects.requireNonNull(itemGroup, "item group should not be null");
		this.itemGroupDao.save(itemGroup);
	}
	
	@Override
	public void save(List<ItemGroup> itemGroups) {
		if(itemGroups == null || itemGroups.isEmpty()) {
			throw new IllegalArgumentException("Parameter 'groups' is invalid...");
		}
		this.itemGroupDao.save(itemGroups);;
	}
	
	@Override
	public void update(ItemGroup itemGroup) {
		Objects.requireNonNull(itemGroup, "item group should not be null");
		this.itemGroupDao.update(itemGroup);
	}

	@Override
	public void saveOrUpdate(ItemGroup itemGroup) {
		Objects.requireNonNull(itemGroup, "item group should not be null");
		if(this.get(itemGroup.getName()) == null) {			
			this.itemGroupDao.save(itemGroup);
		} else {		
			// should be throw exception
			System.out.println(">>> Exp: Group " + itemGroup.getName() + " has existed!");
		}
	}
	
	@Override
	public void merge(ItemGroup itemGroup) {
		Objects.requireNonNull(itemGroup, "item group should not be null");
		this.itemGroupDao.merge(itemGroup);
	}

}
