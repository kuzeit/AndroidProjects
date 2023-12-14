package com.example.our_graduationproject.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.our_graduationproject.Model.ColorSelection;
import com.example.our_graduationproject.R;

import java.util.List;

public class ColorsOrdersAdapter extends RecyclerView.Adapter<ColorsOrdersAdapter.ViewHolder> {

    private List<ColorSelection> mData;
Context context;
    public ColorsOrdersAdapter(Context context1 , List<ColorSelection> data) {
        mData = data;
        context=context1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.color_item22, parent, false);
        return new ViewHolder(view);
    }

     @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ColorSelection item = mData.get(position);
        holder.cell.setBackgroundColor(ContextCompat.getColor(context, item.getColor()));


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout cell ;

        public ViewHolder(View itemView) {
            super(itemView);
            cell=itemView.findViewById(R.id.cell);
        }
    }
}