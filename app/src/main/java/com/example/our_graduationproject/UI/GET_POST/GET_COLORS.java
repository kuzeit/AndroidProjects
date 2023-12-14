package com.example.our_graduationproject.UI.GET_POST;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.our_graduationproject.Controller.ColorAdapter;
import com.example.our_graduationproject.Controller.SessionManager;
import com.example.our_graduationproject.Controller.VolleySingleton;
import com.example.our_graduationproject.Model.ColorSelection;
import com.example.our_graduationproject.Model.Designer;
import com.example.our_graduationproject.Model.Preference;
import com.example.our_graduationproject.Model.prefernce_values;
import com.example.our_graduationproject.SERVER.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GET_COLORS{
     static public ArrayList<ColorSelection> getData(Context context, ColorAdapter adapter, ArrayList<ColorSelection> list){
        String token = SessionManager.getInstance(context).getToken().getToken();

        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        progressDialog.show();


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest( Request.Method.POST,
                URLs.GET_COLORS, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                try {
                    Toast.makeText(context, "sucesssssss"+response.getString("message"), Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


                try {
                    JSONArray bookArray = response.getJSONArray("data");

                     for (int i = 0; i < bookArray.length(); i++) {
                        JSONObject bookObj = bookArray.getJSONObject(i);
                        int id=bookObj.getInt("id");

                           ColorSelection colorSelection= new ColorSelection(id,
                                  Color.parseColor("#"+bookObj.getInt("")));

                         Toast.makeText(context, "#636161", Toast.LENGTH_LONG).show();                        list.add(colorSelection);
                        adapter.notifyDataSetChanged();
                         progressDialog.dismiss();
                    }


                } catch (JSONException e) {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
                System.out.println("errorrr "+error.getMessage());
            }
        } )
        {
            public Map<String,String> getHeaders(){
                Map<String,String> params = new HashMap<String,String>();
                //params.put("Accept","application/json");
                params.put("Authorization","Bearer "+ token);
                return params;
            }
        }

                ;

        VolleySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);

        return list;
    }


}


