package com.pkfcooperparry.template.ui.form

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import com.pkfcooperparry.template.R
import com.pkfcooperparry.template.data.model.db.visit.Form

class FormAdapter// data is passed into the constructor
(internal var context: Context, private var itemClickListener: ItemClickListener?, private val pages: List<Form>) : RecyclerView.Adapter<FormAdapter.ViewHolder>() {
    private val inflater: LayoutInflater

    init {
        this.inflater = LayoutInflater.from(context)
    }

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.row_visit, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the view and textview in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val page = pages[position]
        holder.txtVisitId.setText(String.format("%d", page.id))
        holder.parent.setOnClickListener { _ ->
            itemClickListener?.onItemClick(page)
        }
    }

    // total number of rows
    override fun getItemCount(): Int {
        return pages.size
    }

    interface ItemClickListener {
        fun onItemClick(page: Form)
    }

    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var txtVisitId: TextView
        internal var parent: LinearLayout

        init {
            txtVisitId = itemView.findViewById(R.id.txtVisitId)
            parent = itemView.findViewById(R.id.parent)

        }

    }
}