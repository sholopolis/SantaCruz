package com.example.android.santacruz;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // view pager that will handle the four different categories
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);

        // setting up the adapter for the fragments to be displayed
        viewPager.setAdapter(new PlacePagerAdapter(getSupportFragmentManager()));

        // attaching tabs to the viewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
