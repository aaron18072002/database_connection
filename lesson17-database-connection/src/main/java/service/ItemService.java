package service;

import java.util.List;

import persistence.Item;

public interface ItemService {

	/**
	 * Get all item groups.
	 * @return List of {@link Item}
	 */
	List<Item> getAll();
	
}
