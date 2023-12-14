package com.example.our_graduationproject.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.our_graduationproject.Controller.DesignTypeAdapter;
import com.example.our_graduationproject.Model.DesignType;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.Details.showSimilarOrders;

import java.util.ArrayList;

public class firstt extends AppCompatActivity
        implements  DesignTypeAdapter.ItemClickListener
{
DesignTypeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstt);
        String hh= String.valueOf(1);

        ArrayList<DesignType> desigType = new ArrayList<>();
       desigType.add(new DesignType(String.valueOf(R.drawable.first_2),"Advertising and social media",0,1));
        desigType.add(new DesignType(String.valueOf(R.drawable.first_1),"Logo and visual identity",18,2));
        desigType.add(new DesignType(String.valueOf(R.drawable.first_3),"Covers of books and magazines",5,3));
        desigType.add(new DesignType(String.valueOf(R.drawable.first_4),"Drawing of products and packages",8,4));
        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(
                firstt.this, LinearLayoutManager.VERTICAL, false);

        TextView textView = findViewById(R.id.text1);

textView.setText("HELLO Tahani \nYou can view the gallery of the company's work by looking at the existing types"
);

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerview_c);


        // set up the RecyclerView

        recyclerView.setLayoutManager(horizontalLayoutManagaer);

        adapter = new DesignTypeAdapter(this, desigType);
        adapter.setClickListener(  this);
 //adapter.setClickListener( );

        recyclerView.setAdapter(adapter);
     }
    @Override
    public void onItemClick(View view, int position) {
        Context context=view.getContext();
        Intent intent=null;

                        intent= new Intent(context, showSimilarOrders.class);

                     startActivity(intent);
    }
}


