package service;

import java.util.List;

import persistence.ItemGroup;

public interface ItemGroupService {

	/**
	 * Get all item groups.
	 * @return List of {@link ItemGroup}
	 */
	List<ItemGroup> getAll();
	
	/**
	 * Get unique {@link ItemGroup} with given id
	 * @param id the id
	 * @return available {@link ItemGroup} or null if not exist
	 */ 
	ItemGroup get(Integer id);
	
}
