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


public class HotelsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // rootview contains the list view
        View rootView = inflater.inflate(R.layout.place_list,container, false);

        // create array containing all the information for the hotels
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.hotel_buganvillas),-17.785320, -63.213590
                , "" + 33551212,"http://buganvillassuitesspa.com-hotel.com/",R.drawable.buganvillas_mini,
                getString(R.string.short_hotel_buganvillas),R.drawable.buganvillas_detail));
        places.add(new Place(getString(R.string.hotel_camino_real),-17.756737, -63.199713
                , "" + 33423535,"caminoreal.com.bo",R.drawable.camino_real_mini,
                getString(R.string.short_hotel_camino_real), R.drawable.camino_real_detail));
        places.add(new Place(getString(R.string.hotel_cortez),-17.770928, -63.184151
                , "" + 33331234,"http://www.hotelcortez.com/",R.drawable.cortez_mini,
                getString(R.string.short_hotel_cortez),R.drawable.cortez_detail));
        places.add(new Place(getString(R.string.hotel_los_tajibos),-17.764734, -63.197565
                , "" + 33421000,"http://www.lostajiboshotel.com/",R.drawable.los_tajibos_mini,
                getString(R.string.short_hotel_los_tajibos), R.drawable.los_tajibos_detail));
        places.add(new Place(getString(R.string.hotel_sense),-17.783687, -63.181341
                , "" + 33396666,"http://www.senseshotelboutique.com-hotel.com/",R.drawable.sense_mini,
                getString(R.string.short_hotel_sense),R.drawable.sense_detail));
        places.add(new Place(getString(R.string.hotel_hampton),-17.785320, -63.213590
                , "" + 33551212,"https://www.facebook.com/hamptonsantacruz/?fref=ts",R.drawable.hampton_mini,
                getString(R.string.short_hotel_hampton), R.drawable.hampton_detail));

        //find the list view
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        // creating new place adapter for the list view
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), places, R.color.category_hotels);

        //attach the place adapter to the list view
        listView.setAdapter(placeAdapter);
        // setting up the detail activity for when the user clicks on an item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Place currentPlace = places.get(position);
                Intent intent = new Intent(getContext(),Details.class);
                intent.putExtra("com.example.android.santacruz.Place", currentPlace);
                intent.putExtra("colorId",R.color.category_hotels);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
