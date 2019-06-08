package stacktex.mobin.search.model

import stacktex.mobin.search.adapter.DynamicSearchAdapter

class SearchModel1(val data: String) : DynamicSearchAdapter.Searchable {


    override fun getSearchCriteria(): String {
        return data
    }
}