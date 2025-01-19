package utils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class PrintUtils {

	private PrintUtils() {
		
	}
	
	public static <E> void genarate(String text, Collection<E> collection) {
		System.out.println(text + " --> {");
		for(E element:collection) {
			System.out.println(" + " + element);
		}
		System.out.println("}\n");
	}
	
	public static <E> void genarate(String text, E element) {
		Optional.ofNullable(element)
			.ifPresentOrElse(val -> {
				genarate(text, List.of(element));
			}, () -> {
				System.out.println(text);
				System.out.println("--> Phần tử ko tồn tại");
			});
	}
	
}
