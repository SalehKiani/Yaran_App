package com.example.yaran;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
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

public class Wallet_Charge extends AppCompatActivity {

    public RequestQueue requestQueue;
    public String balancereq;

    TextView tv;
    static String balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet__charge);
        balancereq=login_phone.server_address+"/yaran/api/wallet/balance";
        get_balance();
        tv =  findViewById(R.id.balance_tv);
        tv.setText("موجودی"+"\n"+balance+"ریال");
        Intent in = getIntent();
        Uri data = in.getData();
        if (data != null) {

            String rdata = data.toString().replace("varchar://", "");


            if (rdata.equals("110")) {
                Toast.makeText(getBaseContext(), "موفقیت", Toast.LENGTH_LONG).show();
            } else if(rdata.equals("13")) {
                Toast.makeText(getBaseContext(), "عدم موفقیت", Toast.LENGTH_LONG).show();
            }
        }


    }


    public void transaction_history(View view){

    }

    public void increase_balance(View view){

        Intent i=new Intent(this,Walet_Charge_Amount.class);
        startActivity(i);
    }

    public void get_balance()
    {
    getbalancet.start();
    }

    Thread getbalancet=new Thread(new Runnable() {
        @Override
        public void run() {
            requestQueue = Volley.newRequestQueue(getApplicationContext());

            // Initialize a new JsonObjectRequest instance
            StringRequest stringRequest = new StringRequest(Request.Method.GET, balancereq,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {


                            try {
                                //getting the whole json object from the response
                                JSONObject obj = new JSONObject(response);
                                balance=obj.getString("balanceCurrencyIran");
                                tv.setText("موجودی"+"\n"+balance+"ریال");

                            }
                            catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
            ){
                @Override
                public Map getHeaders() {
                    HashMap headers = new HashMap();
                    headers.put("Content-Type", "application/json");
                    headers.put("Authorization", "Bearer " + Login.access_login);
                    return headers;
                }
            };

            requestQueue.add(stringRequest);

        }
    });




}
