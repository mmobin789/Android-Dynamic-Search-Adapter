package stacktex.mobin.search.adapter

import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView

abstract class DynamicSearchAdapter<T : DynamicSearchAdapter.Searchable>(private val searchableList: MutableList<T>) :
        RecyclerView.Adapter<ViewHolder>(), Filterable {

    // Single not-to-be-modified copy of original data in the list.
    private val originalList = ArrayList(searchableList)
    // a method-body to invoke when search returns nothing. It can be null.
    private var onNothingFound: (() -> Unit)? = null

    /**
     * Searches a specific item in the list and updates adapter.
     * if the search returns empty then onNothingFound callback is invoked if provided which can be used to update UI
     * @param s the search query or text. It can be null.
     * @param onNothingFound a method-body to invoke when search returns nothing. It can be null.
     */
    fun search(s: String?, onNothingFound: (() -> Unit)?) {
        this.onNothingFound = onNothingFound
        filter.filter(s)

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            private val filterResults = FilterResults()
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                searchableList.clear()
                if (constraint.isNullOrBlank()) {
                    searchableList.addAll(originalList)
                } else {
                        
                    
                        //Converting originalList to Lowercase also converting constraint into lowercase to make full Search, 
                        //without lowercase our search is not working, Suppose if you have two names in your list (John steven and Steven john)
                        // if you search 'John' you only get 'John steven', but when we make lowercase if you search 'John' you will get 
                        //'John steven' and 'Steven John'
               
                    val searchResults = originalList.filter { it.getSearchCriteria().toLowerCase(Locale.getDefault()).contains(constraint.toString().toLowerCase(Locale.getDefault())) }
                    searchableList.addAll(searchResults)
                }
                return filterResults.also {
                    it.values = searchableList
                }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                // no need to use "results" filtered list provided by this method.
                if (searchableList.isNullOrEmpty())
                    onNothingFound?.invoke()
                notifyDataSetChanged()

            }
        }
    }

    interface Searchable {
        /** This method will allow to specify a search string to compare against
        your search this can be anything depending on your use case.
         */
        fun getSearchCriteria(): String
    }


}
