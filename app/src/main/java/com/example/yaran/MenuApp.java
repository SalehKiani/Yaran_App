package com.example.yaran;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
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

import static com.example.yaran.Login.access_login;
import static com.example.yaran.login_phone.access;

public class MenuApp extends AppCompatActivity {

    ImageButton news_Ibt;
    GridLayout news_gl;
    TextView news_tv;
    ImageButton wallet_ibt;


    login_phone loginPhone = new login_phone();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_app);


        news_Ibt=(ImageButton)findViewById(R.id.news_pic);
        news_gl=(GridLayout)findViewById(R.id.news_GL);
        news_tv=(TextView) findViewById(R.id.news_TV);
        wallet_ibt=(ImageButton)findViewById(R.id.wallet_pic);

        if(!isonline()) {

            Toast.makeText(this,"به اینترنت متصل نیستی !",Toast.LENGTH_LONG).show();

        }



    }



    public void news_Click(View view)
    {
        if(isonline()) {
            if (access != null) {
                Intent intent_news = new Intent(this, Show_News.class);
                intent_news.putExtra("access", access);
                startActivity(intent_news);

            }
        }
        else {
            Toast.makeText(this,"به اینترنت متصل نیستی !",Toast.LENGTH_LONG).show();
        }

    }

    public void wallet_click(View view)
    {
        if(isonline()) {
            if (Login.access_login != null) {
                Intent intent_wallet = new Intent(this, Wallet_Charge.class);
                intent_wallet.putExtra("access", access);
                startActivity(intent_wallet);

            }
            else{
                Toast.makeText(this,"have not logged in !",Toast.LENGTH_LONG).show();
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

    public void Trip_Click(View view) {
        if(isonline()) {
            if (Login.access_login != null) {
                Intent intent_wallet = new Intent(this, Wallet_Charge.class);
                intent_wallet.putExtra("access", access);
                startActivity(intent_wallet);

            }
            else{
                Toast.makeText(this,"have not logged in !",Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this,"به اینترنت متصل نیستی !",Toast.LENGTH_LONG).show();
        }
    }
}
