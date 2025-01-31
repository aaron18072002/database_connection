package dao;

import java.util.List;

import persistence.ItemGroup;
import persistence.dto.ItemGroupDto;

public interface ItemGroupDao {

	/**
	 * Get all item groups.
	 * @return List of {@link ItemGroup}
	 */
	List<ItemGroup> getAll();
	
	/**
	 * Get details info of each item group
	 * @return list of {@link ItemGroupDto}
	 */
	List<ItemGroupDto> getItemGroupDetails();
	
	/**
	 * Get unique {@link ItemGroup} with given id
	 * @param id the id
	 * @return available {@link ItemGroup} or null if not exist
	 */ 
	ItemGroup get(Integer id);
	
	/**
	 * Get unique {@link ItemGroup} with given name
	 * @param name the name
	 * @return available {@link ItemGroup} or null if not exist
	 */ 
	ItemGroup get(String name);
	
	/**
	 * Save group to database
	 * @param itemGroup
	 * throw SQLIntegrityConstraintViolationException if group name is overlapped
	 * TODO: need validate before saving...
	 */
	void save(ItemGroup itemGroup);
	
	/**
	 * Save groups to database
	 * @param itemGroups the itemGroups
	 * throw SQLIntegrityConstraintViolationException if group name is overlapped
	 * TODO: need validate before saving...
	 */
	void save(List<ItemGroup> itemGroups);
	
	/**
	 * Update item group
	 * @param itemGroup
	 * throw SQLIntegrityConstraintViolationException if group name is overlapped
	 * TODO: need validate before updating...
	 */
	void update(ItemGroup itemGroup);
	
	/**
	 * Save Or Update item group
	 * @param itemGroup
	 */
	void saveOrUpdate(ItemGroup itemGroup);
	
	/**
	 * Merge item group
	 * @param itemGroup
	 */
	void merge(ItemGroup itemGroup);
	
}
