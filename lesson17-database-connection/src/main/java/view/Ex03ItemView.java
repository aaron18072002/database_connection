package view;

import service.ItemService;
import service.ItemServiceImpl;

import static utils.PrintUtils.*;

public class Ex03ItemView {
	
	private static ItemService itemService;
	
	static {
		itemService = new ItemServiceImpl();
	}

	public static void main(String[] args) {
		
		System.out.println("Bắt đầu chương trình");
		System.out.println("=======================================\n");
		
		genarate(
				"7. Liệt kê các mặt hàng (kèm tt loại hàng)",
				itemService.getAll());
		
		System.out.println("\n=======================================\n");
		System.out.println("Kết thúc chương trình");
		
	}
	
}
