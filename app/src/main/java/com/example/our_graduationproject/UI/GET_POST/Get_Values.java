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
import com.example.our_graduationproject.Model.Preference;
import com.example.our_graduationproject.Model.prefernce_values;
import com.example.our_graduationproject.SERVER.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Get_Values {
   public static ArrayList<Preference> getData(Context context,
                                                    ArrayList<Preference> list,
                                                    Preference preference1,
                                                    //ArrayList<String> Strings,
                                                    final OnValueReceivedListner listener

        ) {
            String token = SessionManager.getInstance(context).getToken().getToken();

            final ProgressDialog progressDialog = new ProgressDialog(context);
            progressDialog.setMessage("Loading...");
            progressDialog.show();

       JSONObject params = new JSONObject();
       try {
           params.put("prefernce_id", preference1.getId());
       } catch (JSONException e) {
           throw new RuntimeException(e);
       }

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest( Request.Method.POST,
                    URLs.GET_PREFERENCES_VALUE, params, new Response.Listener<JSONObject>() {


                @Override
                public void onResponse(JSONObject response) {
                    try {
                        Toast.makeText(context, "sucesssssss"+response.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("pppppppp_id "+"1");

                    try {
                        JSONArray Pvalues = response.getJSONArray("data");


                            List<prefernce_values> prefernce_v =new ArrayList<>();
                            for (int j = 0; j < Pvalues.length(); j++)
                            {
                                JSONObject p = Pvalues.getJSONObject(j);
                                int id1 = p.getInt("id");
                                System.out.println("pppppppp_id1 "+id1);

                                String name1 = p.getString("name");
                                System.out.println("pppppppp_name1 "+name1);

                                String image1 = p.getString("image").replace("localhost", "192.168.43.116");
                                System.out.println("pppppppp_image1 "+image1);

                                String price1 = String.valueOf(p.getInt("price"));
                                System.out.println("pppppppp_price1 "+price1);

                                int type_preference=p.getInt("prefernce_id");
                                System.out.println("pppppppp_prefernce_id1 "+type_preference);

                                prefernce_values pv= new prefernce_values(type_preference,
                                        image1,price1,id1,name1);
                                prefernce_v.add(pv)  ;

                            }

preference1.setPrefernce_values(prefernce_v);
                             //list.add(preference1);
                            // Strings.add(preference.getName());


















//                        int id=2;
//                        String  name="name";
//
//                        String  image="http://192.168.43.116:8000/assets/images/background/beauty.jpg";
//
//                        String price= "1";
//
//                          prefernce_v =new ArrayList<>();
//                        //for (int j = 0; j < Pvalues.length(); j++)
//                        {
//                            int id1 =2;
//
//                            String name1 = "name1111";
//
//                            String image1 = "http://192.168.43.116:8000/assets/images/background/beauty.jpg";
//
//                            String price1 = "4";
//
//                            int type_preference=2;
//
//                            prefernce_values pv= new prefernce_values(type_preference,
//                                    image1,price1,id1,name1);
//                            prefernce_v.add(pv)  ;
//
//                        }
//
//
//                        int type_id=1;
//
//                        Preference preference = new Preference(type_id,image,price,id,name,prefernce_v);
//                        list.add(preference);
                        //Strings.add(preference.getName());

                        listener.onValueReceived(list);



                        //adapter.notifyDataSetChanged();
                        progressDialog.dismiss();

                    } catch (JSONException e) {

                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(context, "errorrr "+error.getMessage(), Toast.LENGTH_LONG).show();
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
