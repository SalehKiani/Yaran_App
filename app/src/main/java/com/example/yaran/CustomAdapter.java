package com.example.yaran;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<News> News_list;
    private Context mContext;


    public CustomAdapter(ArrayList<News> news_list, Context mContext) {
        News_list = news_list;
        this.mContext = mContext;
        this.News_list = news_list;
    }

    @Override
    public int getCount() {
        return News_list.size();
    }

    @Override
    public Object getItem(int position) {
        return News_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.list_row, parent, false);
        }


        RequestQueue mRequestQueue = Volley.newRequestQueue(mContext);
        ImageLoader mImageLoader = new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);

            public void putBitmap(String url, Bitmap bitmap) {
                mCache.put(url, bitmap);
            }

            public Bitmap getBitmap(String url) {
                return mCache.get(url);
            }
        });




        News currentItem = (News) getItem(position);

        ImageView imgItem = view.findViewById(R.id.image);
        TextView title = view.findViewById(R.id.title);
        TextView description = view.findViewById(R.id.description);
        TextView pubdate = view.findViewById(R.id.pubdate);
        NetworkImageView imageView=view.findViewById(R.id.image);

        title.setText(currentItem.getTitle());
        if(currentItem.getDescription().equals(null)) {
        }
        else {description.setText(currentItem.getDescription());}
        pubdate.setText(currentItem.getPubDate());

        imageView.setImageUrl(currentItem.getEnclosureUrl(), mImageLoader);

//

        return view;
    }
}
