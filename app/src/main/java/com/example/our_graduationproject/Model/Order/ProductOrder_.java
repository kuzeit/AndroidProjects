package com.example.our_graduationproject.Model.Order;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.our_graduationproject.Controller.GallaryAdapter;
import com.example.our_graduationproject.CustomSpinner.CustomSpinner;
import com.example.our_graduationproject.Helpers.ImageItem;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductOrder_ extends  Order_{
    public   String pageNumber ;
    public   String size ;
    public String sizeId ;

    public ProductOrder_() {
        name= S____DesignName.PRODUCTS;
        typeOrder= String.valueOf(4);

    }}

//    @Override
//    public void initSpinners(CustomSpinner spinner1, CustomSpinner spinner2) {
//        super.initSpinners(spinner1, spinner2);
//        spinner1.setVisibility(View.VISIBLE);
//
//
//
//
//            list1= Arrays.asList(S_____SpinnersArray.TYPE_PRODUCT);
//            spinnrer(spinner1, S_____SpinnersArray.TYPE_PRODUCT);
//            textView.setText(S____DesignName.PRODUCTS);
//            intent = new Intent(context, ProdctDetailes.class);
//
//        }
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
//    }
//
//
//    public ArrayList<ImageItem> getImages(GridView gridView1)
//    {  gridView = gridView1;
//        this.listGallary= S_____FillIImagesGallary.All_Product();
//
//        gallaryAdapter = new GallaryAdapter(context, listGallary);
//
//        gridView.setAdapter(gallaryAdapter);
//
//        return  listGallary;
//    }
//
//
//
//
//
//}
//    void fillProduct2( )
//    {
//
//
//
//        colorSpinner.setVisibility(View.INVISIBLE);
//        interestSpinner.setVisibility(View.INVISIBLE);
//        List<Preference> pp= GET_PREFERECES.getData(getApplicationContext(),token);
//        String[] array = new String[pp.size()];
//        for (int i = 0; i < pp.size(); i++)
//            array[i] = (String) pp.get(i).getName();
//
//
//        spinnrer(typeSpinner, array);
//        textView.setText(DesignTypeString.PRODUCTS);
//        intent = new Intent(showSimilarOrders.this, ProdctDetailes.class);
//
//    }
//