package com.example.our_graduationproject.Controller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.our_graduationproject.Download;
import com.example.our_graduationproject.Model.Order.Order_;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.FullOrder;
import com.example.our_graduationproject.UI.FullOrder2;
import com.example.our_graduationproject.UI.IDD;
import com.example.our_graduationproject.UI.chatwindo;

import java.util.List;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.our_graduationproject.Model.Order.Order_;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.chatwindo;

import java.util.List;

public class FinalOrderAdapter extends RecyclerView.Adapter<FinalOrderAdapter.ViewHolder> {

    private List<Order_> mData;
    Context context;

    public FinalOrderAdapter(Context context1, List<Order_> data) {
        mData = data;
        context = context1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_order_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order_ item = mData.get(position);
        holder.textView.setText(item.getType()+" ");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "Item clicked: " + item.name, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context, FullOrder2.class);
                intent.putExtra("file",mData.get(position));
           context.startActivity(intent);
            }
        });

        holder.chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, chatwindo.class);
                IDD.name=item.getSelectedDesigner().getName();
                context.startActivity(intent);
            }
        });

        holder.detailes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, holder.detailes);
                popupMenu.getMenuInflater().inflate(R.menu.recyclerview_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(context, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView chat;
        ImageView detailes;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.title);
            chat = itemView.findViewById(R.id.chat);
            detailes = itemView.findViewById(R.id.detailes);
        }
    }
}