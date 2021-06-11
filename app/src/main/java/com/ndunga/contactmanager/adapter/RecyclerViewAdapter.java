package com.ndunga.contactmanager.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        //This is where you will inflate the custom row.
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerViewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    //It boost performance  by rendering views in a recycler view, by recycling views as user scrolls up and down.
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
        }
    }
}
