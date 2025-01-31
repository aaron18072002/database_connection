package view;

import service.ItemGroupService;
import service.ItemGroupServiceImpl;

import static utils.PrintUtils.*;

import persistence.ItemGroup;

public class Ex02ItemGroupView {
	
	private static ItemGroupService itemGroupService;
	
	static {
		itemGroupService = new ItemGroupServiceImpl();
	}

	public static void main(String[] args) {
		
		System.out.println("Bắt đầu chương trình");
		System.out.println("=======================================\n");
		genarate("1. Liệt kê tất cả các loại hàng",
				itemGroupService.getAll());
		
		genarate("2. Liệt kê loại hàng có mã = 4",
				itemGroupService.get(4));
		
		System.out.println("3. Thêm mới loại hàng\n");
			itemGroupService.merge(new ItemGroup("Balo học sinh"));
		
		System.out.println("\n4. Cập nhật loại hàng\n");
			itemGroupService.merge(new ItemGroup(1,"Áo cho em bé"));
		
		System.out.println("\n5. Liệt kê loại hàng có tên loại = \"Quần\"\n");
			itemGroupService.get("Quần");
		
		// Thêm N phần tử
		// Nếu 1/x phần tử lỗi --> các phần tử còn lại vẫn đc thêm
		// yêu cầu: nếu tồn tại 1 loại hàng lỗi --> rollback
//		System.out.println("\n6. Thêm mới N loại hàng\n");
//		itemGroupService.save(List.of(
//					new ItemGroup("Loại hàng G1"),
//					new ItemGroup("Loại hàng G2")
//				));
		
		System.out.println("\n8. Liệt kê các loại hàng(kèm ds mặt hàng)");
			itemGroupService.getGroupOfItems()
				.forEach(g -> g.logging());
		
		genarate(
			"\n10. Đếm SL các mặt hàng theo từng loại hàng"
			, itemGroupService.getItemGroupDetails());
		
		System.out.println("\n=======================================\n");
		System.out.println("Kết thúc chương trình");
		
	}
	
}
