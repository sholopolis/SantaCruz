package com.example.android.santacruz;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by arata on 08/10/2016.
 */

public class PlacePagerAdapter extends FragmentStatePagerAdapter {

    public PlacePagerAdapter(FragmentManager fm) {
        super(fm);
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
                return "Restaurants";
            case 1:
                return "Hotels";
            case 2:
                return "Surroundings";
            case 3:
                return "Night Life";
        }
        return "";
    }
}
