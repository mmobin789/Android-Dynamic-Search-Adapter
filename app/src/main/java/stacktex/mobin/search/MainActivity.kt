package stacktex.mobin.search

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import stacktex.mobin.search.adapter.R
import stacktex.mobin.search.ui.main.SampleActivity2
import stacktex.mobin.search.ui.main.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        viewPager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(viewPager)
        fab.setOnClickListener { view ->
            startActivity(Intent(view.context, SampleActivity2::class.java))
        }
    }
}