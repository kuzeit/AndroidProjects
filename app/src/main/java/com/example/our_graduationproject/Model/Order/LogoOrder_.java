package com.example.our_graduationproject.Model.Order;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.our_graduationproject.Controller.GallaryAdapter;
import com.example.our_graduationproject.CustomSpinner.CustomSpinner;
import com.example.our_graduationproject.Helpers.ImageItem;
import com.example.our_graduationproject.R;

import java.util.ArrayList;
import java.util.Arrays;


public class LogoOrder_ extends  Order_{
 public String with_visual ="No";
    public LogoOrder_() {
        price=120;
        typeOrder= String.valueOf(1);

        name= S____DesignName.LOGO;
    }

//    @Override
//    public void initSpinners(CustomSpinner spinner1, CustomSpinner spinner2
//    ) {
//        super.initSpinners(spinner1, spinner2);
//spinner1.setVisibility(View.VISIBLE);
//spinner2.setVisibility(View.VISIBLE);
//
//
//
//            list1= Arrays.asList(S_____SpinnersArray.INTERESTES);
//        list2= Arrays.asList(S_____SpinnersArray.COLORS);
//             spinnrer(spinner1, S_____SpinnersArray.INTERESTES);
//            spinnrer(spinner2, S_____SpinnersArray.COLORS);
//             textView.setText(S____DesignName.LOGO);
//            intent = new Intent(context, LogoDetailes.class);
//
//        }
//
//
//
//
//
//
//
//
//    @Override
//    public void OnClick(AdapterView<?> parent, View view, int position, long id) {
//        super.OnClick(parent, view, position, id);
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
//    }
//
//
//
//
//        public  ArrayList<ImageItem> getImages(GridView gridView1)
//        {  gridView = gridView1;
//            this.listGallary= S_____FillIImagesGallary.AllLogoImages();
//
//            gallaryAdapter = new GallaryAdapter(context, listGallary);
//
//            gridView.setAdapter(gallaryAdapter);
//
//            return  listGallary;
//        }
//
//
//    @Override
//    public void OnClick(View view, int position) {
//        super.OnClick(view, position);
//
//
//         if (position==1)
//        {this.listGallary= S_____FillIImagesGallary.AllLogoImagesDrawing();}
//        if (position==0)
//        {this.listGallary= S_____FillIImagesGallary.AllLogoImages();}
//
//        if (position==2)
//        {this.listGallary= S_____FillIImagesGallary.AllLogoImagesWriting();}
//        if (position==3)
//        {this.listGallary= S_____FillIImagesGallary.AllLogoImagesSymole();}
//
//        gallaryAdapter = new GallaryAdapter(context, listGallary);
//
//        gridView.setAdapter(gallaryAdapter);
//
//        gallaryAdapter.notifyDataSetChanged();
//this.selectSimilarOrder();
//
//
//
//
//
//
//
//    }
//
//



}
