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

public class SocialOrder_ extends Order_ {
    public SocialOrder_() {
        typeOrder= String.valueOf(3);
        price=100;
        name= S____DesignName.SOCIAL;
    }}


//    @Override
//    public void initSpinners(CustomSpinner spinner1, CustomSpinner spinner2) {
//        super.initSpinners(spinner1, spinner2);
//
//        spinner1.setVisibility(View.VISIBLE);
//
//              list1= Arrays.asList(S_____SpinnersArray.TYPE_SOCIAL);
//            spinnrer(spinner1, S_____SpinnersArray.TYPE_SOCIAL);
//             textView.setText(S____DesignName.SOCIAL);
//            intent = new Intent(this.context, SocialDetails.class);
//
//        }
//
//
//
//    public ArrayList<ImageItem> getImages(GridView gridView1)
//    {  gridView = gridView1;
//        this.listGallary= S_____FillIImagesGallary.AllSocial();
//
//        gallaryAdapter = new GallaryAdapter(context, listGallary);
//
//        gridView.setAdapter(gallaryAdapter);
//
//        return  listGallary;
//    }
//
//    @Override
//    public void OnClick(View view, int position) {
//        super.OnClick(view,position);
//
//            if (position==1)
//            {this.listGallary= S_____FillIImagesGallary.AllLFacebook();}
//            if (position==2)
//            {this.listGallary= S_____FillIImagesGallary.AllLtwitter();}
//            if (position==0)
//            {this.listGallary= S_____FillIImagesGallary.AllSocial();}
//
//
//            gallaryAdapter = new GallaryAdapter(context, listGallary);
//
//            gridView.setAdapter(gallaryAdapter);
//
//            gallaryAdapter.notifyDataSetChanged();
//
//
//           }

//    @Override
//    public void OnClick(AdapterView<?> parent, View view, int position, long id) {
//        super.OnClick(parent, view, position, id);
//
//}}
