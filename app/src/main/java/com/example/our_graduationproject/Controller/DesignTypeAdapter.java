package com.example.our_graduationproject.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.our_graduationproject.Model.DesignType;
import com.example.our_graduationproject.R;

import java.util.ArrayList;

public class DesignTypeAdapter extends RecyclerView.Adapter<DesignTypeAdapter.ViewHolder>
       {
    private ItemClickListener mClickListener;

        Context context;
        ArrayList<DesignType> arrayList = new ArrayList<>();

        public DesignTypeAdapter(Context context, ArrayList<DesignType> arrayList) {
            this.context = context;
            this.arrayList = arrayList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.card_, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
DesignType designType= (DesignType) arrayList.get(position);

            holder.title.setText(designType.getType());
           //holder.imageView.setImageResource(designType.getImage());
//            Picasso.get()
//                    .load(designType.getImage())
//
//                    .into(holder.imageView );

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }




           public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
            TextView title;
ImageView imageView;
            public ViewHolder(View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.type);
                //imageView=itemView.findViewById(R.id.image1);
                itemView.setOnClickListener(this);
   }
               @Override
               public void onClick(View view) {
                   if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
               }
           }


           public void setClickListener(ItemClickListener itemClickListener) {
               this.mClickListener = itemClickListener;
           }


           public interface ItemClickListener {
               void onItemClick(View view, int position);
           }}


