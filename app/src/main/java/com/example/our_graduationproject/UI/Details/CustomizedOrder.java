package com.example.our_graduationproject.UI.Details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.our_graduationproject.Controller.DesignTypeAdapter;
import com.example.our_graduationproject.Controller.CustomizedAdapter;
import com.example.our_graduationproject.Model.DesignType;
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.Model.Preference;
import com.example.our_graduationproject.R;
 import com.example.our_graduationproject.UI.GET_POST.GET_PREFERENCES;
import com.example.our_graduationproject.UI.GET_POST.OnPreferenceReceivedListener;

import java.util.ArrayList;

public class CustomizedOrder extends AppCompatActivity implements OnPreferenceReceivedListener
        {            ArrayList<DesignType> designTypes = new ArrayList<>();
TextView price ;
         int[] numbers = { R.drawable.facebook,R.drawable.twitter,R.drawable.instagram};

            GridView gridView;
            TextView textView;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_type_order);
price =findViewById(R.id.price);
findViewById(R.id.continue11).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(), Form.class));
    }
});


         gridView = findViewById(R.id.gride);

textView=findViewById(R.id.text1);
textView.setText(Order.getName());


          adapter = new CustomizedAdapter(this, designTypes);

         gridView.setAdapter(adapter);
         GET_PREFERENCES.getData(this,preferences,this);

         gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

             @Override
             public void onItemClick(AdapterView<?> parent, View view,
                                     int position, long id) {
                 Order.setPrice(Order.getPrice()+designTypes.get(position).getPrice());
 Order.setPreferebce_id(position+1);
                 Order.setPreferebce(designTypes.get(position).getType());
System.out.println("sizeDesignType :"+designTypes.size());
Toast.makeText(getApplicationContext(),
                         "Item Clicked: " + position, Toast.LENGTH_SHORT).show();
                 //view.findViewById(R.id.selected).setVisibility(View.VISIBLE);

             }
         });

     }

            public ArrayList<Preference> preferences = new ArrayList<>();
            CustomizedAdapter adapter;
            @Override
            public void onPreferenceReceived(ArrayList<Preference> list) {
                //imageItems.clear();
                preferences.addAll(list);
                System.out.println("sizeeeeeePreferece "+preferences.size());
                for(int i=0 ; i<preferences.size();i++)
                {int price= Integer.parseInt(preferences.get(i).getPrice());
                    System.out.println("mmmmmmm :"+designTypes.size());
                 designTypes.add(new DesignType(preferences.get(i).getImage(),preferences.get(i).getName(),price,preferences.get(i).getId()));
               designTypes.get(i).setImg(numbers[i]);
                }
                adapter.notifyDataSetChanged();




            }

        }












//    public void fill()
//    {
////                 designTypes.add(new DesignType(String.valueOf(R.drawable.logootype1),"writing","50",1));
////                designTypes.add(new DesignType(String.valueOf(R.drawable.logotype2), "writing & drawing","00",2));
////                designTypes.add(new DesignType(String.valueOf(R.drawable.logotype4),"drwaing","99",3));
////                designTypes.add(new DesignType(String.valueOf(R.drawable.image21),"symbol","11",4));
//
//
//
//
//
//    }
//
//













