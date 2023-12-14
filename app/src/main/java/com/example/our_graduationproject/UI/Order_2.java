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
import com.example.our_graduationproject.Controller.SessionManager;
import com.example.our_graduationproject.Model.DesignType;
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.Details.CustomizedOrder;
import com.example.our_graduationproject.UI.Details.showSimilarOrders;
import com.example.our_graduationproject.UI.GET_POST.GetDesignTypes;

import java.util.ArrayList;

public class Order_2   extends AppCompatActivity

implements  DesignTypeAdapter.ItemClickListener        {
    String token;

            ArrayList<DesignType> desigTypes = new ArrayList<>();
Order order;
            DesignTypeAdapter adapter;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                token = SessionManager.getInstance(this).getToken().getToken();
System.out.println("tokennn "+token);
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_order3);

                 filllRecycler();











            }
            @Override
            public void onItemClick(View view, int position) {
                Context context=view.getContext();
                DesignType designType = desigTypes.get(position) ;
                Intent intent=null;
                 if(!Order.SIMILAR)
                 {
                                          intent = new Intent(context, CustomizedOrder.class);

                 }
                else
                    intent = new Intent(context, showSimilarOrders.class);
                order= new Order(position+1);
                 order.setSlug(designType.getSlug());
                 order.setPrice(designType.getPrice());
                TextView price=findViewById(R.id.price);
                price.setText("price"+Order.order.price);



                startActivity(intent);
            }





























    public void filllRecycler()
         {                 RecyclerView recyclerView = findViewById(R.id.recyclerview_c);
              LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(
                     com.example.our_graduationproject.UI.Order_2.this,
                     LinearLayoutManager.VERTICAL, false);


             recyclerView.setLayoutManager(horizontalLayoutManagaer);

             adapter = new DesignTypeAdapter(this, desigTypes);
             adapter.setClickListener(  this);

             recyclerView.setAdapter(adapter);
             GetDesignTypes.getData(this,adapter,desigTypes);


         }






































        }


