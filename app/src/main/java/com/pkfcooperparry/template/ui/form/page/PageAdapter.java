package com.pkfcooperparry.template.ui.form.page;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pkfcooperparry.template.R;
import com.pkfcooperparry.template.data.model.db.visit.Page;

import java.util.List;

public class PageAdapter extends RecyclerView.Adapter<PageAdapter.ViewHolder> {

    Context context;
    private List<Page> pages;
    private LayoutInflater inflater;
    private ItemClickListener itemClickListener;

    // data is passed into the constructor
    public PageAdapter(Context context, ItemClickListener itemClickListener, List<Page> pages) {
        this.inflater = LayoutInflater.from(context);
        this.itemClickListener = itemClickListener;
        this.context = context;
        this.pages = pages;
    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_page, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setTextColor(ContextCompat.getColor(context, R.color.page_text_color));

        Page page = pages.get(position);
        holder.name.setText(page.getPageTitle());
        holder.image.setImageDrawable(getImage(page));
        holder.parent.setOnClickListener(v -> {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(page);
            }
        });
        holder.item.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_page_selector));


    }

    private Drawable getImage(Page page) {
        return ContextCompat.getDrawable(context, R.drawable.page_placeholder);

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return pages.size();
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    public interface ItemClickListener {
        void onItemClick(Page page);

    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        RelativeLayout parent;
        RelativeLayout item;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.pageName);
            image = itemView.findViewById(R.id.pageIcon);
            parent = itemView.findViewById(R.id.topItem);
            item = itemView.findViewById(R.id.item);

        }

    }
}