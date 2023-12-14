package com.example.our_graduationproject.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.our_graduationproject.Model.USERR;
import com.example.our_graduationproject.Model.User;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.UI.GET_POST.GetUser;
import com.example.our_graduationproject.UI.GET_POST.OnUserReceivedListener;

public class profile extends AppCompatActivity implements OnUserReceivedListener {
User user1;
TextView email,phone,company,country,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        user1  =new User();
        email=findViewById(R.id.emaill_user);
        phone=findViewById(R.id.phone);
        company=findViewById(R.id.company);
        country=findViewById(R.id.country);
        name=findViewById(R.id.name);
        GetUser.getData(this,user1,this);
    }
    @Override
    public void OnUserReceived(User user) {
        user1=user;

        email.setText(user.getEmail());
        phone.setText(user.getPhone());
        company.setText(user.getCompany());
        country.setText(user.getCountry());
        name.setText(user.getName());
     }
 }