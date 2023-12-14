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
import com.example.our_graduationproject.Model.Scope1;
import com.example.our_graduationproject.Model.User;
import com.example.our_graduationproject.SERVER.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GetUser {

    public static void getData(Context context, User user, final OnUserReceivedListener listener) {
        String token = SessionManager.getInstance(context).getToken().getToken();

        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URLs.GET_USER, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();
                        Toast.makeText(context, "yesss: ", Toast.LENGTH_LONG).show();

                        try {
                            user.setId(response.getInt("id"));
                            user.setName(response.getString("name"));
                            user.setCountry(response.getString("country"));
                            user.setCompany(response.getString("company"));
                            user.setEmail(response.getString("email"));
                            user.setPhone(response.getString("phone_number"));
                            user.setFirstName(response.getString("first_name"));
                            user.setLastName(response.getString("last_name"));

                            listener.OnUserReceived(user);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Errorsss: " + error.getMessage(), Toast.LENGTH_LONG).show();
                        System.out.println("Errorsss: " + error.getMessage());
                    }
                }) {
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", "Bearer " + token);
                return params;
            }
        };

        VolleySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }
}




