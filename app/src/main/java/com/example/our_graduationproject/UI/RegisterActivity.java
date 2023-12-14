package com.example.our_graduationproject.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.our_graduationproject.Controller.SessionManager;
import com.example.our_graduationproject.Model.User;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.SERVER.URLs;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private EditText name  , email, password ;
    String myName,myEmail,myPassword;
    private TextView buttonContinue;
    private ProgressBar progressBar;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
          name = findViewById(R.id.firstName);
         email = findViewById(R.id.email3);
         password = findViewById(R.id.pass3);
          buttonContinue = findViewById(R.id.login);
         buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                continueToRegister();

            }
        });
    }




    public  void  continueToRegister(){

        myName = name.getText().toString().trim();
         myEmail = email.getText().toString().trim();
         myPassword = password.getText().toString().trim();

        Intent intent= new Intent(getApplicationContext(),FinalRegister.class);
        if(TextUtils.isEmpty(myEmail)){
            email.setError("Enter you email please");
            email.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(myName)){
            name.setError("Enter you name please");
            name.requestFocus();
            return;
        }


        if(TextUtils.isEmpty(myPassword)){
            password.setError("Enter you password please");
            password.requestFocus();
            return;
        }



        intent.putExtra("name", myName);
        intent.putExtra("email", myEmail);
        intent.putExtra("password", myPassword);

        startActivity(intent);
     }


//        StringRequest stringRequest = new StringRequest(Request.Method.POST,
//                URLs.URL_REGISTER, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                progressBar.setVisibility(View.VISIBLE);
//
//
//                try {
//                    JSONObject  obj = new JSONObject(response);
//                    if (obj.getBoolean("success")) {
//                        progressBar.setVisibility(View.INVISIBLE);
//                        Toast.makeText(getApplicationContext(),
//                                obj.getString("message"), Toast.LENGTH_SHORT).show();
//
//                        JSONObject userJson = obj.getJSONObject("data");
//
//                        User user = new User(userJson.getString("token"));
//System.out.println("tokennnn " +userJson.getString("token"));
//                        System.out.println("tokennnn " +obj.getString("message"));
//
//                        SessionManager.getInstance(getApplicationContext()).userLogin(user);
//
//                        finish();
//                        startActivity(new Intent(getApplicationContext(),
//                                MainActivity.class));
//                    } else {
//                        Toast.makeText(getApplicationContext(),
//                                "Register failed", Toast.LENGTH_SHORT).show();
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getApplicationContext(),
//                                error.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//        )
//
//        {
//            @Override
//            protected Map<String,String> getParams() throws AuthFailureError{
//
//
//
//                Map<String,String> params = new HashMap<>();
//               // params.put("Content-Type", "application/json");
//                params.put("name", myName);
//
//                params.put("country_id", "1");
//
//                params.put("first_name", myName);
//                params.put("last_name", "last_name");
//                params.put("company", "company");
//                params.put("phone_number", myPhone);
//
//                params.put("email", myEmail);
//                params.put("password", myPassword);
//
//                return  params;
//
//            }
//        }   ;
//
//
//        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
//
//    }










}
