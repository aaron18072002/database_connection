package view;

import service.ItemGroupService;
import service.ItemGroupServiceImpl;

import static utils.PrintUtils.*;

public class Ex02ItemGroupView {
	
	private static ItemGroupService itemGroupService;
	
	static {
		itemGroupService = new ItemGroupServiceImpl();
	}

	public static void main(String[] args) {
		genarate("1. Liệt kê tất cả các loại hàng",
				itemGroupService.getAll());
		
		genarate("2. Liệt kê loại hàng có mã = 4",
				itemGroupService.get(4));
	}
	
}
