package com.example.our_graduationproject.UI.GET_POST;

import com.example.our_graduationproject.Model.DesignType;
import com.example.our_graduationproject.Model.Designer;

import java.util.ArrayList;

public interface MyCallback {
    void onListReady(ArrayList<DesignType> designTypes);

}