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
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Wallet_Charge extends AppCompatActivity {



    TextView tv;
    static int balance=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet__charge);
        tv = (TextView) findViewById(R.id.balance_tv);
        tv.setText("موجودی"+"\n"+balance+"ریال");
        Intent in = getIntent();
        Uri data = in.getData();
        if (data != null) {

            String rdata = data.toString().replace("varchar://", "");


            if (rdata.equals("ok")) {
                Toast.makeText(getBaseContext(), "موفقیت", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getBaseContext(), "عدم موفقیت", Toast.LENGTH_LONG).show();
            }
        }


    }


    public void increase_balance(View view){

        Intent i=new Intent(this,Walet_Charge_Amount.class);
        startActivity(i);
    }







}
