package com.example.our_graduationproject.UI.GET_POST;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.our_graduationproject.Controller.DesignTypeAdapter;
import com.example.our_graduationproject.Controller.SessionManager;
import com.example.our_graduationproject.Controller.StringAdapter;
import com.example.our_graduationproject.Controller.VolleySingleton;
import com.example.our_graduationproject.Model.DesignType;
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.Model.Preference;
import com.example.our_graduationproject.Model.prefernce_values;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.SERVER.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GET_PREFERENCES {

public  static int[] numbers;
    public static ArrayList<Preference> getData(Context context,
                                                ArrayList<Preference> list1,

                                                final OnPreferenceReceivedListener listener

    ) {
        int[] numbers = {0, 0, 0, 0, R.drawable.facebook,R.drawable.twitter,R.drawable.instagram};

        ArrayList<Preference> list= new ArrayList<>();
        String token = SessionManager.getInstance(context).getToken().getToken();

        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        JSONObject params = new JSONObject();
        try {
            params.put("type_id", Order.getTypeOrder());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest( Request.Method.POST,
                URLs.GET_PREFERENCES, params, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
//                try {
//                 } catch (JSONException e) {
//                    throw new RuntimeException(e);
//                }
                System.out.println("pppppppp_id "+"1");

                try {
                    JSONArray bookArray = response.getJSONArray("data");
System.out.println("sssssssssssssssssssssssssssshghfghf"+response.getString("message"));
                    System.out.println("pppppppp_id "+bookArray.length());
                    for (int i = 0; i < bookArray.length(); i++) {
                        JSONObject bookObj = bookArray.getJSONObject(i);
                        int id=bookObj.getInt("id");
                        System.out.println("pppppppp_id "+id);
                        String name=bookObj.getString("name");
                        System.out.println("pppppppp_name "+name);

                        String image=bookObj.getString("image").replace("localhost", "192.168.43.116");
                        System.out.println("pppppppp_image "+image);

                        String price= String.valueOf(bookObj.getInt("price"));
                        System.out.println("pppppppp_image "+image);

                        int type_id=bookObj.getInt("type_id");
                        System.out.println("pppppppp_type_id "+type_id);



                        JSONArray Pvalues = bookObj.getJSONArray("prefernce_values");

                        List<prefernce_values> prefernce_v =new ArrayList<>();
                        for (int j = 0; j < Pvalues.length(); j++) {
                            JSONObject p = Pvalues.getJSONObject(j);
                            int id1 = p.getInt("id");
                            System.out.println("pppppppp_id1 " + id1);

                            String name1 = p.getString("name");
                            System.out.println("pppppppp_name1 " + name1);

                            String image1 = p.getString("image").replace("localhost", "192.168.43.116");
                            System.out.println("pppppppp_image1 " + image1);

                            String price1 = String.valueOf(p.getInt("price"));
                            System.out.println("pppppppp_price1 " + price1);

                            int type_preference = p.getInt("prefernce_id");
                            System.out.println("pppppppp_prefernce_id1 " + type_preference);

                            prefernce_values pv = new prefernce_values(type_preference,
                                    image1, price1, id1, name1);
                            prefernce_v.add(pv);

                        }











                            Preference preference = new Preference(type_id,image,price,id,name,prefernce_v);

                    list.add(preference);


                    }

                     listener.onPreferenceReceived(list);



                     progressDialog.dismiss();

                } catch (JSONException e) {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                 System.out.println("errorrrinpreferencesssssssss "+error.getMessage());
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
