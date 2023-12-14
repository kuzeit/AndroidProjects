package com.example.our_graduationproject.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.our_graduationproject.Model.Designer;
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.R;

import java.util.ArrayList;
import java.util.List;

public class StringAdapter extends RecyclerView.Adapter<StringAdapter.ViewHolder>
{
    private ItemClickListener mClickListener;

    Context context;
    List<String> arrayList = new ArrayList<>();

    public StringAdapter(Context context, List<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.text, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public   void   onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String string=arrayList.get(position);

        holder.text.setText(string);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    int oldPosition =-1;

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        TextView text;

        public ViewHolder(View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.title);
             itemView.setOnClickListener(this);
        }
        @SuppressLint("SuspiciousIndentation")
        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());

        }
    }


    public void setClickListener(StringAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }


    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }}


