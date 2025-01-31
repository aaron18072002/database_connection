package view;

import service.ItemService;
import service.ItemServiceImpl;

import static utils.PrintUtils.*;

import java.time.LocalDate;

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
		
		genarate(
				"9. Liệt kê các mặt hàng được bán theo ngày ...",
				itemService.getItems(LocalDate.of(2025, 01, 31)));
		
		System.out.println("\n=======================================\n");
		System.out.println("Kết thúc chương trình");
		
	}
	
}
