package com.example.our_graduationproject.UI.GET_POST;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.our_graduationproject.Controller.SessionManager;
import com.example.our_graduationproject.Controller.VolleySingleton;
import com.example.our_graduationproject.Helpers.ImageItem;
import com.example.our_graduationproject.Model.Scope1;
import com.example.our_graduationproject.SERVER.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GetDetailes {
    public static void getData(Context context, ImageItem imageItem,  final OnItemReceivedListner listener) {
        String token = SessionManager.getInstance(context).getToken().getToken();

        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URLs.GET_DETAILES(imageItem.getKey_id()), null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();



                        try {
                            JSONObject jsonObject = response.getJSONObject("data");

                            imageItem.setPreferece(jsonObject.getJSONObject("prefernce").getString("name"));
                            imageItem.setScope(jsonObject.getJSONObject("scope").getString("name"));
                            if(!jsonObject.isNull("preferncevalue") && jsonObject.getJSONObject("preferncevalue") != null) {
                                imageItem.setPreferenceValue(jsonObject.getJSONObject("preferncevalue").getString("name"));
                            } else {
                                // handle the case where the JSON object is null or where the "preferncevalue" key is not present
                            }
                             listener.OnItemReceived(imageItem);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
                        System.out.println("errorrr " + error.getMessage());
                    }
                }) {
            public Map<String,String> getHeaders(){
                Map<String,String> params = new HashMap<String,String>();
                params.put("Authorization","Bearer "+ token);
                return params;
            }
        };

        VolleySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }}

