package com.example.our_graduationproject.UI.GET_POST;


import static com.example.our_graduationproject.Model.Order.Order.order;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.our_graduationproject.Controller.DesignersAdapter;
import com.example.our_graduationproject.Controller.FinalOrderAdapter;
import com.example.our_graduationproject.Controller.SessionManager;
import com.example.our_graduationproject.Controller.VolleySingleton;
import com.example.our_graduationproject.Model.Designer;
import com.example.our_graduationproject.Model.Order.Order;
import com.example.our_graduationproject.Model.Order.Order_;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.SERVER.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetOrders {


    public  static   String[] colorss,  fontss;

    public static List<Order_> getData(Context context, FinalOrderAdapter adapter,
                                            List<Order_> list

    ) {

        String token = SessionManager.getInstance(context).getToken().getToken();

        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading...");
        progressDialog.show();


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                URLs.GET_ORDERS, null, new Response.Listener<JSONObject>() {


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
                        Order_ order_ = new Order_();

                        order_.setId(obj.getInt("id"));
                        order_.setDescreption(obj.getString("description"));
                        order_.setPrice(Integer.parseInt(obj.getString("final_price")));
                        order_.setType( (obj.getString("type")));
                        order_.setTitle( (obj.getString("title")));
                        order_.setStaues( (obj.getString("status")));

                       // order_.setScope_id( (obj.getString("title")));
                        order_.setPreferebce( obj.getString("pereferce"));
order_.setFileCustomer(obj.getString("file"));
                        order_.setImageArtboard(obj.getString("image"));
                        order_.setStringFile(obj.getString("file_designer"));

System.out.println("file_at : "+order_.getId()+" "+obj.getString("file") +" ---- : "+order_.getFileCustomer());
                        System.out.println("img_at : "+order_.getId()+" "+obj.getString("image") +" ---- : "+order_.getImageArtboard());
                        System.out.println("filee_at : "+order_.getId()+" "+obj.getString("file_designer") +" ---- : "+order_.getStringFile());

//JSONArray jsonObject = obj.getJSONArray("colors");
//if(jsonObject!=null) {
//    colorss = new String[jsonObject.length()];
//    ;
//
//    for (int j = 0; j < jsonObject.length(); j++)
//        colorss[j] = (String) jsonObject.get(j);
//    order_.setColorss(colorss);
                        String colorsJson = obj.getString("colors");

                        try {
                            JSONArray jsonArray = new JSONArray(colorsJson);

                            // Convert JSONArray to an array of strings
                            String[] colorsArray = new String[jsonArray.length()];
                            for (int j = 0;j < jsonArray.length(); j++) {
                                colorsArray[j] = jsonArray.getString(j);
                            }
                            order_.setColorss(colorsArray);
                            // Now you have the colors in an array of strings
                            for (String color : colorsArray) {
                                System.out.println("colorrrrr"+color);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        String fontss = obj.getString("fonts");

                        try {
                            JSONArray jsonArray = new JSONArray(fontss);

                            // Convert JSONArray to an array of strings
                            String[] fontss1 = new String[jsonArray.length()];
                            for (int j = 0;j < jsonArray.length(); j++) {
                                fontss1[j] = jsonArray.getString(j);
                            }
order_.setFontss(fontss1);
                            // Now you have the colors in an array of strings
                            for (String color : fontss1) {
                                System.out.println("fontss : "+color);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        list.add(order_) ;

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

        return list;
    }

    //order_.set(obj.getString("designer_id"));


    //order_.setImage((obj.get("image")));

    // "colors": "[\"111\",\"klkl\"]",
    //"number_pages": null,
    // "fonts": "[\"fgh\"]",
    // "pereferce": null,
    // "value": "[]",
//                                 "image": null,
//                                "is_order_designer": 0,
//                                "designer_id": null,
//                                "size_id": null,
//                                "limit_date": "2023-06-22",
//                                "expected_limit_date": null,
//                                "status": "Pendning",
//                                "notes": null,
//                                "points": null,
//                                "created_at": "2023-08-16T19:54:30.000000Z",
//                                "updated_at": "2023-08-18T14:19:55.000000Z"
//                       int id =obj.getInt("id");
//                        int customer_id =obj.getInt("customer_id");
//                        int item_id =obj.getInt("item_id");
//
//                        String description =obj.getString("description");
//                        int is_idea =obj.getInt("is_idea");
//                        int is_accept =obj.getInt("is_accept");
//                        int is_enternal =obj.getInt("is_enternal");
//                        int is_visual_identity =obj.getInt("is_visual_identity");
//                        int primary_price =obj.getInt("primary_price");
//                        int final_price =obj.getInt("final_price");
//                        String type =obj.getString("type");
//    String title =obj.getString("title");
//    //                        String scope =obj.getString("scope");
//    String file =obj.getString("file");

//                                 "number_pages": null,
//                                 "pereferce": null,
//                                "value": "[]",
    //                                "image": null,
//                                "is_order_designer": 0,
//                                "designer_id": null,
//                                "size_id": null,
//                                "limit_date": "2023-06-22",
//                                "expected_limit_date": null,
//                                "status": "Pendning",
//                                "notes": null,
//                                "points": null,
//                                "created_at": "2023-08-16T19:54:30.000000Z",
//                                "updated_at": "2023-08-16T20:00:19.000000Z"

}




