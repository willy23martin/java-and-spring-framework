package openweb.wmc.java.eight;

import java.util.Set;

public interface ML extends IA, Set<String> {

	public static void staticMethod() {
		System.out.println("Static method in interface");
	}

}
