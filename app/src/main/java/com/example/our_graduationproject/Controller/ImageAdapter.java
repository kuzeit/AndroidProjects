package com.example.our_graduationproject.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

 import com.example.our_graduationproject.Helpers.ImageItem;
import com.example.our_graduationproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private ArrayList<ImageItem> coffeeItems;
    private Context context;

    public ImageAdapter(ArrayList<ImageItem> coffeeItems, Context context) {
        this.coffeeItems = coffeeItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         //create table on first


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_in_gallary,
                parent,false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ImageItem imageItem = coffeeItems.get(position);

         //Picasso.get().load(R.drawable.ic_favorite_red_24dp).into( holder.imageView);
//        Picasso.get()
//                .load(imageItem.getImage())
//                .into( holder.imageView);
        holder.imageView.setImageResource(imageItem.getImageInt());
        holder.likeCountTextView.setText(String.valueOf(imageItem.getLikes()+""));
        holder.favBtn.setBackgroundResource(imageItem.getFavStatus() ? R.drawable.ic_favorite_red_24dp : R.drawable.ic_favorite_shadow_24dp);

        //holder.imageView.setImageResource();
    }



    @Override
    public int getItemCount() {
        return coffeeItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView likeCountTextView;
        ImageButton favBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.favImageView);
            favBtn = itemView.findViewById(R.id.favBtn);
            likeCountTextView = itemView.findViewById(R.id.likeCountTextView);


            // set the background of the favorite button based on the value in shared preferences

            //add to fav btn
            favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    ImageItem item = coffeeItems.get(position);

                    if (item.getFavStatus()) {
                        // set the value of the favorite button to false in shared preferences
                        //sharedPreferences.edit().putBoolean(item.getImage(), false).apply();
                        item.setFavStatus(false);
                        favBtn.setBackgroundResource(R.drawable.ic_favorite_shadow_24dp);
                        item.setLikes(item.getLikes()-1);
                        likeCountTextView.setText(item.getLikes()+"");
                        Log.d("GallaryAdapterfalse", "Favorite status for " + item.getImage() + " set to false");
                        notifyDataSetChanged();
                     }
                    else  {
                        // set the value of the favorite button to true in shared preferences
                        //sharedPreferences.edit().putBoolean(item.getImage(), true).apply();
                        item.setFavStatus(true);
                        favBtn.setBackgroundResource(R.drawable.ic_favorite_red_24dp);
                        item.setLikes(item.getLikes()+1);
                        likeCountTextView.setText(item.getLikes()+"");
                        Log.d("GallaryAdaptertrue", "Favorite status for " + item.getImage() + " set to true");
                        notifyDataSetChanged();
                     }
                }
            });
        }
    }





    // like click
    private void likeClick (ImageItem item, ImageButton favBtn, final TextView textLike) {







    }
}
