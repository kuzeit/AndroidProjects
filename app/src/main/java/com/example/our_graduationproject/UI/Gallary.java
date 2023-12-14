package com.example.our_graduationproject.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.our_graduationproject.Controller.ImageAdapter;
import com.example.our_graduationproject.Helpers.ImageItem;
import com.example.our_graduationproject.Model.Order.S_____FillIImagesGallary;
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.Model.Preference;
import com.example.our_graduationproject.Model.USERR;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.Details.showSimilarOrders;
import com.example.our_graduationproject.UI.GET_POST.GetGallaryDesignes;
import com.example.our_graduationproject.UI.GET_POST.OnDataReceivedListener;
import com.example.our_graduationproject.UI.GET_POST.OnPreferenceReceivedListener;

import java.util.ArrayList;

public class Gallary extends AppCompatActivity implements OnDataReceivedListener {
    private ImageAdapter gallaryAdapter1, gallaryAdapter2, gallaryAdapter3, gallaryAdapter4;
    private ArrayList<ImageItem> listGallary1 = new ArrayList<>();
    private ArrayList<ImageItem> listGallary2 = new ArrayList<>();
    private ArrayList<ImageItem> listGallary3 = new ArrayList<>();
    private ArrayList<ImageItem> listGallary4 = new ArrayList<>();
    private Order order;
    private int type = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);
         initRecyclerView(findViewById(R.id.recyclerview_cAdvertising), listGallary1, R.id.img, "1");
        initRecyclerView(findViewById(R.id.recyclerview_c), listGallary2, R.id.img2, "2");
        initRecyclerView(findViewById(R.id.recyclerview_cCovers), listGallary3, R.id.img3, "3");
        initRecyclerView(findViewById(R.id.recyclerview_cDrawing), listGallary4, R.id.img4, "4");
    }

    private void initRecyclerView(RecyclerView recyclerView, ArrayList<ImageItem> listGallary, int imgId, String data) {
        ImageView image = findViewById(imgId);

        // Set the click listener for the image
        image.setOnClickListener(v -> {
            if (imgId == R.id.img) {
                type = 1;
            } else if (imgId == R.id.img2) {
                type = 2;
            } else if (imgId == R.id.img3) {
                type = 3;
            } else if (imgId == R.id.img4) {
                type = 4;
            }

            order = new Order(type);
            Intent intent = new Intent(getApplicationContext(), showSimilarOrders.class);
            startActivity(intent);
        });

        // Set up the RecyclerView
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(
                Gallary.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);

        // Create the adapter for the RecyclerView
        ImageAdapter gallaryAdapter = new ImageAdapter(listGallary, this);

        recyclerView.setAdapter(gallaryAdapter);
        loadData(listGallary, gallaryAdapter, data,0,0,0);
    }

    private void loadData(ArrayList<ImageItem> listGallary, ImageAdapter gallaryAdapter, String data , int scope_id , int preference_id ,int preference_value_id) {
        GetGallaryDesignes.getData(Gallary.this, new OnDataReceivedListener() {
            @Override
            public void onDataReceived(ArrayList<ImageItem> list) {
                listGallary.clear();
                listGallary.addAll(list);

                // Set the data in the adapter when it is received
                gallaryAdapter.notifyDataSetChanged();
            }
        }, null, Integer.parseInt(data),scope_id,preference_id,preference_value_id);
    }

    @Override
    public void onDataReceived(ArrayList<ImageItem> list) {
        // This method is not used anymore
    }
}