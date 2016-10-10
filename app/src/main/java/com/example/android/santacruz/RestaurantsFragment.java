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
import java.util.List;


public class RestaurantsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // rootview contains the list view
        View rootView = inflater.inflate(R.layout.place_list,container, false);

        // create array containing all the information for the restaurants
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.restaurant_factory),-17.796231,-63.180556
                , "" + 3364300,getString(R.string.web_factory_Grill_and_Bar),R.drawable.factory_mini,
                getString(R.string.short_restaurant_factory),R.drawable.factory_detail));

        places.add(new Place(getString(R.string.restaurant_ken),-17.777091,-63.173666
                , "" + 3333728,getString(R.string.web_ken),R.drawable.ken_mini,
                getString(R.string.short_restaurant_ken),R.drawable.ken_detail));
        places.add(new Place(getString(R.string.restaurant_Tapekua),-17.784852,-63.179289
                    , "" + 3345905,getString(R.string.web_tapekua),R.drawable.tapekua_mini,
                getString(R.string.short_restaurant_tapekua),R.drawable.tapekua_detail));
        places.add(new Place(getString(R.string.restaurant_la_casa_de_la_paella),-17.764962,-63.191385
                , "" + 33403177,getString(R.string.web_la_casa_de_la_Paella),R.drawable.la_casa_de_la_paella_mini,
                getString(R.string.short_restaurant_paella), R.drawable.la_casa_de_la_paella_detail));
        places.add(new Place(getString(R.string.restaurant_casa_del_camba),-17.770085,-63.173742
                , "" + 33427864,getString(R.string.web_casa_del_camba),R.drawable.casa_del_camba_mini,
                getString(R.string.short_restaurant_casa_camba), R.drawable.casa_del_camba_detail));

        places.add(new Place(getString(R.string.restaurant_la_suisse),-17.764656, -63.200446
                , "" + 33436070,getString(R.string.web_la_suisse),R.drawable.la_suisse_mini,
                getString(R.string.short_restaurant_la_suisse), R.drawable.la_suisse_detail));
        //find the list view
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        // creating new place adapter for the list view
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), places, R.color.category_restaurant);

        //attach the place adapter to the list view
        listView.setAdapter(placeAdapter);
        // setting up the detail activity for when the user clicks on an item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Place currentPlace = places.get(position);
                Intent intent = new Intent(getContext(),Details.class);
                intent.putExtra("com.example.android.santacruz.Place", currentPlace);
                intent.putExtra(getString(R.string.colorId),R.color.category_restaurant);
                startActivity(intent);
            }
        });


        return rootView;
    }


}
