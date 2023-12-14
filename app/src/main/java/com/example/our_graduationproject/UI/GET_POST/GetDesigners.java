package com.example.our_graduationproject.UI.GET_POST;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.our_graduationproject.Controller.DesignTypeAdapter;
import com.example.our_graduationproject.Controller.DesignersAdapter;
import com.example.our_graduationproject.Controller.SessionManager;
import com.example.our_graduationproject.Controller.VolleySingleton;
import com.example.our_graduationproject.Model.DesignType;
import com.example.our_graduationproject.Model.Designer;
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.SERVER.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GetDesigners
  {

    public static ArrayList<Designer> getData(Context context, DesignersAdapter adapter,
                                                ArrayList<Designer> list

    ) {
        String token = SessionManager.getInstance(context).getToken().getToken();

        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        progressDialog.show();


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                URLs.GET_DESIGNERS, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                try {
                    Toast.makeText(context, "sucesssssssssssssssddddddd" + response.getString("message"), Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


                try {
                    JSONArray bookArray = response.getJSONArray("data");
                    //Toast.makeText(context, bookArray.length(), Toast.LENGTH_LONG).show();
                    System.out.println("yesss " + bookArray.length());
                    for (int i = 0; i < bookArray.length(); i++) {
                        JSONObject obj = bookArray.getJSONObject(i);


                     }                        Designer object = new Designer();

                    object = new Designer();
                        object.setId(1);
                        object.setName("sami sami");
                        object.setRating(0.6);
                        object.setProfile(String.valueOf(R.drawable.profil_img));
                    list.add(object);
                    object = new Designer();
                    object.setId(1);
                    object.setName("ahmad sami");
                    object.setRating(0.6);
                    object.setProfile(String.valueOf(R.drawable.profil_img));

                        list.add(object);
                         adapter.notifyDataSetChanged();

                        progressDialog.dismiss();




                } catch (JSONException e) {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "errorrrrrtertertetrrrr"+error.getMessage(), Toast.LENGTH_LONG).show();
                System.out.println("errorrr " + error.getMessage());
            }
        }) {
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<String, String>();
                //params.put("Accept","application/json");
                params.put("Authorization", "Bearer " + token);
                return params;
            }
        };

        VolleySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);

        return list;
    }


}



