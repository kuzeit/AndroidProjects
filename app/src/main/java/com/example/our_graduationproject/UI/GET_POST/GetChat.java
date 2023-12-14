package com.example.our_graduationproject.UI.GET_POST;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Message;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.our_graduationproject.Controller.FinalOrderAdapter;
import com.example.our_graduationproject.Controller.MessagesAdpter;
import com.example.our_graduationproject.Controller.SessionManager;
import com.example.our_graduationproject.Controller.VolleySingleton;
import com.example.our_graduationproject.Controller.msgModelclass;
import com.example.our_graduationproject.Model.Order.Order_;
import com.example.our_graduationproject.SERVER.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetChat {


    public static void getData(Context context, MessagesAdpter adapter,
                                       List<msgModelclass> list , int id

    ) {
        String token = SessionManager.getInstance(context).getToken().getToken();

        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        progressDialog.show();


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                URLs.GET_CHAT(id), null, new Response.Listener<JSONObject>() {


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
                        msgModelclass object = new msgModelclass();
object.setId(obj.getInt("id"));
                        object.setMessage(obj.getString("body"));
                        object.setStringFile(obj.getString("file"));
                        object.setSenderid("1");



                        list.add(object) ;

                    }
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

     }


}





