package com.manoj.guitarhero
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class RegistrationTest {
    @get:Rule
    val testRule = ActivityScenarioRule(SignUpActivity::class.java)

    @Test
    fun RegistrationTest() {
        Espresso.onView(ViewMatchers.withId(R.id.fname))
            .perform(ViewActions.typeText("Manoj"))
        closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.lname))
            .perform(ViewActions.typeText("KC"))
        closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.etnumber))
            .perform(ViewActions.typeText("9843774669"))
        closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.address))
            .perform(ViewActions.typeText("Dolakha"))
        closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.mailId))
            .perform(ViewActions.typeText("usert@gmail.com"))
        closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.pass1))
            .perform(ViewActions.typeText("manoj"))
        closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.pass2))
            .perform(ViewActions.typeText("manoj"))
        closeSoftKeyboard()

        closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.submit))
            .perform(ViewActions.click())

    }
}