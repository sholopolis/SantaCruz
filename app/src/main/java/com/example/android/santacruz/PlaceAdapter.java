package com.example.android.santacruz;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.R.attr.description;

/**
 * Created by arata on 07/10/2016.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {
    int mBackgroudColorId;

    public PlaceAdapter(Context context, ArrayList<Place> places, int colorId) {
        super(context, 0, places);
        this.mBackgroudColorId = colorId;
    }

    private static class ViewHolder{
        ImageView image;
        TextView title;
        TextView shortDescripttion;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View list_item_view = convertView;
        // variable to hold reference to old items
        ViewHolder holder;

        // if the view is empty change inflate one and store its fields in the holder for future reference
        if(list_item_view == null){
            list_item_view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
            holder = new ViewHolder();
            holder.image             = (ImageView) list_item_view.findViewById(R.id.list_item_image);
            holder.title             = (TextView)  list_item_view.findViewById(R.id.list_item_title);
            holder.shortDescripttion = (TextView) list_item_view.findViewById(R.id.list_item_short_description);
            list_item_view.setTag(holder);
        }
        else{
            holder = (ViewHolder) list_item_view.getTag();
        }
        //setting up the background
        list_item_view.setBackgroundResource(mBackgroudColorId);

        //getting the current place
        Place currentPlace = getItem(position);

        //setting up the image for the current place
        holder.image.setImageResource(currentPlace.getImageResourceId());

        //setting up the title for the current place
        holder.title.setText(currentPlace.getNameOfPlace());

        //setting up the short description for the place
        holder.shortDescripttion.setText(currentPlace.getShortDescription());

        return list_item_view;
    }
}
