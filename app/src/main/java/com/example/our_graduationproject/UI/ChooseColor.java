//package com.example.our_graduationproject.UI;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.GridView;
//import android.widget.Toast;
//
//import com.example.our_graduationproject.Controller.ColorAdapter;
//import com.example.our_graduationproject.Model.ColorSelection;
//import com.example.our_graduationproject.Model.Order.Order;
//import com.example.our_graduationproject.Model.Order.S____DesignName;
//import com.example.our_graduationproject.R;
//import com.example.our_graduationproject.UI.ArtBoard.ArtBoard;
//import com.example.our_graduationproject.UI.GET_POST.GET_COLORS;
//
//import java.util.ArrayList;
//
//public class ChooseColor extends AppCompatActivity {
//    GridView gridView  ,gridView2 ;
//    ArrayList<ColorSelection> listGallary = new ArrayList<>();
//    ArrayList<ColorSelection> listGallary2= new ArrayList<>();
//
//    @SuppressLint({"ResourceAsColor", "MissingInflatedId"})
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_choose_color);
//
//        fillGride();
//    }
//    public void fillGride()
//    {
//        listGallary2.add(new ColorSelection(R.color.black));
//        listGallary2.add(new ColorSelection(R.color.red5));
//        listGallary2.add(new ColorSelection(R.color.yellow5));
//        listGallary2.add(new ColorSelection(R.color.purple_700));
////        listGallary.add(new ColorSelection(R.color.color6));
////        listGallary.add(new ColorSelection(R.color.blue1));
////        listGallary.add(new ColorSelection(R.color.purple_500));
////        listGallary.add(new ColorSelection(R.color.red));
////        listGallary.add(new ColorSelection(R.color.red5));
////        listGallary.add(new ColorSelection(R.color.teal_700));
////
////        listGallary.add(new ColorSelection(com.google.android.material.R.color.design_default_color_background));
////        listGallary.add(new ColorSelection(androidx.cardview.R.color.cardview_shadow_start_color));
////        listGallary.add(new ColorSelection(R.color.white0));
////        listGallary.add(new ColorSelection(R.color.teal_700));
////
////        listGallary.add(new ColorSelection(R.color.green1));
////        listGallary.add(new ColorSelection(R.color.green2));
////        listGallary.add(new ColorSelection(R.color.blue5));
////        listGallary.add(new ColorSelection(R.color.yellow3));
////        listGallary.add(new ColorSelection(R.color.yellow));
////        listGallary.add(new ColorSelection(R.color.white));
//
//
//        listGallary.add(new ColorSelection(R.color.black));
//        listGallary.add(new ColorSelection(R.color.red5));
//        listGallary.add(new ColorSelection(R.color.yellow5));
//        listGallary.add(new ColorSelection(R.color.purple_700));
//        listGallary.add(new ColorSelection(R.color.color6));
//        listGallary.add(new ColorSelection(R.color.blue1));
//        listGallary.add(new ColorSelection(R.color.purple_500));
//        listGallary.add(new ColorSelection(R.color.red));
//        listGallary.add(new ColorSelection(R.color.red5));
//        listGallary.add(new ColorSelection(R.color.teal_700));
//
//         listGallary.add(new ColorSelection(R.color.white0));
//        listGallary.add(new ColorSelection(R.color.teal_700));
//
//
//
//
//        gridView = findViewById(R.id.gride);
//        gridView2 = findViewById(R.id.gride2);
//
//findViewById(R.id.continue11).setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        if(Order.getName().equals(S____DesignName.LOGO))
//            startActivity(new Intent(getApplicationContext(), ChooseFont.class));
//else
//        startActivity(new Intent(getApplicationContext(), ArtBoard.class));
//    }
//});
//
//
//        ColorAdapter colorAdapter;
//        ColorAdapter colorAdapter1;
//        colorAdapter = new ColorAdapter(this, listGallary);
//        colorAdapter1 = new ColorAdapter(this, listGallary2);
//
//        gridView.setAdapter(colorAdapter);
//        gridView2.setAdapter(colorAdapter1);
//      //////////////////GET_COLORS.getData(this,colorAdapter,listGallary);
//
//        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                ColorSelection colorSelection=listGallary.get(position);
//                Toast.makeText(getApplicationContext(),
//                        "Item Clicked: " + position, Toast.LENGTH_SHORT).show();
//                if(!colorSelection.isSelected()) {
//                    view.findViewById(R.id.selected).setVisibility(View.VISIBLE);
//                    listGallary2.get(position).setSelected(true);
//
//                    Order.getSelectedColors().add(listGallary.get(position));
//                }
//                else {  view.findViewById(R.id.selected).setVisibility(View.INVISIBLE);
//                    listGallary.get(position).setSelected(false);
//                    Order.getSelectedColors().remove(listGallary.get(position));
//                }
//
//            }
//        });
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                ColorSelection colorSelection=listGallary.get(position);
//                Toast.makeText(getApplicationContext(),
//                        "Item Clicked: " + position, Toast.LENGTH_SHORT).show();
//                if(!colorSelection.isSelected()) {
//                    view.findViewById(R.id.selected).setVisibility(View.VISIBLE);
//                    listGallary.get(position).setSelected(true);
//
//                    Order.getSelectedColors().add(listGallary.get(position));
//                }
//                else {  view.findViewById(R.id.selected).setVisibility(View.INVISIBLE);
//                    listGallary.get(position).setSelected(false);
//                    Order.getSelectedColors().remove(listGallary.get(position));
//                }
//
//            }
//        });
//    }
//
//
//}
//
package com.example.our_graduationproject.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.our_graduationproject.Controller.ColorAdapter;
import com.example.our_graduationproject.Model.ColorSelection;
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.ArtBoard.ArtBoard;

import java.util.ArrayList;

public class ChooseColor extends AppCompatActivity {
    GridView gridView ,gridView2;
    ColorAdapter colorAdapter1;

    @SuppressLint({"ResourceAsColor", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_color);

        fillGride();
    }
    public void fillGride()

    {        ArrayList<ColorSelection> listGallary = new ArrayList<>();
        ArrayList<ColorSelection> listGallary1 = new ArrayList<>();
        listGallary.add(new ColorSelection(R.color.black));
        listGallary.add(new ColorSelection(R.color.red5));
        listGallary.add(new ColorSelection(R.color.yellow5));
         listGallary.add(new ColorSelection(R.color.purple_500));
        listGallary.add(new ColorSelection(R.color.red));
        listGallary.add(new ColorSelection(R.color.red5));
        listGallary.add(new ColorSelection(R.color.teal_700));
         //listGallary1.add(new ColorSelection(R.color.purple_500));
        listGallary1.add(new ColorSelection(R.color.red));
//        listGallary1.add(new ColorSelection(R.color.red5));
//        listGallary1.add(new ColorSelection(R.color.teal_700));




        listGallary.add(new ColorSelection(com.google.android.material.R.color.design_default_color_background));
        listGallary.add(new ColorSelection(androidx.cardview.R.color.cardview_shadow_start_color));
        listGallary.add(new ColorSelection(R.color.white0));
        listGallary.add(new ColorSelection(R.color.teal_700));

        listGallary.add(new ColorSelection(R.color.green1));
        listGallary.add(new ColorSelection(R.color.green2));
        listGallary.add(new ColorSelection(R.color.blue5));
        listGallary.add(new ColorSelection(R.color.yellow3));
        listGallary.add(new ColorSelection(R.color.yellow));
        listGallary.add(new ColorSelection(R.color.white));






        gridView = findViewById(R.id.gride);
        gridView2 = findViewById(R.id.gride2);

        findViewById(R.id.continue11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ChooseFont.class));
            }
        });


        ColorAdapter colorAdapter;
        colorAdapter = new ColorAdapter(this, listGallary);
        colorAdapter1 = new ColorAdapter(this, listGallary1);

        gridView.setAdapter(colorAdapter);
        gridView2.setAdapter(colorAdapter1);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                ColorSelection colorSelection=listGallary.get(position);
                Toast.makeText(getApplicationContext(),
                        "Item Clicked: " + position, Toast.LENGTH_SHORT).show();
                if(!colorSelection.isSelected()) {
                    view.findViewById(R.id.selected).setVisibility(View.VISIBLE);
                    listGallary.get(position).setSelected(true);

                    Order.getSelectedColors().add(listGallary.get(position));
                }
                else {  view.findViewById(R.id.selected).setVisibility(View.INVISIBLE);
                    listGallary.get(position).setSelected(false);
                    Order.getSelectedColors().remove(listGallary.get(position));
                }

            }
        });

        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                ColorSelection colorSelection=listGallary.get(position);
                Toast.makeText(getApplicationContext(),
                        "Item Clicked: " + position, Toast.LENGTH_SHORT).show();
                if(!colorSelection.isSelected()) {
                    view.findViewById(R.id.selected).setVisibility(View.VISIBLE);
                    listGallary1.get(position).setSelected(true);

                    Order.getSelectedColors().add(listGallary1.get(position));
                }
                else {  view.findViewById(R.id.selected).setVisibility(View.INVISIBLE);
                    listGallary.get(position).setSelected(false);
                    Order.getSelectedColors().remove(listGallary1.get(position));
                }

            }
        });


}}

