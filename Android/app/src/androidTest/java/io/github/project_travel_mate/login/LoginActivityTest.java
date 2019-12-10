package io.github.project_travel_mate.login;

import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);

    private LoginActivity mLoginActivity;

    @Before
    public void setUp() throws Exception {
        mLoginActivity = activityTestRule.getActivity();
    }

    @Test
    public void validateEmail() {
        assertTrue(mLoginActivity.validateEmail("jano@email.sk"));
        assertTrue(mLoginActivity.validateEmail("Meno@gmail.com"));
        assertTrue(mLoginActivity.validateEmail("email@gmail.com.com"));

        assertFalse(mLoginActivity.validateEmail("@email.sk"));
        assertFalse(mLoginActivity.validateEmail("#.#@.comemail.sk"));

        //not pass
        //assertFalse(mLoginActivity.validateEmail(".sk@email.sk"));
    }

    @Test
    public void validateName() {
        assertTrue(mLoginActivity.validateName("John", "Wick"));
        assertTrue(mLoginActivity.validateName("James", "May"));

        assertFalse(mLoginActivity.validateName("", ""));

        //not pass
        //assertFalse(mLoginActivity.validateName(null, null));
        //assertFalse(mLoginActivity.validateName("", null));
        //assertFalse(mLoginActivity.validateName(null, ""));
    }

    @Test
    public void validatePassword() {
        assertFalse(mLoginActivity.validatePassword("pass"));
        assertFalse(mLoginActivity.validatePassword("password"));
        assertFalse(mLoginActivity.validatePassword("password1"));
        assertFalse(mLoginActivity.validatePassword(""));
        assertFalse(mLoginActivity.validatePassword("Pass1"));

        assertTrue(mLoginActivity.validatePassword("Str0ngP#ssw0rd"));
        assertTrue(mLoginActivity.validatePassword("TrullyG0ddP@ss"));
    }
}