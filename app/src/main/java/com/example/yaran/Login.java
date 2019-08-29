package com.example.yaran;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.yaran.login_phone.access;

public class Login {

    String URL_reg=login_phone.server_address+"/yaran/api/customers/registrations";


    RequestQueue requestQueue ;
    login_phone logPhone =new login_phone();
    String AC = access;
    static String access_login;
    String Url_verify= login_phone.server_address+"/yaran/api/customers/registrations/";
    static public String Id;

    public void Login_Register(final Context context) {
        try {


            JsonObjectRequest JOR = new JsonObjectRequest(Request.Method.POST, URL_reg, new JSONObject("{\"cell\":\"+989190118348\"  ,\"firstName\":\"LI\" , \"lastName\":\"SO\" }"),
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                               Id = response.getString("customerId");
                            } catch (JSONException e) {
                                e.getMessage();

                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {
                @Override
                public Map getHeaders() {
                    HashMap headers = new HashMap();
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Bearer " + AC);
                    return headers;
                }
            };

            requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(JOR);


        }
        catch (JSONException e)
        {
            e.getMessage();

        }

    }



     void verifynum(Context context,String code)
    {
        Url_verify+=this.Id+"/"+"1234";
        requestQueue=Volley.newRequestQueue(context);


        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url_verify,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            //getting the whole json object from the response
                            JSONObject obj = new JSONObject(response);
                            access_login=obj.getString("access_token");
                            String type=obj.getString("token_type");



                        }
                        catch (JSONException e) {
                            e.getMessage();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(1==1);
            }
        }
        )
        {
            @Override
            public Map getHeaders() {
                HashMap headers = new HashMap();
                headers.put("Content-Type", "application/json");
                headers.put("Authorization", "Bearer " + AC);
                return headers;
            }
        };

        requestQueue.add(stringRequest);
    }

 }








