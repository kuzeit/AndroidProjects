package com.example.our_graduationproject.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
import com.hbb20.CountryCodePicker;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FinalRegister extends AppCompatActivity {
    private ProgressBar progressBar;

    CountryCodePicker codePicker;
    TextView Register;
    private EditText firstName ,lastName,company, email, password ,phone ,country ,name;
    String myFirstName,myLastName,myEmail,myPassword,myPhone,myCompany ,myName ,myCountry;
    private TextView buttonContinue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_register);
        codePicker=findViewById(R.id.country_code);

        lastName = findViewById(R.id.lastName);
        firstName = findViewById(R.id.firstName);

        phone=findViewById(R.id.phone);
        company=findViewById(R.id.company);
        buttonContinue = findViewById(R.id.login);
        Register=findViewById(R.id.login);
        progressBar = findViewById(R.id.progressBar2);

        // hookers
        Intent intent=getIntent();
        myEmail=  intent.getStringExtra("email");
        myPassword =intent.getStringExtra("password");
        myName=intent.getStringExtra("name");
        // set OnClickListener to the button
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // getting the country code
                String country_code=codePicker.getSelectedCountryCode();

                // getting the country name
                String country_name=codePicker.getSelectedCountryName();

                // getting the country name code
                String country_namecode=codePicker.getSelectedCountryNameCode();
                myCountry=country_name;
                // Toast to show to information based on the selection
                Toast.makeText(FinalRegister.this, "Country Name:-"+country_name+" Country Name Code:-"+country_namecode+" Country Code:-"+country_code, Toast.LENGTH_SHORT).show();
                 save();
            }
        });
    }
    public void save()
    {
        myPhone = phone.getText().toString().trim();
        myCompany = company.getText().toString().trim();
        myLastName = lastName.getText().toString().trim();
        myFirstName = firstName.getText().toString().trim();

        System.out.println("myPhone " + myPhone);
        System.out.println("myCompany " + myCompany);
        System.out.println("myCountry " + myCountry);
        System.out.println("myLastName " + myLastName);
        System.out.println("myFirstName " + myFirstName);
        System.out.println("myEmail " + myEmail);
        System.out.println("myCountry " + myCountry);
        Toast.makeText(this, "myPhone "+myPhone+
        "myCompany " + myCompany+
        "myCountry " + myCountry+
        "myLastName " + myLastName+
        "myFirstName " + myFirstName, Toast.LENGTH_LONG).show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                URLs.URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.VISIBLE);


                try {
                    JSONObject obj = new JSONObject(response);
                    if (obj.getBoolean("success")) {
                        progressBar.setVisibility(View.INVISIBLE);

                        Toast.makeText(getApplicationContext(),
                                obj.getString("message"), Toast.LENGTH_SHORT).show();

                        JSONObject userJson = obj.getJSONObject("data");

                        User user = new User(userJson.getString("token"));
                        System.out.println("tokennnn " + userJson.getString("token"));
                        System.out.println("tokennnn " + obj.getString("message"));

                        SessionManager.getInstance(getApplicationContext()).userLogin(user);
                        String token= userJson.getString("token");
                        Data.token=token;

                        finish();
//                        startActivity(new Intent(getApplicationContext(),
//                                MainActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Register failed", Toast.LENGTH_SHORT).show();
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
                                error.getMessage(), Toast.LENGTH_LONG).show();
                        System.out.println("errorin"+error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {


                Map<String, String> params = new HashMap<>();
                //params.put("Content-Type", "application/json");

                params.put("country", myCountry);
                params.put("name", myName);
                params.put("first_name", myFirstName);
                params.put("last_name", myLastName);
                params.put("company", myCompany);
                params.put("phone_number", myPhone);

                params.put("email", myEmail);
                params.put("password", myPassword);
                return params;

            }
        };


        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
}







