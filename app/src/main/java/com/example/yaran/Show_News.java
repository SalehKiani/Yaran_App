package com.example.yaran;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Show_News extends AppCompatActivity {

    public Context context2;
    public static String access;
    public RequestQueue requestQueue;
    ListView news_list;
    public List<News> newsArray1;
    String url = login_phone.server_address+"/yaran/api/yjc/search";
//    shownews news = new shownews();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__news);

//        adapter
//        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(adapter);

        context2 = getApplicationContext();
        Intent i2 = getIntent();
        access = i2.getStringExtra("access");
        newsArray1=new ArrayList<>();
        postmethod();
        news_list=(ListView)findViewById(R.id.news_list);


    }



    void postmethod()
    {
        news_thread.start();

    }


        Thread news_thread=new Thread(new Runnable() {
            @Override
            public void run() {
                final ArrayList<News> newsArray2 = new ArrayList<>();
                try {
                    JsonObjectRequest jsonobj = new JsonObjectRequest(Request.Method.POST, url, new JSONObject("{\"count\":50,\"startIndex\": 0}"),
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        JSONArray jsonArray = response.getJSONArray("list");

                                        for (int i = 0; i < jsonArray.length(); i++) {
                                            JSONObject newObject = jsonArray.getJSONObject(i);
                                            String author = newObject.getString("author");
                                            String description=newObject.getString("description");
                                            String enclosureLength=newObject.getString("enclosureLength");
                                            String enclosureType=newObject.getString("enclosureType");
                                            String enclosureUrl=newObject.getString("enclosureUrl");
                                            String link=newObject.getString("link");
                                            String pubDate=newObject.getString("pubDate");
                                            String title = newObject.getString("title");


                                            newsArray2.add(new News(author,description,enclosureLength,enclosureType,enclosureUrl,link,pubDate,title));

                                        }
                                        CustomAdapter mAdapter = new CustomAdapter(newsArray2,context2);
                                        news_list.setAdapter(mAdapter);
                                    } catch (JSONException e) {
                                        e.getMessage();
                                    }

                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    if(1==1);
                                }
                            }

                    ) {
                        @Override
                        public Map getHeaders() {
                            HashMap headers = new HashMap();
                            headers.put("Content-Type", "application/json");
                            headers.put("Authorization", "Bearer " + access);
                            return headers;
                        }
                    };
                    requestQueue = Volley.newRequestQueue(context2);
                    requestQueue.add(jsonobj);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        });



}
