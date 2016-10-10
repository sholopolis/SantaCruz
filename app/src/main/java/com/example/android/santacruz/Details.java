package com.example.android.santacruz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Details extends AppCompatActivity {

    private Place mPlace;
    private int mColorId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        // adding the up navigation button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getting the place object to be displayed
        mPlace =(Place) getIntent().getParcelableExtra("com.example.android.santacruz.Place");
        // getting and setting the background color
        mColorId = getIntent().getIntExtra(getString(R.string.colorId),0);
        LinearLayout info = (LinearLayout) findViewById(R.id.details_info);
        info.setBackgroundResource(mColorId);
        // get image for details
        ImageView imageView = (ImageView) findViewById(R.id.details_image);

        // set image for the current place
        imageView.setBackgroundResource(mPlace.getDetailedImageResourceId());

        TextView textView;
        // get title text view and set it to current place name
        textView = (TextView) findViewById(R.id.details_title);
        textView.setText(mPlace.getNameOfPlace());

        //get the phone text view and set it to current place phone number if it has one
        if(!mPlace.getPhone().equals("")){
            textView = (TextView) findViewById(R.id.details_phone);
            textView.setText(mPlace.getPhone());
            textView.setVisibility(View.VISIBLE);
        }
        //get web page textview and set it to current place webpage
        textView = (TextView) findViewById(R.id.details_web_page);
        textView.setText(mPlace.getWebPage());

        //setting up location intent for current place
        textView = (TextView) findViewById(R.id.details_location);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse(getString(R.string.geo)+ mPlace.getLatitud()+ ", " + mPlace.getLongitud()+ getString(R.string.q) + mPlace.getNameOfPlace());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage(getString(R.string.Maps_class));
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                     startActivity(mapIntent);
                }
            }
        });

    }

}
