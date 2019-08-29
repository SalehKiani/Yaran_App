package com.example.yaran;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Walet_Charge_Amount extends AppCompatActivity {


    String URL_reg = login_phone.server_address+"/yaran/api/walletTrx";
    String Id = Login.Id;
    String bank_url;
    String field_name;
    String filed_value;
    String token = Login.access_login;
    RequestQueue requestQueue;
    Context context;
    EditText editText;
    String charge_amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walet__charge__amount);
        editText=(EditText)findViewById(R.id.amount);
        context = getApplicationContext();
    }



    public void amount_setter(View view)
    {
        switch (view.getId())
        {
            case (R.id.btn1):
                editText.setText("1000000");
            case (R.id.btn2):
                editText.setText("500000");
            case (R.id.btn3):
                editText.setText("200000");
        }
    }


    public void confirm(View view)
    {
        try{
            charge_amount=editText.getText().toString();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        if(!charge_amount.equals("0"))
        {
            wallet_charging();
        }
    }




    public void wallet_charging() {
        thread.start();
    }

    Thread thread=new Thread(new Runnable() {
        @Override
        public void run() {
            try {


                JsonObjectRequest JOR = new JsonObjectRequest(Request.Method.POST, URL_reg, new JSONObject("{\"amountCurrencyAfghan\":\"0\"" +
                        ", \"amountCurrencyIran\":\""+charge_amount+"\", \"amountCurrencyUsa\":\"0\" , \"customerId\": \"" + Id + "\" , \"whichGateWay\": \"Mellat\"}"),
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    bank_url = response.getString("forwardUrl");
                                    field_name = response.getString("fieldName");
                                    filed_value = response.getString("fieldValue");
                                    postrequest(field_name,filed_value,bank_url);


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
                        headers.put("Authorization", "Bearer " + token);
                        return headers;
                    }
                };

                requestQueue = Volley.newRequestQueue(context);
                requestQueue.add(JOR);


            } catch (JSONException e) {
                e.getMessage();

            }
        }
    });



    void postrequest(String field_name, String field_value,String url)
    {
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse(url+"?"+field_name+"="+field_value));
        startActivity(i);
    }



}



