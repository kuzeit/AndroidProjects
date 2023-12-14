package com.example.our_graduationproject.UI.GET_POST;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.our_graduationproject.Controller.GallaryAdapter;
import com.example.our_graduationproject.Controller.SessionManager;
import com.example.our_graduationproject.Controller.VolleySingleton;
import com.example.our_graduationproject.Helpers.ImageItem;
import com.example.our_graduationproject.Model.DesignType;
import com.example.our_graduationproject.Model.Designer;
import com.example.our_graduationproject.R;
import com.example.our_graduationproject.SERVER.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

 public class GetGallaryDesignes {
    static String token;
     static int[] numbers = {R.drawable.k1,R.drawable.r1, R.drawable.r2,
             R.drawable.r3,R.drawable.rk1, R.drawable.rk2, R.drawable.rk4 };

    public static void getData(Context context, final OnDataReceivedListener listener, GallaryAdapter adapter,  int type_id , int scope_id, int preference_id, int preference_value_id) {
        token = SessionManager.getInstance(context).getToken().getToken();
System.out.println("fffffff :"+" preference_id "+  preference_id+" preference_value_id "+preference_value_id);

        ArrayList<ImageItem> list = new ArrayList<>();

        JSONObject params = new JSONObject();
        try {
            if(type_id>0)
            params.put("type_id", type_id);
            if(preference_id>0)
                params.put("preference_id", preference_id);
            if(preference_value_id>0)
                params.put("preference_value_id", preference_value_id);
            if(scope_id>0)
                params.put("scope_id", scope_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URLs.GET_DESIGNES, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                     JSONArray bookArray = response.getJSONArray("data");


                    System.out.println( "sucess to get images "+bookArray.length()+"");
                    for (int i = 0; i < bookArray.length(); i++) {

                        JSONObject obj = bookArray.getJSONObject(i);
                        ImageItem object = new ImageItem();
                        object.setKey_id(obj.getInt("id"));
                        object.setScopId(obj.getInt("scope_id"));
                        object.setTypeId(obj.getInt("type_id"));
                        object.setPrefernceId(obj.getInt("prefernce_id"));
                        object.setPrefernceValueId(obj.getInt("prefernce_value_id"));
                        object.setLikes(obj.getInt("likes"));
                        ///object.setPrice(obj.getInt("price"));

                        object.setImage(obj.getString("image").replace("localhost", "192.168.43.116:8000"));
                        System.out.println("image11 "+object.getImage());
                        object.setImageInt(numbers[i]);



                        list.add(object);




                    }
//                    ImageItem object = new ImageItem();
//
//                    object.setKey_id(1);
//                    object.setScopId(1);
//                    object.setTypeId(1);
//                    object.setPrefernceId(1);
//                    object.setPrefernceValueId(1);
//                    object.setLikes(0);
//                    object.setPrice(300);
//                    list.add(object);
//
//                    object.setImage(String.valueOf(R.drawable.logo_1));
//                    System.out.println("image11 "+object.getImage());
                    ArrayList<ImageItem> imageItems1= new ArrayList<>();
                    for (int i = 0; i < list.size(); i++) {

                        if ((list.get(i).getPrefernceValueId() == preference_value_id||preference_value_id==00)
                                && (list.get(i).getTypeId() == type_id||type_id==0)
                                && (list.get(i).getPrefernceId() == preference_id||preference_id==0)
                                && (list.get(i).getScopId() == scope_id||scope_id==0))
                            imageItems1.add(list.get(i));
                    }
                    System.out.println("imageItems1 :"+imageItems1);
                    listener.onDataReceived(imageItems1);
       if(adapter!=null)
      adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
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
//     public ArrayList<ImageItem> filter(int type_id , int prefernce_id , int preference_value_id ,int scope_id) {
//         ArrayList<ImageItem> imageItems1= new ArrayList<>();
//         for (int i = 0; i < imageItems.size(); i++) {
//             if(imageItems.get(i).getPrefernceValueId()==preference_value_id
//                     &&imageItems.get(i).getTypeId()==type_id
//                     &&imageItems.get(i).getPrefernceId()==prefernce_id
//                     &&imageItems.get(i).getScopId()==scope_id)
//                 imageItems1.add(imageItems.get(i));
//             return imageItems1;
//         }
//     }
}






























