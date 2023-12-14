package com.example.our_graduationproject.UI.GET_POST;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.our_graduationproject.Controller.SessionManager;
import com.example.our_graduationproject.Controller.VolleySingleton;
import com.example.our_graduationproject.Helpers.ImageItem;
import com.example.our_graduationproject.SERVER.URLs;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Chat {
    static String token;

    public static void getData(Context context, String   body ,  int user_id ) {
        token = SessionManager.getInstance(context).getToken().getToken();

        ArrayList<ImageItem> list = new ArrayList<>();

        JSONObject params = new JSONObject();

        try {
            params.put("user_id", 1);
            params.put("body", body);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }



        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URLs.CHAT, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Toast.makeText(context, "okk send message ", Toast.LENGTH_SHORT).show();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "errorrr11 ", Toast.LENGTH_LONG).show();
                System.out.println("errorrr11 "+error.getMessage());
            }
        }) {
            public Map<String,String> getHeaders(){
                Map<String,String> params = new HashMap<String,String>();
                params.put("Authorization","Bearer "+ token);
                return params;
            }
        };

        VolleySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }
}
