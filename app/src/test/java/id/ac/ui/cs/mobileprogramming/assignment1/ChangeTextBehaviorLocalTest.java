package id.ac.ui.cs.mobileprogramming.assignment1;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
public class ChangeTextBehaviorLocalTest {

	@Rule
	public ActivityScenarioRule<MainActivity> activityScenarioRule =
		new ActivityScenarioRule<>(MainActivity.class);

	@Before
	public void intentsInit() {
		Intents.init();
	}

	@After
	public void intentsTeardown() {
		Intents.release();
	}

	@Test
	public void changeText_onButtonClick() {
		onView(withId(R.id.nameInputField))
			.perform(typeText("Boys"), closeSoftKeyboard());

		onView(withId(R.id.submitButton)).perform(click());

		onView(withId(R.id.helloDisplay)).check(
			matches(withText("Hello, Boys!"))
		);
	}

	@Test
	public void changeText_onEmptyStringSubmit() {
		onView(withId(R.id.nameInputField))
			.perform(typeText(""), closeSoftKeyboard());

		onView(withId(R.id.submitButton)).perform(click());

		onView(withId(R.id.helloDisplay)).check(
			matches(withText("Hello, World!"))
		);
	}
}
