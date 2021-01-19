package com.example.hrybkov_l14

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val items: List<Pair<Person, Int>>) : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_element, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(pair: Pair<Person, Int>) {
            itemView.run {
                findViewById<LinearLayout>(R.id.recyclerViewLayout).setPadding(pair.second*20, 0, 0, 0)
                findViewById<TextView>(R.id.tvName).text = pair.first.name
                findViewById<TextView>(R.id.tvAge).text = pair.first.age.toString()
            }
        }
    }
}