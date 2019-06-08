package stacktex.mobin.search.adapter

import androidx.recyclerview.widget.RecyclerView

abstract class DynamicSearchAdapter<T : DynamicSearchAdapter.Searchable>(private val searchableList: MutableList<T>) :
    RecyclerView.Adapter<ViewHolder>() {

    // Single not-to-be-modified copy of original data in the list.
    private val originalList = ArrayList(searchableList)

    /**
     * Searches a specific item in the list and updates adapter.
     * if the search returns empty then onNothingFound callback is invoked if provided which can be used to update UI
     * @param s the search query or text. It can be null.
     * @param onNothingFound a method-body to invoke when search returns nothing. It can be null.
     */
    fun search(s: String?, onNothingFound: (() -> Unit)?) {
        searchableList.clear()
        if (s.isNullOrBlank()) {
            searchableList.addAll(originalList)
        } else {
            val searchResults = originalList.filter { it.getSearchCriteria().contains(s) }
            if (searchResults.isEmpty())
                onNothingFound?.invoke()
            else
                searchableList.addAll(searchResults)
        }
        notifyDataSetChanged()

    }


    interface Searchable {
        /** This method will allow to specify a search string to compare against
        your search this can be anything depending on your use case.
         */
        fun getSearchCriteria(): String
    }


}