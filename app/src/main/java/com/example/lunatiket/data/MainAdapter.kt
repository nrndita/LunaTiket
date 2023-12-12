package com.example.lunatiket.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lunatiket.R
import com.example.lunatiket.data.remote.PesawatItem

class MainAdapter (var context: Context, var list: List<PesawatItem>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val name1: TextView = view.findViewById(R.id.city)
        val name2: TextView = view.findViewById(R.id.city_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_flight, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name1.text = list[position].city
        holder.name2.text = list[position].cityName
    }
}