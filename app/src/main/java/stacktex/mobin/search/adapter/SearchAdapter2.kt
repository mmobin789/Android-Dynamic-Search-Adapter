package stacktex.mobin.search.adapter

import android.view.ViewGroup
import android.widget.TextView
import stacktex.mobin.search.model.SearchModel2

class SearchAdapter2(private val mutableList: MutableList<SearchModel2>) :
    DynamicSearchAdapter<SearchModel2>(mutableList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val textView = TextView(parent.context)
        return ViewHolder(textView)
    }

    override fun getItemCount(): Int {
        return mutableList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tv = holder.containerView as TextView
        tv.text = mutableList[position].data

    }


}