package com.example.yaran;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return NewsFragment.newInstance();
            default:
                return NewsFragment.newInstance();
        }
    }

        @Override
        public int getCount () {
            return 2;
        }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "برگه اول";
            case 1: return "برگه دوم";
            default: return "";
        }
    }
}
