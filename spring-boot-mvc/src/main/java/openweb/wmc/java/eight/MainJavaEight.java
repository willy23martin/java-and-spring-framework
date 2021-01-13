package openweb.wmc.java.eight;

public class MainJavaEight {

	// Varargs
	public static void messages(int number, String... messages) {
		System.out.println("Number: " + number);
		for (String message : messages) {
			System.out.println("Messages: " + message);
		}
	}

	public static void main(String[] args) {
		messages(25, new String[] { "m1", "m2", "m3", "m4" });
	}

}
