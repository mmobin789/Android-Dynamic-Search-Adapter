package stacktex.mobin.search.adapter

import androidx.test.espresso.Espresso
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import stacktex.mobin.search.ui.main.SampleActivity2

class SampleActivityInstrumentedTest {
    @Rule
    @JvmField
    val activityRule = ActivityTestRule(SampleActivity2::class.java)


    @Test
    fun testSampleActivity() {
        val mainActivity = activityRule.activity as SampleActivity2
        Espresso.onView(ViewMatchers.withId(R.id.rv))
            .inRoot(RootMatchers.withDecorView(Matchers.`is`(mainActivity.window.decorView)))
            .perform(RecyclerViewActions.scrollToPosition<ViewHolder>(50))
    }
}