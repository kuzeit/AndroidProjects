//package com.example.our_graduationproject.UI;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.graphics.Typeface;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.GridView;
//import android.widget.TextView;
//
//import com.example.our_graduationproject.Controller.FontAdapter;
//import com.example.our_graduationproject.R;
//import com.example.our_graduationproject.UI.ArtBoard.ArtBoard;
//
//
//public class ChooseFont extends AppCompatActivity {
//        private GridView fontGridView;
//        private FontAdapter fontAdapter;
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_choose_font);
//            findViewById(R.id.continue11).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    startActivity(new Intent(getApplicationContext(), ArtBoard.class));
//
//                }
//            });
//
//        fontGridView = (GridView) findViewById(R.id.font_grid_view);
//
//        String[] fontNames = {"apptext.ttf", "bhu.ttf", "poppins_black.ttf"};
//        fontAdapter = new FontAdapter(this, fontNames);
//        fontGridView.setAdapter(fontAdapter);
//
//        fontGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String fontName = fontNames[position];
//                Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/" + fontName);
//                TextView textView = (TextView) findViewById(R.id.font_text_view);
//                textView.setTypeface(typeface);
//            }
//        });
//    }
//}







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
import com.example.our_graduationproject.Controller.FontAdapter;
import com.example.our_graduationproject.Controller.FontAdapter;
import com.example.our_graduationproject.Controller.FontSelection;
import com.example.our_graduationproject.Model.ColorSelection;
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.ArtBoard.ArtBoard;
import com.example.our_graduationproject.UI.GET_POST.GET_COLORS;
import com.example.our_graduationproject.UI.GET_POST.GET_FONTS;

import java.util.ArrayList;

public class ChooseFont extends AppCompatActivity {
    GridView gridView ,gridView2;
    ArrayList<FontSelection> listGallary = new ArrayList<>();
    ArrayList<FontSelection> listGallary2 = new ArrayList<>();

    @SuppressLint({"ResourceAsColor", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_font);

        fillGride();
    }
    public void fillGride()
    {//        String[] fontNames = {"apptext.ttf", "bhu.ttf", "poppins_black.ttf"};

        listGallary.add(new FontSelection(2,String.valueOf(R.drawable.fo1),"apptext.ttf"));
        listGallary.add(new FontSelection(3,String.valueOf(R.drawable.fo2),"apptext1.ttf"));
        listGallary.add(new FontSelection(4,String.valueOf(R.drawable.fo3),"bhu.ttf"));
        listGallary.add(new FontSelection(5,String.valueOf(R.drawable.fo4),"bhu1.ttf"));
        listGallary2.add(new FontSelection(6,String.valueOf(R.drawable.fo5),"poppins_black.ttf"));
        listGallary2.add(new FontSelection(7,String.valueOf(R.drawable.fo6),"poppins_black1.ttf"));







        gridView = findViewById(R.id.gride);
        gridView2 = findViewById(R.id.gride2);

        findViewById(R.id.continue11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     startActivity(new Intent(getApplicationContext(), ArtBoard.class));
            }
        });


        FontAdapter fontAdapter ,fontAdapter2;
        fontAdapter = new FontAdapter(this, listGallary);
        fontAdapter2 = new FontAdapter(this, listGallary2);

        gridView.setAdapter(fontAdapter);
        gridView2.setAdapter(fontAdapter2);

        //GET_FONTS.getData(this,fontAdapter,listGallary);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                FontSelection colorSelection=listGallary.get(position);
                Toast.makeText(getApplicationContext(),
                        "Item Clicked: " + position, Toast.LENGTH_SHORT).show();
                if(!colorSelection.isSelected()) {
                    view.findViewById(R.id.selected).setVisibility(View.VISIBLE);
                    listGallary.get(position).setSelected(true);
                    Order.getFontSelections().add(listGallary.get(position));
                 }
                else {  view.findViewById(R.id.selected).setVisibility(View.INVISIBLE);
                    listGallary.get(position).setSelected(false);
                     Toast.makeText(ChooseFont.this, listGallary.get(position).getFont(), Toast.LENGTH_SHORT).show();
                    Order.getFontSelections().remove(listGallary.get(position));
                }

            }
        });


        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                FontSelection colorSelection=listGallary2.get(position);
                Toast.makeText(getApplicationContext(),
                        "Item Clicked: " + position, Toast.LENGTH_SHORT).show();
                if(!colorSelection.isSelected()) {
                    view.findViewById(R.id.selected).setVisibility(View.VISIBLE);
                    listGallary.get(position).setSelected(true);
                    Order.getFontSelections().add(listGallary2.get(position));
                }
                else {  view.findViewById(R.id.selected).setVisibility(View.INVISIBLE);
                    listGallary.get(position).setSelected(false);
                    Toast.makeText(ChooseFont.this, listGallary2.get(position).getFont(), Toast.LENGTH_SHORT).show();
                    Order.getFontSelections().remove(listGallary2.get(position));
                }

            }
        });





    }


}

