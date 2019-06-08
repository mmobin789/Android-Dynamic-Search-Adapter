package stacktex.mobin.search.adapter

import stacktex.mobin.search.model.SearchModel1
import stacktex.mobin.search.model.SearchModel2
import stacktex.mobin.search.model.SearchModel3

//infix fun BaseSearchModel.createSearchable(searchContent: String): DynamicSearchAdapter.Searchable {
//    return object : DynamicSearchAdapter.Searchable {
//        override fun getSearchCriteria() = searchContent
//    }
//
//}

fun MutableList<SearchModel1>.populateWithUUIDSM1(): MutableList<SearchModel1> {
    for (i in 0..50)
        add(SearchModel1(java.util.UUID.randomUUID().toString()))
    return this

}

fun MutableList<SearchModel2>.populateWithUUIDSM2(): MutableList<SearchModel2> {
    for (i in 0..50)
        add(SearchModel2(java.util.UUID.randomUUID().toString()))
    return this


}

fun MutableList<SearchModel3>.populateWithUUIDSM3(): MutableList<SearchModel3> {
    for (i in 0..50)
        add(SearchModel3(java.util.UUID.randomUUID().toString()))
    return this


}



