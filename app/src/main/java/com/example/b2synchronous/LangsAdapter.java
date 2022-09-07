package com.example.b2synchronous;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LangsAdapter extends RecyclerView.Adapter<LangsAdapter.LViewHolder> {
    @NonNull
    @Override
    public LViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull LViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class LViewHolder extends RecyclerView.ViewHolder {
        public LViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
