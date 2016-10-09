package com.example.android.santacruz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class NightLifeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // rootview contains the list view
        View rootView = inflater.inflate(R.layout.place_list,container, false);

        // create array containing all the information for the night activities
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.night_duda),-17.781818, -63.184239
                , "" + 77600655,"https://www.facebook.com/dudapub/",R.drawable.duda_mini,
                getString(R.string.short_night_duda), R.drawable.duda_detail));
        places.add(new Place(getString(R.string.night_kabana),-17.781462, -63.181544
                , "" + 75525775,"https://www.facebook.com/KabanaRestoBar/",R.drawable.kabana_mini,
                getString(R.string.short_night_kabana), R.drawable.kabana_detail));
        places.add(new Place(getString(R.string.night_elegua),-17.776875, -63.182136
                , "" + 77026522,"https://www.facebook.com/EleguaEscuelaDeBaile/",R.drawable.elegua_mini,
                getString(R.string.short_night_elegua), R.drawable.elegua_detail));
        places.add(new Place(getString(R.string.night_goss),-17.769607, -63.190333
                , "" + 3353070,"https://www.facebook.com/goss.bolivia/?fref=ts",R.drawable.goss_mini,
                getString(R.string.short_night_goss), R.drawable.goss_detail));
        places.add(new Place(getString(R.string.night_irish_pub),-17.783093, -63.181548
                , "" + 33338118,"http://irishpub.com.bo/",R.drawable.irish_pub_mini,
                getString(R.string.short_night_irish_pub),R.drawable.irish_pub_detail));
        places.add(new Place(getString(R.string.night_life_trip),-17.784768, -63.180448
                , "" + 78008557,"https://www.facebook.com/TripScz/",R.drawable.trip_mini,
                getString(R.string.short_night_trip),R.drawable.trip_detail));

        //find the list view
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        // creating new place adapter for the list view
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), places, R.color.category_night_life);

        //attach the place adapter to the list view
        listView.setAdapter(placeAdapter);

        // setting up the detail activity for when the user clicks on an item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Place currentPlace = places.get(position);
                Intent intent = new Intent(getContext(),Details.class);
                intent.putExtra("com.example.android.santacruz.Place", currentPlace);
                intent.putExtra("colorId",R.color.category_night_life);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
