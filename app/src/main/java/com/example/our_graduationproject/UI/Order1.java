package com.example.our_graduationproject.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.our_graduationproject.Controller.FinalOrderAdapter;
import com.example.our_graduationproject.Controller.SessionManager;
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.Model.Order.Order_;
import com.example.our_graduationproject.Model.USERR;
import com.example.our_graduationproject.Model.User;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.GET_POST.GetDesigners;
import com.example.our_graduationproject.UI.GET_POST.GetOrders;
import com.example.our_graduationproject.UI.GET_POST.OnUserReceivedListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Order1 extends AppCompatActivity implements OnUserReceivedListener {
    private FloatingActionButton fab;
    TextView textView;
List<Order_> orderS = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        textView = findViewById(R.id.text1);
       // textView.setText("Hi "+ SessionManager.getInstance(Order1.this).getToken().getName());
        BottomNavigationView navBar = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
 findViewById(R.id.chat).setVisibility(View.GONE);//setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        startActivity( new Intent(getApplicationContext() ,chatwindo.class));
//    }
//});
    fab= findViewById(R.id.fab) ;
    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            OnCreateOrder();
        }
    });// Initialize and assign variable

        // Set Home selected
        navBar.setSelectedItemId(R.id.placeholder);

        // Perform item selected listener
        navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.gallary:
                        Order.SIMILAR=false;
                        startActivity(new Intent(getApplicationContext(),Gallary.class));
                        overridePendingTransition(0,0);
                         return true;
                    case R.id.profille_1:

                        startActivity(new Intent(getApplicationContext(),profile.class));
                         overridePendingTransition(0,0);



                }
                return false;
            }
        });










        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        orderS= Order.orderS;
        FinalOrderAdapter adapter = new FinalOrderAdapter(Order1.this,orderS);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        GetOrders.getData(this,adapter,orderS);
adapter.notifyDataSetChanged();

















    }

    public void OnCreateOrder()
    {            AlertDialog.Builder builder = new AlertDialog.Builder(Order1.this);

        String[] options = {"similar Order", "customized Order"};
         builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        Order.SIMILAR=true;
                        break;
                    case 1:
                        Order.SIMILAR=false;
                        break;

                }
                startActivity( new Intent(getApplicationContext() ,Order_2.class));

            }
        });
// create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().setLayout(600, 400);
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "yyyy", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void OnUserReceived(User user) {
         USERR.user= new User();
        USERR.user=user;
    }
}
