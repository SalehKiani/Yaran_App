package com.example.yaran;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static com.example.yaran.Login.access_login;
import static com.example.yaran.login_phone.access;

public class Trip extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);
    }

    public void bus_trip_Click(View view) {

        if(isonline()) {
            if (access_login != null) {
                Intent bus_trip_intent = new Intent(this , Bus_Trip.class);
                startActivity(bus_trip_intent);

            }
            else {
                Toast.makeText(this,"access_login is null",Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this,"به اینترنت متصل نیستی !",Toast.LENGTH_LONG).show();
        }


    }



    public void air_out_trip_Click(View view) {

        if(isonline()) {
            if (access_login != null) {
                Intent bus_trip_intent = new Intent(this , Air_Out_Trip.class);
                startActivity(bus_trip_intent);

            }
            else {
                Toast.makeText(this,"access_login is null",Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this,"به اینترنت متصل نیستی !",Toast.LENGTH_LONG).show();
        }

    }

    public void tran_trip_Click(View view) {
        if(isonline()) {
            if (access_login != null) {
                Intent bus_trip_intent = new Intent(this , Tran_trip.class);
                startActivity(bus_trip_intent);

            }
            else {
                Toast.makeText(this,"access_login is null",Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this,"به اینترنت متصل نیستی !",Toast.LENGTH_LONG).show();
        }

    }

    public void air_in_trip_Click(View view) {

        if(isonline()) {
            if (access_login != null) {
                Intent bus_trip_intent = new Intent(this , Air_In_Trip.class);
                startActivity(bus_trip_intent);

            }
            else {
                Toast.makeText(this,"access_login is null",Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this,"به اینترنت متصل نیستی !",Toast.LENGTH_LONG).show();
        }

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
