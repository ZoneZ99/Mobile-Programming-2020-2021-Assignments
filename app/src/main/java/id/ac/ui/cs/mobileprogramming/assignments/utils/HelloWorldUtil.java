package id.ac.ui.cs.mobileprogramming.assignments.utils;

public class HelloWorldUtil {

	public static String sayHello(String text) {
		if (text.equals("")) {
			return "Hello, World!";
		} else {
			return "Hello, " + text + "!";
		}
	}
}
