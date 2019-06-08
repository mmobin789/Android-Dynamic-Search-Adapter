package stacktex.mobin.search.adapter

import android.view.ViewGroup
import android.widget.TextView
import stacktex.mobin.search.model.SearchModel1

class SearchAdapter1(private val mutableList: MutableList<SearchModel1>) :
    DynamicSearchAdapter<SearchModel1>(mutableList) {


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