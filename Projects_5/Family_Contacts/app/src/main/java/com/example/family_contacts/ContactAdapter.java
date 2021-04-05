package com.example.family_contacts;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contact> {
    public ContactAdapter(Activity context, ArrayList<Contact> contactList) {
        super(context, 0, contactList);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        //TASK 1: GET THE CONTACT OBJECT LOCATED AT THE PROVIDED POSITION IN THE LIST.
        Contact currentContact = getItem(position);

        //TASK 2: CHECK IF THE EXISTING VIEW (convertView) IS BEING REUSED: ALREADY IN THE SCRAP PILE - (NOT NULL)
        // OTHERWISE INFLATE THE VIEW.

        View myContactItem = convertView;

        if (myContactItem == null) {
            myContactItem = LayoutInflater.from(getContext()).inflate(R.layout.contact_item, parent, false);
        }

        //TASK 3: FIND THE TEXTVIEWS AND PHOTO IN THE contact_item LAYOUT.
        // REFERENCE EACH OF THESE VIEWS IN THE CONTACT ITEM
        TextView name_text = (TextView) myContactItem.findViewById(R.id.textView);
        TextView relationship_text = (TextView) myContactItem.findViewById(R.id.textView2);
        ImageView photo_image = (ImageView) myContactItem.findViewById(R.id.imageView);

        // ADD CONTENT TO THE CONTACT ITEM
        name_text.setText(currentContact.name);
        relationship_text.setText(currentContact.relationship);
        photo_image.setImageResource(currentContact.imageID);
        //TASK 4: RETURN THE CONTACT ITEM POPULATED WITH DATA
        return myContactItem;
    }
}

