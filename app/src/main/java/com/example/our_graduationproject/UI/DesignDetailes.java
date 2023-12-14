package com.example.our_graduationproject.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.our_graduationproject.Helpers.ImageItem;
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.Details.Form;
import com.example.our_graduationproject.UI.GET_POST.GetDetailes;
import com.example.our_graduationproject.UI.GET_POST.OnItemReceivedListner;
import com.squareup.picasso.Picasso;

import java.util.function.IntBinaryOperator;

public class DesignDetailes extends AppCompatActivity  implements OnItemReceivedListner {
ImageView imageView;
ImageButton favBtn;
    ImageItem item;
    TextView likeCountTextView ;

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.design_detailes);





  item = (ImageItem) getIntent().getSerializableExtra("item");

        imageView = findViewById(R.id.favImageView);
        //Picasso.get().load(item.getImage()).into(imageView);
imageView.setImageResource(item.getImageInt());


        likeCountTextView =  findViewById(R.id.likeCountTextView);

        //likeCountTextView.setText(item.getFavStatus());
        favBtn =  findViewById(R.id.favBtn);
        GetDetailes.getData(this,item,this);
        favBtn.setBackgroundResource(item.getFavStatus() ? R.drawable.ic_favorite_red_24dp : R.drawable.ic_favorite_shadow_24dp);

        ImageView i = findViewById(R.id.selected);
        i.setVisibility(item.isSelected() ? View.VISIBLE : View.INVISIBLE);
        if(Order.SIMILAR)
        findViewById(R.id.continue11).setVisibility(View.VISIBLE);

        findViewById(R.id.continue11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findViewById(R.id.selected).setVisibility(View.VISIBLE);
                Order.setScope_id(item.getScopId());


                Order.setPrefernce_value_id(item.getPrefernceValueId());
                Order.setPreferebce_id(item.getPrefernceId());

                Order.setIndustry(item.getScope());
                Order.setPreferebce(item.getPreferece());
                Order.setPrefernce_values(
                        item.getPreferenceValue());

                item.setSelected(true);
                Toast.makeText(DesignDetailes.this, item.getScope(), Toast.LENGTH_SHORT).show();

                Intent i = new Intent(DesignDetailes.this, Form.class) ;

           startActivity(i); }
        });
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(DesignDetailes.this, Form.class) ;
//                i.putExtra("item",item);
//            }
//        });
//        if(Order.SIMILAR) {
//             imageView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//                    if (!item.isSelected()) {
//                         findViewById(R.id.selected).setVisibility(View.VISIBLE);
//                        findViewById(R.id.continue11).setVisibility(View.VISIBLE);
//                        Order.setScope_id(item.getScopId());
//
//
//                        Order.setPrefernce_value_id(item.getPrefernceValueId());
//                        Order.setPreferebce_id(item.getPrefernceId());
//
//                        Order.setIndustry(item.getScope());
//                        Order.setPreferebce(item.getPreferece());
//                        Order.setPrefernce_values(
//                                item.getPreferenceValue());
//
//                        item.setSelected(true);
//                        Toast.makeText(DesignDetailes.this, item.getScope(), Toast.LENGTH_SHORT).show();
//                    } else {
//
//
//                        Order.setScope_id(0);
//                        Order.setIndustry("");
//                        Order.setPrefernce_value_id(0);
//                        Order.setPreferebce_id(0);
//                        Order.setPreferebce("");
//                        Order.setPrefernce_values("");
//
//
//                         findViewById(R.id.selected).setVisibility(View.INVISIBLE);
//                        item.setSelected(false);
//                        findViewById(R.id.continue11).setVisibility(View.GONE);
//
//                    }
//                    return false;
//                }});
//        }

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
                 }
                else  {
                    // set the value of the favorite button to true in shared preferences
                    //sharedPreferences.edit().putBoolean(item.getImage(), true).apply();
                    item.setFavStatus(true);
                    favBtn.setBackgroundResource(R.drawable.ic_favorite_red_24dp);
                    item.setLikes(item.getLikes()+1);
                    likeCountTextView.setText(item.getLikes()+"");
                    Log.d("GallaryAdaptertrue", "Favorite status for " + item.getImage() + " set to true");
                 }
            }
        });     }

    @Override
    public void OnItemReceived(ImageItem imageItem) {
        item=imageItem;
    }
}
























