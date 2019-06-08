package stacktex.mobin.search.adapter

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import stacktex.mobin.search.MainActivity
import stacktex.mobin.search.ui.main.SearchFragment1

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class MainActivityInstrumentedTest {
    @Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testFloatingButtonClick() {
        val mainActivity = activityRule.activity as MainActivity
        Espresso.onView(ViewMatchers.withId(R.id.fab))
            .inRoot(RootMatchers.withDecorView(Matchers.`is`(mainActivity.window.decorView)))
            .perform(ViewActions.click())


    }


    @Test
    fun testTab1Search() {
        launchFragmentInContainer {
            SearchFragment1.newInstance(0)
        }
        Espresso.onView(ViewMatchers.withId(R.id.searchV)).perform(ViewActions.typeText("abc"))
    }
}
