package stacktex.mobin.search.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import stacktex.mobin.search.adapter.R
import stacktex.mobin.search.adapter.SearchAdapter3
import stacktex.mobin.search.adapter.populateWithUUIDSM3
import stacktex.mobin.search.model.SearchModel3

class SampleActivity2 : AppCompatActivity(), SearchView.OnQueryTextListener {


    private lateinit var searchAdapter3: SearchAdapter3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main)
        rv.layoutManager = LinearLayoutManager(this)
        searchAdapter3 = SearchAdapter3(mutableListOf<SearchModel3>().populateWithUUIDSM3())
        rv.adapter = searchAdapter3
        searchV.setOnQueryTextListener(this)

    }

    override fun onQueryTextChange(newText: String?): Boolean {
        search(newText)
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        search(query)
        return true
    }

    private fun search(s: String?) {
        searchAdapter3.search(s) {
            // update UI on nothing found
            Toast.makeText(this, "Nothing Found", Toast.LENGTH_SHORT).show()
        }
    }
}