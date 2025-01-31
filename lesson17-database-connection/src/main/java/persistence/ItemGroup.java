package persistence;

import java.util.List;
import java.util.Objects;

public class ItemGroup {

	private Integer id;
	private String name;
	private List<Item> items;
	
	public ItemGroup() {
		
	}
	
	public ItemGroup(String name) {
		this.name = name;
	}

	public ItemGroup(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		
		if((o instanceof ItemGroup) == false) {
			return false;
		}
		
		ItemGroup that = (ItemGroup)o;
		
		return this.getId() == that.getId();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getId());
	}
	
	public void logging() {
		System.out.printf("Group(id=%s, name=%s)", this.getId(), this.getName()).println();
		System.out.println("--------------------");
		this.items.forEach(item -> {
			System.out.printf("		+ Item(id=%s, name=%s)\n", item.getId(), item.getName());
		});
		System.out.println("\n");
	}

	@Override
	public String toString() {
		return "ItemGroup [id=" + id + ", name=" + name + "]";
	}
	
}
