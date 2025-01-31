package persistence;

import java.util.Objects;

public class Item {

	private Integer id;
	private String name;
	
	// Quan hệ 1-1
	private ItemGroup itemGroup;
	
	public Item() {
		
	}
	
	public Item(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Item(Integer id, String name, ItemGroup itemGroup) {
		super();
		this.id = id;
		this.name = name;
		this.itemGroup = itemGroup;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ItemGroup getItemGroup() {
		return itemGroup;
	}

	public void setItemGroup(ItemGroup itemGroup) {
		this.itemGroup = itemGroup;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Item)) {
			return false;
		}
		
		Item that = (Item)obj;
		
		return this.getId() == that.getId();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getId());
	}
	
	public void logging() {
		
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", itemGroup=" + itemGroup + "]";
	}
	
}
