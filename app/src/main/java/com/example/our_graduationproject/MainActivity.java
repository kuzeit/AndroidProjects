package com.example.our_graduationproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;

import com.example.our_graduationproject.Controller.SessionManager;
import com.example.our_graduationproject.UI.ArtBoard.ArtBoard;
import com.example.our_graduationproject.UI.ChooseColor;
import com.example.our_graduationproject.UI.ChooseDesigner;
import com.example.our_graduationproject.UI.ChooseFont;
import com.example.our_graduationproject.UI.GET_POST.Data;
import com.example.our_graduationproject.UI.LoginActivity;
import com.example.our_graduationproject.UI.Order1;
import com.example.our_graduationproject.UI.Order_2;

public class MainActivity extends AppCompatActivity {
    public static String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this , ChooseDesigner.class));

        startActivity(new Intent(getApplicationContext(), com.example.our_graduationproject.UI.LoginActivity.class));


        if(SessionManager.getInstance(this).isLoggedIn()){
            if(SessionManager.getInstance(this).getToken() != null){
                token = SessionManager.getInstance(this).getToken().getToken();
                Data.token=token;
                startActivity(new Intent(this , Order1.class));

            }
        }else
        {
            startActivity(new Intent(getApplicationContext(), com.example.our_graduationproject.UI.LoginActivity.class));
        }

    }





}