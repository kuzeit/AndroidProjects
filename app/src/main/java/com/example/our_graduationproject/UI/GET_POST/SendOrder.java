package com.example.our_graduationproject.UI.GET_POST;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.our_graduationproject.Controller.SessionManager;
import com.example.our_graduationproject.Controller.VolleySingleton;
import com.example.our_graduationproject.Model.DesignType;
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.Model.Order.Order_;
import com.example.our_graduationproject.SERVER.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//public class SendOrder {
//        public static void sendTypeDesign(Order_ order, Context context ) {
//            final ProgressDialog progressDialog = new ProgressDialog(context);
//            String token = SessionManager.getInstance(context).getToken().getToken();
//            progressDialog.setMessage("Loading...");
//            progressDialog.show();
//
//            JSONObject postparams = new JSONObject();
//            try {
//                // postparams.put("Content-Type", "application/json");
//
//               // postparams.put("title","title" );
//                Log.d("l___title",order.getTitle());
////                postparams.put("expected_limit_date","2023-06-22" );
////                postparams.put("final_price", order.getPrice());
////                postparams.put("description", order.getDescreption());
////                postparams.put("type",order.getSlug() );
////
////                        postparams.put("primary_price", 444);
////                postparams.put("preference", order.getPreferebce());
//
//                Log.d("l___expected_limit_date","2023-06-22" );
//
//                Log.d("l___final_price", String.valueOf(order.getPrice()));
//                Log.d("l___description","ghhh");
//                Log.d("l___type",order.getSlug() );
//                Log.d("l___preference", order.getPreferebce());
//
//
//
//
//
//
//                Log.d("l___fonts",order.getSelectedFont());
//                JSONArray colorsArray = new JSONArray();
//                colorsArray.put("111");
//                colorsArray.put("klkl");
//               // postparams.put("value", colorsArray);
//               ////////// postparams.put("fonts",colorsArray );
//
////                postparams.put("colors", colorsArray);
////                postparams.put("fonts",colorsArray);
////                 postparams.put("designer_id",order.getSelectedDesigner().getId() );
//                System.out.println("l___designer_id "+ order.getSelectedDesigner().getId());
//                System.out.println("l___colors "+ order.getSelectedColors());
//
//                ///postparams.put("size_id", order.getSize());
//                ///postparams.put("file",order.getSlug() );
//
////                postparams.put("image", order.getImage());
////                Log.d("image", order.getImage());
//                ///postparams.put("value", order.getPreferebce());
//
//
//
//
//
//
//                {               postparams.put("is_idea", true);
//
//                    postparams.put("type"                        ,   "logo");
//                         postparams.put("is_order_designer"            ,    true);
//                        postparams.put("size_id"                      ,    1);
//                        postparams.put( "expected_limit_date"          ,    "2023-06-22");
//                        postparams.put("status"                       ,    "Pendning");
////                        postparams.put( "colors"                       ,     [" 111","klkl"]);
////                    postparams.put( "fonts"                        ,     ["fgh"]);
//                    postparams.put("primary_price"                ,     444);
//                        postparams.put( "final_price"                  ,     333);
//
//                        postparams.put( "description"                  ,    "ghjop[guio");
//                     postparams.put( "pereferce"                   ,     "xcvbnmhhh");
//                }
//
//
//
//
//
//
//
//            }catch (JSONException e){
//                e.getMessage();
//            }
//
//            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest( Request.Method.POST,
//                    URLs.POST_ORDER, postparams, new Response.Listener<JSONObject>() {
//
//                @Override
//                public void onResponse(JSONObject response) {
//                    try {
//
//                        if(response.getBoolean("sucesss")){
//
////                            Toast.makeText(context,"success___upload"+response.getString("message")
////                                    ,Toast.LENGTH_LONG).show();
//                            Log.d("statues",response.getString("message"));
//
//                            System.out.println("success___upload"+response.getString("message"));
//                            progressDialog.setMessage("sucess");
//                            //progressDialog.dismiss();
//
//
//                        }else{
//                            Toast.makeText(context,"error"
//                                    ,Toast.LENGTH_LONG).show();
//                            System.out.println("errorrr1111"+response.getString("message"));
//                            Log.d("statuesdd",response.getString("message"));
//
//                            //progressDialog.dismiss();
//
//                        }
//                        Log.d("statuesgg",response.getString("message"));
//
//
//                    } catch (JSONException e) {
//
//                    }
//                }
//            }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    Toast.makeText(context,"errorrr"+error.getMessage()
//                            ,Toast.LENGTH_LONG).show();
//                    System.out.println("erooorrrrr"+error.getMessage());
//
//                }
//            } )
//            {
//                public Map<String,String> getHeaders(){
//                    Map<String,String> params = new HashMap<String,String>();
//                    //params.put("Accept","application/json");
//                    params.put("Authorization","Bearer "+ token);
//                    return params;
//                }
//            }
//
//                    ;
//
//            VolleySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
//
//
//        }
//
//
//    }


import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.our_graduationproject.Controller.SessionManager;
import com.example.our_graduationproject.Controller.VolleySingleton;
import com.example.our_graduationproject.Model.Order.Order_;
import com.example.our_graduationproject.SERVER.URLs;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SendOrder {
    public static  byte[] getb(File file)
    { {
        byte[] fileData = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(fileData);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  fileData;}
    }
    public static void sendTypeDesign(Order_ order, Context context) {

        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        String token = SessionManager.getInstance(context).getToken().getToken();

        JSONObject postParams = new JSONObject();
        try {
//            postParams.put("is_idea", "true");
//            postParams.put("type", "logo");
//            postParams.put("is_order_designer", "true");
//            postParams.put("size_id", 1);
//            postParams.put("expected_limit_date", "2023-06-22");
//            postParams.put("status", "Pending");
//            postParams.put("primary_price", "444");
//            postParams.put("final_price", "333");
//            postParams.put("description", "ghjop[guio");
//            postParams.put("preference", "xcvbnmhhh");

            JSONArray colorsArray = new JSONArray();
            if(Order.getColorss()!=null)
                for (int i=0 ;i<Order.getColorss().length;i++)
                    colorsArray.put(i,Order.getColorss()[i]);

             postParams.put("colors", colorsArray);
            JSONArray fonts = new JSONArray();
            if(Order.getFontss()!=null)
                for (int i=0 ;i<Order.getFontss().length;i++)

                    fonts.put(i,Order.getFontss()[i]);
            postParams.put("fonts", fonts);

            postParams.put("customer_id", SessionManager.getInstance(context).getToken().getId());
            postParams.put("similer_item_id", order.item_id);

            postParams.put("is_idea", true);
            postParams.put("type", order.getSlug());
            postParams.put("is_order_designer", true);
            postParams.put("size_id", 1);
            postParams.put("expected_limit_date", "2023-06-22");
            postParams.put("status", "Pending");
            postParams.put("primary_price", 444);
            postParams.put("final_price", order.getPrice());
            postParams.put("description", order.getDescreption());
            postParams.put("preference", order.getPreferebce());
//for(int j=0 ; j<colorsArray.length();j++)
//{System.out.println("colorddd :"+order.getColorss()[j]);}
//for(int j=0 ; j<fonts.length();j++)
//{System.out.println("fontss :"+order.getFontss()[j]);}



        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                URLs.POST_ORDER, postParams, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    if (response.getBoolean("success")) {
                        // Success response
                        JSONObject jsonObject = response.getJSONObject("data");
                        int id =jsonObject.getInt("id");


//
                        {
                            VolleyMultipartRequest volleyMultipartRequest = new VolleyMultipartRequest(Request.Method.POST, URLs.APLOUD_IMAGE,id ,
                                    new Response.Listener<NetworkResponse>() {
                                        @Override
                                        public void onResponse(NetworkResponse response) {
                                            try {
                                                JSONObject obj = new JSONObject(new String(response.data));
                                                Toast.makeText(context, obj.getString("message"), Toast.LENGTH_SHORT).show();
                                                JSONObject  hh =obj.getJSONObject("data");
                                                String file =hh.getString("file");
                                                Toast.makeText(context, file, Toast.LENGTH_LONG).show();

                                                System.out.println("imageeee ,"+file);

                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    },
                                    new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
                                            Log.e("GotError",""+error.getMessage());
                                        }
                                    }) {
//
//
                                @Override
                                protected Map<String, DataPart> getByteData() {
                                    Map<String, DataPart> params = new HashMap<>();
                                    long imagename = System.currentTimeMillis();
                                    params.put("image", new DataPart("hjghj", getb(Order.getArtBoard())));
                                    return params;
                                }
                            };

                            //adding the request to volley
                            Volley.newRequestQueue(context).add(volleyMultipartRequest);}



                        {
                            VolleyMultipartRequest volleyMultipartRequest = new VolleyMultipartRequest(Request.Method.POST, URLs.APLOUD_FILE,id ,
                                    new Response.Listener<NetworkResponse>() {
                                        @Override
                                        public void onResponse(NetworkResponse response) {
                                            try {
                                                JSONObject obj = new JSONObject(new String(response.data));
                                                Toast.makeText(context, obj.getString("message"), Toast.LENGTH_SHORT).show();
                                                JSONObject  hh =obj.getJSONObject("data");
                                                String file =hh.getString("file");
                                                Toast.makeText(context, file, Toast.LENGTH_LONG).show();

                                                System.out.println("filerrrr ,"+file);

                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    },
                                    new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            Toast.makeText(context, error.getMessage(), Toast.LENGTH_LONG).show();
                                            Log.e("GotError",""+error.getMessage());
                                        }
                                    }) {


                                @Override
                                protected Map<String, DataPart> getByteData() {
                                    Map<String, DataPart> params = new HashMap<>();
                                    long imagename = System.currentTimeMillis();
                                    params.put("file", new DataPart("hjghj", getb(Order.getFile())));
                                    return params;
                                }
                            };

                            //adding the request to volley
                            Volley.newRequestQueue(context).add(volleyMultipartRequest);}

















                        String message = response.getString("message");
                        Toast.makeText(context, "Success: " + message, Toast.LENGTH_LONG).show();
                        Log.d("Status", message);
                    } else {
                        // Error response
                        String errorMessage = response.getString("message");
                        Toast.makeText(context, "Error: " + errorMessage, Toast.LENGTH_LONG).show();
                        Log.d("Status", errorMessage);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                Log.d("Error", error.getMessage());
                progressDialog.dismiss();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer " + token);
                return headers;
            }
        };

        VolleySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }


}
