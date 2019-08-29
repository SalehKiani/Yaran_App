package com.example.yaran;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class login_phone extends AppCompatActivity {




    RequestQueue requestQueue;
    static String access;
    static public String server_address="http://81.12.13.144:8080";
    String mJSONURLString = (server_address+"/yaran/api/customers/registrations/anonymous");

    TextView phone_ed;
    TextView country_ed;
    TextView codecountry_ed;

    static String phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_phone);
        phone_ed=findViewById(R.id.phone_ET);
        country_ed=findViewById(R.id.country_ET);
        codecountry_ed=findViewById(R.id.codecountry_ET);
        codecountry_ed.setText("98");
        country_ed.setText("ایران");


        if (isonline())
        {
            Token();
        }
        else
        {
            access=null;
        }



    }

    public void menu_Click(View view) {

        Intent intent_menu=new Intent(this , MenuApp.class);
        startActivity(intent_menu);
        this.finish();
    }

    public void code_Click(View view) {

        phone_number =String.valueOf(phone_ed.getText());

        if (isonline())
     {

         if(phone_number.length()==11 ) {

             phone_number = "+" + String.valueOf(codecountry_ed.getText()) + phone_number.substring(1);
             Intent intent_code = new Intent(this, login_code.class);
             startActivity(intent_code);
         }
         else {
             Toast.makeText(this, "شماره تلفن همراه صحیح نیست !", Toast.LENGTH_LONG).show();
         }

     }
     else
     {
         Toast.makeText(this , "به اینترنت متصل نیستی !" ,Toast.LENGTH_LONG).show();
     }

    }


    public void Token () {

        requestQueue = Volley.newRequestQueue(this);

        // Initialize a new JsonObjectRequest instance
        StringRequest stringRequest = new StringRequest(Request.Method.GET, mJSONURLString,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            //getting the whole json object from the response
                            JSONObject obj = new JSONObject(response);
                            access=obj.getString("access_token");
                            String type=obj.getString("token_type");



                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(1==1);
            }
        }
        );

        requestQueue.add(stringRequest);

    }

    public boolean isonline(){
        ConnectivityManager cm= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo=cm.getActiveNetworkInfo();
        if(netinfo!=null && netinfo.isConnectedOrConnecting()){
            return true;
        }
        else{
            return false;
        }
    }


}
