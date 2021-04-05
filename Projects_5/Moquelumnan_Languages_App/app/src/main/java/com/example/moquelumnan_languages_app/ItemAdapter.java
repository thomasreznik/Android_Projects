package com.example.moquelumnan_languages_app;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item> {



    public ItemAdapter(Activity context, ArrayList<Item> AcornList) {
        super(context, 0, AcornList);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        //TASK 1: GET THE CONTACT OBJECT LOCATED AT THE PROVIDED POSITION IN THE LIST.
        Item currentItem = getItem(position);

        //TASK 2: CHECK IF THE EXISTING VIEW (convertView) IS BEING REUSED: ALREADY IN THE SCRAP PILE - (NOT NULL)
        // OTHERWISE INFLATE THE VIEW.

        View myCountItem = convertView;

        if (myCountItem == null) {
            myCountItem = LayoutInflater.from(getContext()).inflate(R.layout.number_item, parent, false);
        }

        //TASK 3: FIND THE TEXTVIEWS AND PHOTO IN THE contact_item LAYOUT.
        // REFERENCE EACH OF THESE VIEWS IN THE CONTACT ITEM
        TextView number = (TextView) myCountItem.findViewById(R.id.textView1);
        TextView numerical = (TextView) myCountItem.findViewById(R.id.textView2);
        ImageView photo_image = (ImageView) myCountItem.findViewById(R.id.imageView);



        // ADD CONTENT TO THE CONTACT ITEM
        number.setText(currentItem.number);
        numerical.setText(currentItem.numeral);
        photo_image.setImageResource(currentItem.imageID);

        //TASK 4: RETURN THE CONTACT ITEM POPULATED WITH DATA
        return myCountItem;
    }
}

