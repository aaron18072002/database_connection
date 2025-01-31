package dao;

import java.util.List;

import persistence.Item;

public interface ItemDao {

	/**
	 * Get all item groups.
	 * @return List of {@link Item}
	 */
	List<Item> getAll();
	
}
