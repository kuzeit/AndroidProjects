package com.example.our_graduationproject.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

 import com.example.our_graduationproject.Helpers.ImageItem;
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.Model.Preference;
import com.example.our_graduationproject.Model.Scope1;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.DesignDetailes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class GallaryAdapter extends ArrayAdapter<ImageItem> {
    ImageView imageView;
    TextView likeCountTextView;
    ImageButton favBtn;
    List<ImageItem> imageItems;
    private Context context;
    private SharedPreferences sharedPreferences;

    public GallaryAdapter(@NonNull Context context, List<ImageItem> courseModelArrayList ) {
        super(context, 0, courseModelArrayList);
        imageItems = courseModelArrayList;
        this.context = context;
        sharedPreferences = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.image_in_gallary, parent, false);
        }

        ImageItem item = getItem(position);

        imageView = listitemView.findViewById(R.id.favImageView);
//        if(item.getImage()!=null&&!item.getImage().isEmpty()) {
//            Picasso.get().load(item.getImage()).into(imageView);
//        }
        //else
           imageView.setImageResource(item.getImageInt());

        likeCountTextView = listitemView.findViewById(R.id.likeCountTextView);
        //item.setFavStatus(false);

        likeCountTextView.setText(String.valueOf(item.getLikes()+""));
        favBtn = listitemView.findViewById(R.id.favBtn);

        // set the background of the favorite button based on the value in shared preferences
        favBtn.setBackgroundResource(item.getFavStatus() ? R.drawable.ic_favorite_red_24dp : R.drawable.ic_favorite_shadow_24dp);

        ImageView i = listitemView.findViewById(R.id.selected);
        i.setVisibility(item.isSelected() ? View.VISIBLE : View.INVISIBLE);
//
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, DesignDetailes.class);
                Order.order.item_id=item.getKey_id();
                i.putExtra("item", item);
                context.startActivity(i);
            }
        });



        favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (item.getFavStatus()) {
                    // set the value of the favorite button to false in shared preferences
                    //sharedPreferences.edit().putBoolean(item.getImage(), false).apply();
                    item.setFavStatus(false);
                    favBtn.setBackgroundResource(R.drawable.ic_favorite_shadow_24dp);
                    item.setLikes(item.getLikes()-1);
                    likeCountTextView.setText(item.getLikes()+"");
                    Log.d("GallaryAdapterfalse", "Favorite status for " + item.getImage() + " set to false");
                    notifyDataSetChanged();
                    notifyDataSetInvalidated();
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
                    notifyDataSetInvalidated();
                }

                Log.d("GallaryAdapter", "item.getFavStatus() = " + item.getFavStatus());
//                notifyDataSetChanged();
//                notifyDataSetInvalidated();
            }
        });
        Log.d("GallaryAdapter111", "Favorite status  " + item.getFavStatus() + " set to 0");

        return listitemView;
    }








}

