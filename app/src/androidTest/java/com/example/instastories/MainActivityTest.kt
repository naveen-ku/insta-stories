package com.example.instastories

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.instastories.ui.MainActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTest {

    @Test
    fun testItemClickOpensFragment() {
        // Launch MainActivity
        ActivityScenario.launch(MainActivity::class.java)
        // Wait for some time to get fetched data
        Thread.sleep(5000)
        // On click of recycler view item, open story fragment container
        onView(withId(R.id.rvUserStories))
            .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()))

    }
}
