package com.ridwanharts.jadwaladzan.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.ridwanharts.jadwaladzan.R
import com.ridwanharts.jadwaladzan.data.db.entities.Data
import com.ridwanharts.jadwaladzan.data.db.entities.TimeAdzan
import kotlinx.android.synthetic.main.item_adzan.view.*

class TestAdapter : RecyclerView.Adapter<TestAdapter.MyViewHolder>(){

    private var listTimeAdzan = ArrayList<TimeAdzan>()

    fun setTimeAdzan(data: List<TimeAdzan>?){
        if (data == null) return
        listTimeAdzan.clear()
        listTimeAdzan.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestAdapter.MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_adzan, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listTimeAdzan.size
    }

    override fun onBindViewHolder(holder: TestAdapter.MyViewHolder, position: Int) {
        val data = listTimeAdzan[position]
        holder.bind(data)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(timeAdzan : TimeAdzan){
            with(itemView){
                text_adzan.text = timeAdzan.text
                time_adzan.text = timeAdzan.time
            }
        }

    }

}