package com.manoj.guitarhero

import androidx.core.content.MimeTypeFilter.matches
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule


@LargeTest
@RunWith(AndroidJUnit4::class)
class LoginTest {

    @get:Rule
    val testRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun testLoginUI(){
        onView(withId(R.id.EditText_email))
            .perform(typeText("user1@gmail.com"))

        onView(withId(R.id.EditText_password))
            .perform(typeText("u"))

        closeSoftKeyboard()

        onView(withId(R.id.loginbtn))
            .perform(click())

        Thread.sleep(2000)
    }
}