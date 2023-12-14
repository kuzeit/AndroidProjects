package com.example.our_graduationproject.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import com.example.our_graduationproject.Controller.SessionManager;
import com.example.our_graduationproject.Controller.VolleySingleton;
import com.example.our_graduationproject.Model.User;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.SERVER.URLs;
import com.example.our_graduationproject.UI.GET_POST.Data;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {



    private EditText   email, password , phone ;
    private TextView buttonRegister, buttonLogin;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        email = findViewById(R.id.email3);
        password = findViewById(R.id.pass3);
        buttonRegister = findViewById(R.id.signup);
        buttonLogin = findViewById(R.id.login);
 Toast.makeText(getApplicationContext(),"kkkk",Toast.LENGTH_SHORT).show();
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish();
                startActivity(new Intent(LoginActivity.this
                        ,RegisterActivity.class));
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });
    }



    private void userLogin(){
        final String myEmail = email.getText().toString().trim();
        final String myPassword = password.getText().toString().trim();

        if(TextUtils.isEmpty(myEmail)){
            email.setError("Enter you email please");
            email.requestFocus();
            return;
        }


        if(TextUtils.isEmpty(myPassword)){
            password.setError("Enter you password please");
            password.requestFocus();
            return;
        }



        StringRequest stringRequest = new StringRequest(Request.Method.POST,
               URLs.URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
              //  progressBar.setVisibility(View.VISIBLE);


                try {
                    JSONObject obj = new JSONObject(response);
//                    if (obj.getJSONObject("success") != null) {
//                       // progressBar.setVisibility(View.INVISIBLE);
//                        Toast.makeText(getApplicationContext(),
//                                "Welcome", Toast.LENGTH_SHORT).show();
//
//                        JSONObject userJson = obj.getJSONObject("success");
//
//                        User user = new User(userJson.getString("token"));

                    if (obj.getBoolean("success")) {

                        Toast.makeText(getApplicationContext(),
                                obj.getString("message"), Toast.LENGTH_SHORT).show();

                        JSONObject userJson = obj.getJSONObject("data");

                        User user = new User(userJson.getString("token"));
                        SessionManager.getInstance(getApplicationContext()).userLogin(user);
String token= userJson.getString("token");
                        Data.token=token;
                        System.out.println("tokennnn " + userJson.getString("token"));
                        System.out.println("tokennnn " + obj.getString("message"));
                       // finish();
//                        startActivity(new Intent(getApplicationContext(),
//                                MainActivity.class));
                        System.out.println("ggg"+" hhh");
                        startActivity(new Intent(LoginActivity.this,Order1.class));
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Login failed", Toast.LENGTH_SHORT).show();
                        System.out.println("ggg"+" login failed");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),
                                error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        )

        {
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();
                params.put("Content-Type", "application/json");
                params.put("name", myEmail);
                params.put("password", myPassword);
                return  params;

            }
        }   ;


        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);


    }











}
