package utils;

import java.util.Collection;

public class PrintUtils {

	private PrintUtils() {
		
	}
	
	public static <E> void genarate(String text, Collection<E> collection) {
		System.out.println(text + " --> {");
		for(E element:collection) {
			System.out.println("	+ " + element);
		}
		System.out.println("}\n");
	}
	
}
