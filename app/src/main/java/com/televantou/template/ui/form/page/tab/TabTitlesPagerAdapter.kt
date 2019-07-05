package com.televantou.template.ui.form.page.tab

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.televantou.template.R
import com.televantou.template.data.model.db.visit.Tab

class TabTitlesPagerAdapter// data is passed into the constructor
(internal var context: Context, private var itemClickListener: ItemClickListener?, private val tabs: List<Tab>) : RecyclerView.Adapter<TabTitlesPagerAdapter.ViewHolder>() {
    internal var selectedItem = 0
    private val inflater: LayoutInflater

    init {
        this.inflater = LayoutInflater.from(context)
    }

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.row_tab, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the view and textview in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tab = tabs[position]
        if (position == selectedItem) {
            holder.button.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
            holder.button.setTextColor(ContextCompat.getColor(context, android.R.color.white))
        } else {
            holder.button.setBackgroundColor(ContextCompat.getColor(context, android.R.color.white))
            holder.button.setTextColor(ContextCompat.getColor(context, R.color.colorLightTextColour))

        }
        holder.button.text = tab.tabName
    }

    // total number of rows
    override fun getItemCount(): Int {
        return tabs.size
    }

    fun updateSelected(selectedItem: Int) {
        val temp = this.selectedItem
        this.selectedItem = selectedItem
        notifyItemChanged(temp)
        notifyItemChanged(selectedItem)
    }

    fun setClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }


    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        internal var button: Button

        init {
            button = itemView.findViewById(R.id.button)
            button.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            if (itemClickListener != null) {
                itemClickListener!!.onItemClick(view, adapterPosition)
            }
        }
    }
}