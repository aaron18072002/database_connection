package service;

import java.time.LocalDate;
import java.util.List;

import persistence.Item;

public interface ItemService {

	/**
	 * Get all item groups.
	 * @return List of {@link Item}
	 */
	List<Item> getAll();
	
	/**
	 * Get items which sales in the given salesDate
	 * @param salesDate sales date
	 * @return sales Items
	 */
	List<Item> getItems(LocalDate salesDate);
	
}
