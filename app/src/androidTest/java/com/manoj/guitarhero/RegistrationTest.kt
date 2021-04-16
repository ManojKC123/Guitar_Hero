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
    fun testLoginUI() {
        Espresso.onView(ViewMatchers.withId(R.id.fname))
            .perform(ViewActions.typeText("kiran"))
        Espresso.onView(ViewMatchers.withId(R.id.lname))
            .perform(ViewActions.typeText("rana"))
        Espresso.onView(ViewMatchers.withId(R.id.etnumber))
            .perform(ViewActions.typeText("kiran456"))
        Espresso.onView(ViewMatchers.withId(R.id.address))
            .perform(ViewActions.typeText("password"))
        Espresso.onView(ViewMatchers.withId(R.id.mailId))
            .perform(ViewActions.typeText("password@gmail.com"))
        Espresso.onView(ViewMatchers.withId(R.id.pass1))
            .perform(ViewActions.typeText("password"))
        Espresso.onView(ViewMatchers.withId(R.id.pass2))
            .perform(ViewActions.typeText("password"))

        closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.submit))
            .perform(ViewActions.click())

    }
}