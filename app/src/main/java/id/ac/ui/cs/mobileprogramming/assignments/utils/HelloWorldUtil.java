package id.ac.ui.cs.mobileprogramming.assignments.utils;

public class HelloWorldUtil {

	public static String sayHello(String text) {
		return text.equals("") ? "Hello, World!" : "Hello, " + text + "!";
	}
}
