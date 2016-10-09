package com.example.android.santacruz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class SurroundingsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // rootview contains the list view
        View rootView = inflater.inflate(R.layout.place_list,container, false);

        // create array containing all the information for the surroundings
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.surroundings_espejillos),-17.901062, -63.437247
                , "" + "none","http://www.bolivia-online.net/en/santa-cruz/134/los-espejillos",R.drawable.espejillos_mini,
                getString(R.string.short_surroundings_espejillos), R.drawable.espejillos_detail));
        places.add(new Place(getString(R.string.surroundings_fortress_samaipata),-18.178551, -63.820450
                , "" + 33396470,"http://www.rutaverdebolivia.com/sp/el-fuerte-samaipata.php",R.drawable.fortress_samaipata_mini,
                getString(R.string.short_surroundings_fortress_samaipata), R.drawable.fortress_samaipata_detail));

        places.add(new Place(getString(R.string.surroundings_guembe),-17.767903, -63.249727
                , "" + 33700541,"http://www.biocentroguembe.com/",R.drawable.guembe_mini,
                getString(R.string.short_surroundings_guembe),R.drawable.guembe_detail));

        places.add(new Place(getString(R.string.surroundings_laguna_volcan),-18.120308, -63.647149
                , "" + 33392526,"ecolagunavolcan.com",R.drawable.laguna_volcan_mini,
                getString(R.string.short_surroundings_laguna_volcan), R.drawable.laguna_volcan_detail));

        places.add(new Place(getString(R.string.surroundings_san_jose),-17.834378, -60.750927
                , "" + 77636954,"ecolagunavolcan.com",R.drawable.san_jose_mini,
                getString(R.string.short_surroundings_san_jose), R.drawable.san_jose_detail));

        places.add(new Place(getString(R.string.surroundings_rinconada),-17.782926, -63.245940
                , "" + 33221622,"http://larinconada.com.bo/",R.drawable.rinconada_mini,
                getString(R.string.short_surroundings_rinconada), R.drawable.rinconada_detail));
        //find the list view
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        // creating new place adapter for the list view
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), places, R.color.category_surroundings);

        //attach the place adapter to the list view
        listView.setAdapter(placeAdapter);

        // setting up the detail activity for when the user clicks on an item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Place currentPlace = places.get(position);
                Intent intent = new Intent(getContext(),Details.class);
                intent.putExtra("com.example.android.santacruz.Place", currentPlace);
                intent.putExtra("colorId",R.color.category_surroundings);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
