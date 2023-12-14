package com.example.our_graduationproject.UI.GET_POST;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.RestrictTo;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.our_graduationproject.Controller.DesignTypeAdapter;
import com.example.our_graduationproject.Controller.SessionManager;
import com.example.our_graduationproject.Controller.VolleySingleton;
import com.example.our_graduationproject.Model.DesignType;
import com.example.our_graduationproject.Model.Preference;
import com.example.our_graduationproject.Model.Scope1;
import com.example.our_graduationproject.SERVER.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GetScopes  {


    public static void getData(Context context, ArrayList<Scope1> list1, final OnScopeReceivedListner listener) {
        String token = SessionManager.getInstance(context).getToken().getToken();
        ArrayList<Scope1> list=new ArrayList<>();
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
list.clear();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URLs.GET_SCOPES, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressDialog.dismiss();

                        try {
                            Toast.makeText(context, "yes ... scopes fetched " + response.getString("message"), Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                        try {
                            JSONArray bookArray = response.getJSONArray("data");
                            System.out.println("Scopes_SizeJson  " + bookArray.length());

                            for (int i = 0; i < bookArray.length(); i++) {
                                JSONObject obj = bookArray.getJSONObject(i);

                                Scope1 object = new Scope1();
                                object.setId(obj.getInt("id"));
                                object.setName(obj.getString("name"));
                                object.setSlug(obj.getString("slug"));

                                list.add(object);
                            }

                            System.out.println("Scopes_SizeJson11  " + bookArray.length());
                            listener.onScopesReceived(list);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
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