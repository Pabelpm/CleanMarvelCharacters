package com.pabelpm.cleanmarvelcharacters

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.pabelpm.cleanmarvelcharacters.ui.NavigationHostActivity
import com.schibsted.spain.barista.assertion.BaristaListAssertions
import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NavigationHostActivityInstrumentedTest {

    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule(NavigationHostActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.pabelpm.cleanmarvelcharacters", appContext.packageName)
    }



    @Test
    @Ignore("Wait for server, recheck or mock")
    fun checkIfFirstTitleIsShowing() {
        BaristaListAssertions.assertDisplayedAtPosition(
            R.id.marvelCharactersRecyclerView,
            0,
            "3-D Man"
        )
    }
}