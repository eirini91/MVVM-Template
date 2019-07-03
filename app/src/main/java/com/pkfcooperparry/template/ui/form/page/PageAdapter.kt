package com.pkfcooperparry.template.ui.form.page

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

import com.pkfcooperparry.template.R
import com.pkfcooperparry.template.data.model.db.visit.Page

class PageAdapter// data is passed into the constructor
(internal var context: Context, private var itemClickListener: ItemClickListener?, private val pages: List<Page>) : RecyclerView.Adapter<PageAdapter.ViewHolder>() {
    private val inflater: LayoutInflater

    init {
        this.inflater = LayoutInflater.from(context)
    }

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.row_page, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the view and textview in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setTextColor(ContextCompat.getColor(context, R.color.page_text_color))

        val page = pages[position]
        holder.name.text = page.pageTitle
        holder.image.setImageDrawable(getImage(page))
        holder.parent.setOnClickListener { v ->
            if (itemClickListener != null) {
                itemClickListener!!.onItemClick(page)
            }
        }
        holder.item.background = ContextCompat.getDrawable(context, R.drawable.bg_page_selector)


    }

    private fun getImage(page: Page): Drawable? {
        return ContextCompat.getDrawable(context, R.drawable.page_placeholder)

    }

    // total number of rows
    override fun getItemCount(): Int {
        return pages.size
    }

    fun setClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }


    interface ItemClickListener {
        fun onItemClick(page: Page)

    }

    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var name: TextView
        internal var image: ImageView
        internal var parent: RelativeLayout
        internal var item: RelativeLayout

        init {
            name = itemView.findViewById(R.id.pageName)
            image = itemView.findViewById(R.id.pageIcon)
            parent = itemView.findViewById(R.id.topItem)
            item = itemView.findViewById(R.id.item)

        }

    }
}