package com.example.imed.Database;

import android.app.UiAutomation;
import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MySQLConnection {





    public Object[] queryMysql(String query, Context context,int size) {
        RequestQueue queue = Volley.newRequestQueue(context);
        //String url = "http://192.168.0.2:4000/select?";
        String url = "http://172.20.0.1:4000/select?";
        Object[] resObj  = new Object[size];

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            if (!response.contains("[{")) {
                                JSONObject obj = new JSONObject(response);
                                Object[] reqObj= new Object[1];
                                reqObj[0] = obj;

                                resObj[0] = reqObj[0];
                            } else {
                                JSONArray arrayObj = new JSONArray(response);
                                Object[] reqObj = new Object[arrayObj.length()];
                                for (int i = 0; i < arrayObj.length(); i++) {
                                    JSONObject obj = new JSONObject(arrayObj.getJSONObject(i).toString());
                                    reqObj[i] = obj;
                                    resObj[i] = obj;
                                }


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Request Error " + error.toString());
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> param = new HashMap<>();
                param.put("query", query);
                return param;
            }
        };
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
        return resObj;
    }

}
