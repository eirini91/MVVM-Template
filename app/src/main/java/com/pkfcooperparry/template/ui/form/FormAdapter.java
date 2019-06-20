package com.pkfcooperparry.template.ui.form;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pkfcooperparry.template.R;
import com.pkfcooperparry.template.data.model.db.visit.Form;

import java.util.List;

public class FormAdapter extends RecyclerView.Adapter<FormAdapter.ViewHolder> {

    Context context;
    private List<Form> pages;
    private LayoutInflater inflater;
    private ItemClickListener itemClickListener;

    // data is passed into the constructor
    public FormAdapter(Context context, ItemClickListener itemClickListener, List<Form> pages) {
        this.inflater = LayoutInflater.from(context);
        this.itemClickListener = itemClickListener;
        this.context = context;
        this.pages = pages;
    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_visit, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Form page = pages.get(position);
        holder.txtVisitId.setText(String.format("%d", page.getId()));
        holder.parent.setOnClickListener(v -> {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(page);
            }
        });
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return pages.size();
    }

    public interface ItemClickListener {
        void onItemClick(Form page);
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtVisitId;
        LinearLayout parent;

        ViewHolder(View itemView) {
            super(itemView);
            txtVisitId = itemView.findViewById(R.id.txtVisitId);
            parent = itemView.findViewById(R.id.parent);

        }

    }
}