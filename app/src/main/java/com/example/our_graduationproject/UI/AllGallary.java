package com.example.our_graduationproject.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.our_graduationproject.Controller.GallaryAdapter;
import com.example.our_graduationproject.Controller.SessionManager;
import com.example.our_graduationproject.Controller.StringAdapter;
import com.example.our_graduationproject.CustomSpinner.CustomSpinner;
import com.example.our_graduationproject.Helpers.ImageItem;
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.Model.Order.S_____FillIImagesGallary;
import com.example.our_graduationproject.Model.Order.S_____SpinnersArray;
import com.example.our_graduationproject.Model.Preference;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.Details.Form;
import com.example.our_graduationproject.UI.Details.showSimilarOrders;
import com.example.our_graduationproject.UI.GET_POST.GET_PREFERENCES;
import com.example.our_graduationproject.UI.GET_POST.GetGallaryDesignes;
import com.example.our_graduationproject.UI.GET_POST.Get_Values;
import com.example.our_graduationproject.UI.GET_POST.OnDataReceivedListener;
import com.example.our_graduationproject.UI.GET_POST.OnPreferenceReceivedListener;
import com.example.our_graduationproject.UI.GET_POST.OnValueReceivedListner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class AllGallary  extends AppCompatActivity
        implements CustomSpinner.OnSpinnerEventsListener ,
        AdapterView.OnItemSelectedListener , StringAdapter.ItemClickListener, OnPreferenceReceivedListener, OnValueReceivedListner, OnDataReceivedListener
{
    TextView textView;


    CustomSpinner spinner1  , spinner2  ;
    GridView gridView;
    GallaryAdapter gallaryAdapter;
    StringAdapter adapter;
    Intent intent ;
    Button button;
    public String token ;
    public ArrayList<String > typess = new ArrayList<>();
    String[] preferenceValueNames;
    public ArrayList<Preference> preferences = new ArrayList<>();

    @SuppressLint("SuspiciousIndentation")
    protected void onCreate(Bundle savedInstanceState) {
        token = SessionManager.getInstance(this).getToken().getToken();

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_similar_orders);




        spinner2 = findViewById(R.id.color_spinner);
        spinner1= findViewById(R.id.type_spinner);
        textView = findViewById(R.id.text1);
        button=findViewById(R.id.continue11);
        fillHorizntalList();
        Order.order.context=AllGallary.this;
        Order.order.textView=textView;
        intent=new Intent(AllGallary.this,Form.class);

        gridView = findViewById(R.id.gride);

        gallaryAdapter = new GallaryAdapter(this, imageItems);
        gridView.setAdapter(gallaryAdapter);
        ///GetGallaryDesignes.getData(this,this, gallaryAdapter, Integer.parseInt(Order.getTypeOrder()),Order.getScope_id(),Order.getPreferebce_id(),Order.getPrefernce_value_id());







        findViewById(R.id.continue11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });





    }










    @Override
    public void onPopupWindowOpened(Spinner spinner) {
        spinner.setBackground(getResources().getDrawable(R.drawable.spinner_up));

    }

    @Override
    public void onPopupWindowClosed(Spinner spinner) {
        spinner.setBackground(getResources().getDrawable(R.drawable.spinner));

    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId()==R.id.type_spinner) {
            Order.setPrefernce_value_id(position);
            Order.setPrefernce_values(typess.get(position));
            Toast.makeText(this, "prefernceValue"+Order.getPrefernce_values(), Toast.LENGTH_SHORT).show();
            System.out.println("prefernceValue"+Order.getPrefernce_values());
        }




    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    ArrayList<ImageItem> imageItems = new ArrayList<>();


    @Override
    public void onDataReceived(ArrayList<ImageItem> list) {


        imageItems.clear();
        imageItems.addAll(list);
        System.out.println("sizeeeeeeeee "+imageItems.size());
        gallaryAdapter.notifyDataSetChanged();
    }



    public void fillHorizntalList()
    {


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapter = new StringAdapter(this, typess);
        adapter.setClickListener(this);

        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
        //GET_PREFERECES.getData(this,adapter,preferences,typess,this);
        GET_PREFERENCES.getData(this,preferences,this);
    }


    @Override
    public void onItemClick(View view, int position) {
        Preference  preference = preferences.get(position);


        preferenceValueNames = new String[preference.getPrefernce_values().size()];
        for (int i = 0; i < preference.getPrefernce_values().size(); i++) {
            preferenceValueNames[i] = preference.getPrefernce_values().get(i).getName();
        }
        spinnrer(spinner1,preferenceValueNames);
        Order.setPreferebce_id(position);
        Order.setPreferebce(preferenceValueNames[position]);
        Toast.makeText(this, "prefernce"+Order.getPreferebce(), Toast.LENGTH_SHORT).show();
        System.out.println("prefernce"+Order.getPreferebce());

    }



    @Override
    public void onPreferenceReceived(ArrayList<Preference> list) {
        //imageItems.clear();
        preferences.addAll(list);
        for(int i=0 ; i<preferences.size();i++)
        {        Get_Values.getData(this,preferences,preferences.get(i),this);

             }




    }

    void spinnrer(CustomSpinner spinner1 , String[] array1)
    {  spinner1.setSpinnerEventsListener(this);

        SpinnerAdapter Ad = new com.example.our_graduationproject.CustomSpinner.SpinnerAdapter(this, Arrays.asList(array1));
        spinner1.setAdapter(Ad);
        spinner1.setOnItemSelectedListener(this);

    }


    @Override
    public void onValueReceived(ArrayList<Preference> list) {
        preferences=list;
        for(int i=0 ; i<preferences.size();i++)
        {

            typess.add(preferences.get(i).getName());}
        adapter.notifyDataSetChanged();



    }
}











