package com.pkfcooperparry.template.ui.form.page.tab;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pkfcooperparry.template.R;
import com.pkfcooperparry.template.data.model.db.visit.Tab;

import java.util.List;

public class TabTitlesPagerAdapter extends RecyclerView.Adapter<TabTitlesPagerAdapter.ViewHolder> {

    Context context;
    int selectedItem = 0;
    private List<Tab> tabs;
    private LayoutInflater inflater;
    private ItemClickListener itemClickListener;

    // data is passed into the constructor
    public TabTitlesPagerAdapter(Context context, ItemClickListener itemClickListener, List<Tab> tabs) {
        this.inflater = LayoutInflater.from(context);
        this.itemClickListener = itemClickListener;
        this.context = context;
        this.tabs = tabs;
    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_tab, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tab tab = tabs.get(position);
        if (position == selectedItem) {
            holder.button.setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));
            holder.button.setTextColor(ContextCompat.getColor(context, android.R.color.white));
        } else {
            holder.button.setBackgroundColor(ContextCompat.getColor(context, android.R.color.white));
            holder.button.setTextColor(ContextCompat.getColor(context, R.color.colorLightTextColour));

        }
        holder.button.setText(tab.getTabName());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return tabs.size();
    }

    public void updateSelected(int selectedItem) {
        int temp = this.selectedItem;
        this.selectedItem = selectedItem;
        notifyItemChanged(temp);
        notifyItemChanged(selectedItem);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Button button;

        ViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
            button.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
}