package com.example.our_graduationproject.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import com.example.our_graduationproject.Controller.DesignersAdapter;
import com.example.our_graduationproject.Model.Designer;
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.GET_POST.GetDesigners;
import com.example.our_graduationproject.UI.GET_POST.MyCallback;

import java.util.ArrayList;

public class ChooseDesigner extends AppCompatActivity //implements  DesignersAdapter.ItemClickListener
        {
        DesignersAdapter adapter;
            ArrayList<Designer> designers = new ArrayList<>();




            @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_designer);

                getDesigners();


                findViewById(R.id.continue11).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity( new Intent(ChooseDesigner.this,FullOrder.class));
                    }
                });



        }
        int old_position =-1;


public void getDesigners()
        {                 RecyclerView recyclerView = findViewById(R.id.recyclerview_c);
         LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(
        com.example.our_graduationproject.UI.ChooseDesigner.this,
        LinearLayoutManager.VERTICAL, false);


        recyclerView.setLayoutManager(horizontalLayoutManagaer);

        adapter = new DesignersAdapter(this, designers);
        /////adapter.setClickListener(  this);

        recyclerView.setAdapter(adapter);
//                                         Designer object = new Designer();
//object.setId(1);
//object.setDescription("..");
// object.setProfile(String.valueOf(R.drawable.profil_img));
//
//                            object.setName("sami sami");
//object.setRating(0.7);
//designers.add(object);
            GetDesigners.getData(this,adapter,designers);
adapter.notifyDataSetChanged();

            //GetDesigners.getData(this,adapter,designers);
        }


//            @Override
//            public void onItemClick(View view, int position) {
//                 Toast.makeText(ChooseDesigner.this, " selected "+position, Toast.LENGTH_SHORT).show();
//                Order.setSelectedDesigner(designers.get(position));
//
//            }
        }


