package dao;

import java.util.List;

import persistence.ItemGroup;

public interface ItemGroupDao {

	/**
	 * Get all item groups.
	 * @return List of {@link ItemGroup}
	 */
	List<ItemGroup> getAll();
	
}
