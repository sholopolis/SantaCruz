package com.example.android.santacruz;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by arata on 08/10/2016.
 */

public class PlacePagerAdapter extends FragmentStatePagerAdapter {
    Context context;
    public PlacePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new RestaurantsFragment();
            case 1:
                return new HotelsFragment();
            case 2:
                return new SurroundingsFragment();
            case 3:
                return new NightLifeFragment();
        }
        return new RestaurantsFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return context.getString(R.string.tab_Restaurants);
            case 1:
                return context.getString(R.string.tab_hotels);
            case 2:
                return context.getString(R.string.tab_surroundings);
            case 3:
                return context.getString(R.string.tab_night_life);
        }
        return "";
    }
}
