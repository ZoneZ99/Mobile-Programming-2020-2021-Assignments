package id.ac.ui.cs.mobileprogramming.assignments;

import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class SayHelloTest {

	@Test
	public void givenSomeString_ShouldChangeHelloText() {
		String givenText = "Boys";

		String helloText = HelloWorldUtil.sayHello(givenText);

		assertThat(helloText).isEqualTo("Hello, Boys!");
	}

	@Test
	public void givenEmptyString_ShouldNotChangeHelloText() {
		String emptyString = "";

		String helloText = HelloWorldUtil.sayHello(emptyString);

		assertThat(helloText).isEqualTo("Hello, World!");
	}
}
