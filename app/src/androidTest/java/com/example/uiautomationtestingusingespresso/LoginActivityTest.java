package com.example.uiautomationtestingusingespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    @Before
    public void setUp() {
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void testEmailAndPasswordValidation() {
        onView(ViewMatchers.withId(R.id.emailEditText))
                .perform(ViewActions.typeText("rasha.n.alaswad@gmail.com"), ViewActions.closeSoftKeyboard());

        onView(ViewMatchers.withId(R.id.passwordEditText))
                .perform(ViewActions.typeText("12345678"), ViewActions.closeSoftKeyboard());

        onView(ViewMatchers.withId(R.id.btn_login))
                .perform(click());

        onView(ViewMatchers.withId(R.id.emailValidationText))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

        onView(ViewMatchers.withId(R.id.passwordValidationText))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }
}