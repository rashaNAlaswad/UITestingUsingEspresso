package com.example.uiautomationtestingusingespresso;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void testTextViewIsDisplayed() {
        onView(withId(R.id.textView)).check(matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testButtonClickTogglesViewVisibility() {
        onView(ViewMatchers.withId(R.id.hiddenView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));

        onView(ViewMatchers.withId(R.id.button)).perform(click());

        onView(ViewMatchers.withId(R.id.hiddenView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

        onView(ViewMatchers.withId(R.id.button)).perform(click());

        onView(ViewMatchers.withId(R.id.hiddenView)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
    }

    @Test
    public void testButtonLongClickNavigatesToLoginActivity() {
        onView(ViewMatchers.withId(R.id.button)).perform(longClick());
        intended(hasComponent(LoginActivity.class.getName()));
    }
}

