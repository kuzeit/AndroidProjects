package com.example.our_graduationproject.UI.GET_POST;

import static java.lang.String.valueOf;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.our_graduationproject.Controller.FontAdapter;
import com.example.our_graduationproject.Controller.FontSelection;
import com.example.our_graduationproject.Controller.SessionManager;
import com.example.our_graduationproject.Controller.VolleySingleton;
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.SERVER.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GetSuggestFonts {
         static public ArrayList<FontSelection> getData(Context context, FontAdapter adapter, ArrayList<FontSelection> list){
            String token = SessionManager.getInstance(context).getToken().getToken();

             JSONObject params = new JSONObject();
             try {

                 params.put("scope_id", Order.getScope_id());} catch (JSONException e) {
                 e.printStackTrace();
             }


            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest( Request.Method.POST,
                    URLs.GET_SUGGEST_FONTS, params, new Response.Listener<JSONObject>() {


                @Override
                public void onResponse(JSONObject response) {
                    try {
                        Toast.makeText(context, "sucesssssss"+response.getString("message"),
                                Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }


                    try {
                        JSONArray bookArray = response.getJSONArray("data");

                        for (int i = 0; i < bookArray.length(); i++) {
                            JSONObject bookObj = bookArray.getJSONObject(i);
                            int id=bookObj.getInt("id");
                            String image=bookObj.getString("file");
                            String name=bookObj.getString("name");
                            FontSelection fontSelection= new FontSelection(id,valueOf(R.drawable.fo1),name
                            );
                            list.add(fontSelection);
                            adapter.notifyDataSetChanged();
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




