package com.example.a2by3_android.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a2by3_android.R
import kotlinx.android.synthetic.main.item_search_suggesstion.view.*

class SearchHistoryAdapter(private val colors: MutableList<String>) : RecyclerView.Adapter<SearchHistoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflate the custom view from xml layout file
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_search_suggesstion,parent,false)
        // return the view holder
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // display the current color
        holder.mSearchTextView.text = colors[position]
    }

    override fun getItemCount(): Int {
        // number of items in the data set held by the adapter
        return colors.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val mSearchTextView: TextView = itemView.searchTextView
    }

    // this two methods useful for avoiding duplicate item
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}