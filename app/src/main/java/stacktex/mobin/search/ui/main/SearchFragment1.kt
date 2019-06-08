package stacktex.mobin.search.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import stacktex.mobin.search.adapter.R
import stacktex.mobin.search.adapter.SearchAdapter1
import stacktex.mobin.search.adapter.populateWithUUIDSM1
import stacktex.mobin.search.model.SearchModel1

/**
 * A placeholder fragment containing a simple view.
 */
class SearchFragment1 : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var pageViewModel: PageViewModel
    private lateinit var searchAdapter1: SearchAdapter1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rv.layoutManager = LinearLayoutManager(context)
        searchAdapter1 = SearchAdapter1(mutableListOf<SearchModel1>().populateWithUUIDSM1())
        rv.adapter = searchAdapter1
        searchV.setOnQueryTextListener(this)

        pageViewModel.text.observe(this, Observer<String> {
            section_label.text = it
        })

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
        searchAdapter1.search(s) {
            // update UI on nothing found
            Toast.makeText(context, "Nothing Found", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): SearchFragment1 {
            return SearchFragment1().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}