package persistence.dto;

public class ItemGroupDto {

	private Integer id;
	private String name;
	private Integer amountOfItems;
	private String listOfItems;
	
	public ItemGroupDto() {
		
	}

	public ItemGroupDto(Integer id, String name, Integer amountOfItems, String listOfItems) {
		super();
		this.id = id;
		this.name = name;
		this.amountOfItems = amountOfItems;
		this.listOfItems = listOfItems;
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

	public Integer getAmountOfItems() {
		return amountOfItems;
	}

	public void setAmountOfItems(Integer amountOfItems) {
		this.amountOfItems = amountOfItems;
	}

	public String getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(String listOfItems) {
		this.listOfItems = listOfItems;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof ItemGroupDto)) {
			return false;
		}
		
		ItemGroupDto that = (ItemGroupDto)obj;
		
		return this.getId() == that.getId();
	}

	@Override
	public String toString() {
		return "ItemGroupDto [id=" + id + ", name=" + name + ", amountOfItems=" + amountOfItems + ", listOfItems="
				+ listOfItems + "]";
	}
	
}
