//package com.example.our_graduationproject.UI.Details;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.GridView;
//import android.widget.Spinner;
//import android.widget.SpinnerAdapter;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.our_graduationproject.Controller.GallaryAdapter;
//import com.example.our_graduationproject.Controller.SessionManager;
//import com.example.our_graduationproject.Controller.StringAdapter;
//import com.example.our_graduationproject.CustomSpinner.CustomSpinner;
//import com.example.our_graduationproject.Helpers.ImageItem;
//import com.example.our_graduationproject.Model.Order.Order;
//import com.example.our_graduationproject.Model.Preference;
//import com.example.our_graduationproject.Model.Scope1;
//import com.example.our_graduationproject.R;
//import com.example.our_graduationproject.UI.DesignDetailes;
//import com.example.our_graduationproject.UI.GET_POST.GET_PREFERENCES;
//import com.example.our_graduationproject.UI.GET_POST.GetGallaryDesignes;
//import com.example.our_graduationproject.UI.GET_POST.GetScopes;
//import com.example.our_graduationproject.UI.GET_POST.Get_Values;
//import com.example.our_graduationproject.UI.GET_POST.OnDataReceivedListener;
//import com.example.our_graduationproject.UI.GET_POST.OnPreferenceReceivedListener;
//import com.example.our_graduationproject.UI.GET_POST.OnScopeReceivedListner;
//import com.example.our_graduationproject.UI.GET_POST.OnValueReceivedListner;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Map;
//
//public class showSimilarOrders extends AppCompatActivity
//  implements CustomSpinner.OnSpinnerEventsListener ,
//        AdapterView.OnItemSelectedListener ,
//        OnScopeReceivedListner,StringAdapter.ItemClickListener, OnDataReceivedListener ,
//        OnPreferenceReceivedListener
//
//
//
//{
//     TextView textView;
//TextView price ;
//
//    CustomSpinner spinner1  , spinner2  ;
//    GridView gridView;
//GallaryAdapter gallaryAdapter;
//    StringAdapter adapter;
//    Intent intent ;
//public String token ;
//public ArrayList<String > typess = new ArrayList<>();
//int scope_id =0,preference_id =0,preference_value_id=0 , type_id =0;
//    String[] preferenceValueNames;
//    String[] scopesNames;
//    ArrayList<Scope1> scope1s = new ArrayList<>();
//
//    public ArrayList<Preference> preferences = new ArrayList<>();
//
//     @SuppressLint("SuspiciousIndentation")
//    protected void onCreate(Bundle savedInstanceState) {
//              token = SessionManager.getInstance(this).getToken().getToken();
//
//        super.onCreate(savedInstanceState);
//
//         setContentView(R.layout.activity_show_similar_orders);
//type_id= Integer.parseInt(Order.getTypeOrder());
//price=findViewById(R.id.price);
//
//
//        spinner2 = findViewById(R.id.color_spinner);
//        spinner1= findViewById(R.id.type_spinner);
//           textView = findViewById(R.id.text1);
//
//         fillHorizntalList();
//         Order.order.context=showSimilarOrders.this;
//             Order.order.textView=textView;
//        intent=new Intent(showSimilarOrders.this,Form.class);
//
//         gridView = findViewById(R.id.gride);
//
//          gallaryAdapter = new GallaryAdapter(this, imageItems);
//          gridView.setAdapter(gallaryAdapter);
//
//         GetGallaryDesignes.getData(this,this, gallaryAdapter,
//                type_id,scope_id,preference_id,preference_value_id);
//
//
//         gridView.setClickable(true);
//
//
//
//
//
//         gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//             @Override
//             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                 onItemClick(parent, view, position, id);
//             }
//
//
//         });
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//  findViewById(R.id.continue11).setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//
//
//
//
//
//
//
//        startActivity(intent);
//    }
//});
//
//
//
//
//
//
//     }
//
//
//    @Override
//    public void onScopesReceived(ArrayList<Scope1> list) {
//         scope1s.addAll(list);
//        scopesNames = new String[scope1s.size()+1];
//        for (int i = 0; i < scope1s.size(); i++) {
//            scopesNames[0]="select scope";
//            scopesNames[i+1] = scope1s.get(i).getName();
//        }
//        spinnrer(spinner2,scopesNames);
// for (int i=0;i<this.imageItems.size();i++)
//     imageItems.get(i).setScope(scopesNames[imageItems.get(i).getScopId()]);
//
//System.out.println("scopess"+scope1s.size());
//
//
//
//
//
//    }
//
//
//
//
//
//
//
//     @Override
//    public void onPopupWindowOpened(Spinner spinner) {
//        spinner.setBackground(getResources().getDrawable(R.drawable.spinner_up));
//
//    }
//
//    @Override
//    public void onPopupWindowClosed(Spinner spinner) {
//        spinner.setBackground(getResources().getDrawable(R.drawable.spinner));
//
//    }
//
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//if(parent.getId()==R.id.type_spinner) {
//    Toast.makeText(this, "value : "+position, Toast.LENGTH_SHORT).show();
//    preference_value_id=position;
//
// }
//        if(parent.getId()==R.id.color_spinner) {
//            Toast.makeText(this, "scope : "+position, Toast.LENGTH_SHORT).show();
//scope_id=position;
//          }
//
//        GetGallaryDesignes.getData(this,this, gallaryAdapter,
//                type_id,scope_id,preference_id,preference_value_id);
//
//
//
//    }
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
//
//ArrayList<ImageItem> imageItems = new ArrayList<>();
//
//
//    @Override
//    public void onDataReceived(ArrayList<ImageItem> list) {
//
//
//        imageItems.clear();
//        imageItems.addAll(list);
//        System.out.println("sizeeeeeeeee "+imageItems.size());
//        gallaryAdapter.notifyDataSetChanged();
//
//    }
//
//
//
//    public void fillHorizntalList()
//    {
//
//
//        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//
//        adapter = new StringAdapter(this, typess);
//        adapter.setClickListener(this);
//
//        recyclerView.setAdapter(adapter);
//        adapter.setClickListener(this);
//         GET_PREFERENCES.getData(this,preferences,this);
//
//     }
//
//
//    @Override
//    public void onItemClick(View view, int position) {
//        Preference  preference = preferences.get(position);
//        if(preference.getPrefernce_values().size()>0) {
//
//                preferenceValueNames = new String[preference.getPrefernce_values().size()+1];
//
//                    spinner1.setVisibility(View.VISIBLE);
//                    preferenceValueNames[0] = "select type";
//                    for (int i = 0; i < preference.getPrefernce_values().size(); i++) {
//                        preferenceValueNames[i + 1] = preference.getPrefernce_values().get(i).getName();
//                    }
//
////        for (int i=0;i<this.imageItems.size();i++)
////            imageItems.get(i).setPreferenceValue(preferenceValueNames[imageItems.get(i).getPrefernceValueId()]);
//
//                    spinnrer(spinner1, preferenceValueNames);
//                    preference_id = position + 1;
//             }
//                    GetGallaryDesignes.getData(this, this, gallaryAdapter,
//                            type_id, scope_id, preference_id, preference_value_id);
//
//
//
//            }
//
//
//    public void clickked() {
//        Preference preference = preferences.get(0);
//if(preference.getPrefernce_values().size()>0)
//        {
//            spinner1.setVisibility(View.VISIBLE);
//
//            preferenceValueNames = new String[preference.getPrefernce_values().size() + 1];
//
//            preferenceValueNames[0] = "select type";
//
//            for (int i = 0; i < preference.getPrefernce_values().size(); i++) {
//                preferenceValueNames[i + 1] = preference.getPrefernce_values().get(i).getName();
//            }
//
//            for (int i = 0; i < this.imageItems.size(); i++)
//                imageItems.get(i).setPreferenceValue(preferenceValueNames[imageItems.get(i).getPrefernceValueId()]);
//
//            spinnrer(spinner1, preferenceValueNames);
//            preference_id = 0 + 1;
//        }
//        GetGallaryDesignes.getData(this, this, gallaryAdapter,
//                type_id, scope_id, preference_id, preference_value_id);
//     }
//    @Override
//    public void onPreferenceReceived(ArrayList<Preference> list) {
//
//        preferences.addAll(list);
//        System.out.println("sizeeeeeePreferece " + preferences.size());
//                 for (int i=0;i<this.imageItems.size();i++)
//            imageItems.get(i).setPreferece(preferences.get(imageItems.get(i).getPrefernceId()-1).getName());
//         GetScopes.getData(this,scope1s,this);
//        for(int i=0 ; i<preferences.size();i++)
//        {
//
//            typess.add(preferences.get(i).getName());}
//        adapter.notifyDataSetChanged();
//        clickked();
//
//    }
//
//    void spinnrer(CustomSpinner spinner1 , String[] array1)
//    {  spinner1.setSpinnerEventsListener(this);
//
//        SpinnerAdapter Ad = new com.example.our_graduationproject.CustomSpinner.SpinnerAdapter(this, Arrays.asList(array1));
//        spinner1.setAdapter(Ad);
//        spinner1.setOnItemSelectedListener(this);
//
//    }
//
//
//
//}
//
//
//
//
//
//
//
//
//
//
package com.example.our_graduationproject.UI.Details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
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
import com.example.our_graduationproject.Model.Preference;
import com.example.our_graduationproject.Model.Scope1;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.DesignDetailes;
import com.example.our_graduationproject.UI.GET_POST.GET_PREFERENCES;
import com.example.our_graduationproject.UI.GET_POST.GetGallaryDesignes;
import com.example.our_graduationproject.UI.GET_POST.GetScopes;
import com.example.our_graduationproject.UI.GET_POST.Get_Values;
import com.example.our_graduationproject.UI.GET_POST.OnDataReceivedListener;
import com.example.our_graduationproject.UI.GET_POST.OnPreferenceReceivedListener;
import com.example.our_graduationproject.UI.GET_POST.OnScopeReceivedListner;
import com.example.our_graduationproject.UI.GET_POST.OnValueReceivedListner;

import java.util.ArrayList;
import java.util.Arrays;

public class showSimilarOrders extends AppCompatActivity
        implements CustomSpinner.OnSpinnerEventsListener ,
        AdapterView.OnItemSelectedListener ,
        OnScopeReceivedListner,StringAdapter.ItemClickListener, OnDataReceivedListener ,
        OnPreferenceReceivedListener



{
    TextView textView;
    TextView price ;

    CustomSpinner spinner1  , spinner2  ;
    GridView gridView;
    GallaryAdapter gallaryAdapter;
    StringAdapter adapter;
    Intent intent ;
    public String token ;
    public ArrayList<String > typess = new ArrayList<>();
    int scope_id =0,preference_id =0,preference_value_id=0 , type_id =0;
    String[] preferenceValueNames;
    String[] scopesNames;
    String[] scopesNames1;

    ArrayList<Scope1> scope1s = new ArrayList<>();
    public ArrayList<Preference> preferences = new ArrayList<>();
    @SuppressLint("SuspiciousIndentation")
    protected void onCreate(Bundle savedInstanceState) {
        token = SessionManager.getInstance(this).getToken().getToken();

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_similar_orders);
        type_id= Integer.parseInt(Order.getTypeOrder());
        price=findViewById(R.id.price);
        scopesNames1= new String[1];
        scopesNames1[0]="select scope";

        spinner2 = findViewById(R.id.color_spinner);
        spinnrer(spinner2,scopesNames1);
        spinner1= findViewById(R.id.type_spinner);
        textView = findViewById(R.id.text1);

        fillHorizntalList();
        Order.order.context=showSimilarOrders.this;
        Order.order.textView=textView;
        intent=new Intent(showSimilarOrders.this,Form.class);

        gridView = findViewById(R.id.gride);

        gallaryAdapter = new GallaryAdapter(this, imageItems);
        gridView.setAdapter(gallaryAdapter);

        GetGallaryDesignes.getData(this,this, gallaryAdapter,
                type_id,scope_id,preference_id,preference_value_id);
        gridView.setClickable(true);





        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onItemClick(parent, view, position, id);
            }


        });














        findViewById(R.id.continue11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {







                startActivity(intent);
            }
        });






    }


    @Override
    public void onScopesReceived(ArrayList<Scope1> list) {

        scope1s.addAll(list);
        scopesNames = new String[scope1s.size()+1];
        for (int i = 0; i < scope1s.size(); i++) {
            scopesNames[0]="select scope";
            scopesNames[i+1] = scope1s.get(i).getName();
        }
        spinnrer(spinner2,scopesNames);
        for (int i=0;i<this.imageItems.size();i++)
            imageItems.get(i).setScope(scopesNames[imageItems.get(i).getScopId()]);

        System.out.println("scopess"+scope1s.size());





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
             preference_value_id=position;

        }
        if(parent.getId()==R.id.color_spinner) {
             scope_id=position;
        }

        GetGallaryDesignes.getData(this,this, gallaryAdapter,
                type_id,scope_id,preference_id,preference_value_id);



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
        GET_PREFERENCES.getData(this,preferences,this);

    }


    @Override
    public void onItemClick(View view, int position) {
        Preference  preference = preferences.get(position);


        preferenceValueNames = new String[preference.getPrefernce_values().size()+1];
        preferenceValueNames[0]="select type";
        for (int i = 0; i < preference.getPrefernce_values().size(); i++) {
            preferenceValueNames[i+1] = preference.getPrefernce_values().get(i).getName();
        }

//        for (int i=0;i<this.imageItems.size();i++)
//            imageItems.get(i).setPreferenceValue(preferenceValueNames[imageItems.get(i).getPrefernceValueId()]);

        spinnrer(spinner1,preferenceValueNames);
        preference_id=position+1;

        GetGallaryDesignes.getData(this,this, gallaryAdapter,
                type_id,scope_id,preference_id,preference_value_id);



    }


    public void clickked() {
        Preference preference = preferences.get(0);

        preferenceValueNames = new String[preference.getPrefernce_values().size() + 1];
        preferenceValueNames[0] = "select type";
        for (int i = 0; i < preference.getPrefernce_values().size(); i++) {
            preferenceValueNames[i + 1] = preference.getPrefernce_values().get(i).getName();
        }

        for (int i = 0; i < this.imageItems.size(); i++)
            imageItems.get(i).setPreferenceValue(preferenceValueNames[imageItems.get(i).getPrefernceValueId()]);

        spinnrer(spinner1, preferenceValueNames);
        preference_id = 0 + 1;

        GetGallaryDesignes.getData(this, this, gallaryAdapter,
                type_id, scope_id, preference_id, preference_value_id);
    }
    @Override
    public void onPreferenceReceived(ArrayList<Preference> list) {
        preferences.addAll(list);
        System.out.println("sizeeeeeePreferece " + preferences.size());
        for (int i=0;i<this.imageItems.size();i++)
            imageItems.get(i).setPreferece(preferences.get(imageItems.get(i).getPrefernceId()-1).getName());
        GetScopes.getData(this,scope1s,this);
        for(int i=0 ; i<preferences.size();i++)
        {

            typess.add(preferences.get(i).getName());}
        adapter.notifyDataSetChanged();
        clickked();

    }

    void spinnrer(CustomSpinner spinner1 , String[] array1)
    {




        if(array1.length>1) {
            spinner1.setSpinnerEventsListener(this);
            spinner1.setVisibility(View.VISIBLE);
SpinnerAdapter Ad = new com.example.our_graduationproject.CustomSpinner.SpinnerAdapter(this, Arrays.asList(array1));
            spinner1.setAdapter(Ad);
            spinner1.setOnItemSelectedListener(this);
        }
    }



}










