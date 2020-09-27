package id.ac.ui.cs.mobileprogramming.assignments;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ChangeTextBehaviorLocalTest {

	@Rule
	public ActivityScenarioRule<MainActivity> activityScenarioRule =
		new ActivityScenarioRule<>(MainActivity.class);

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
