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
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.SERVER.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GetSuggestColors {
         static public ArrayList<ColorSelection> getData(Context context, ColorAdapter adapter, ArrayList<ColorSelection> list){
            String token = SessionManager.getInstance(context).getToken().getToken();

            final ProgressDialog progressDialog = new ProgressDialog(context);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
             JSONObject params = new JSONObject();
             try {

                 params.put("scope_id", Order.getScope_id());} catch (JSONException e) {
                 e.printStackTrace();
             }

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest( Request.Method.POST,
                    URLs.GET_SUGGEST_COLORS, params, new Response.Listener<JSONObject>() {


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
                            String code=bookObj.getString("code");

                            System.out.println("codee "+"#11"+code +"  #636161"+ Color.parseColor("#11"+code));
                            ColorSelection colorSelection= new ColorSelection(id,
                                    Color.parseColor("#E94560"));

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




