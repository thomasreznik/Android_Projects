package com.example.family_contacts;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ArrayList<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("Aruther Weasly", "father", R.mipmap.male1));
        contactList.add(new Contact("Molly Weasly", "mother", R.mipmap.female1));
        contactList.add(new Contact("Bill Weasly", "brother", R.mipmap.male2));
        contactList.add(new Contact("Charlie Weasly", "brother", R.mipmap.male2));
        contactList.add(new Contact("Fred Weasly", "brother", R.mipmap.male2));
        contactList.add(new Contact("George Weasly", "sister", R.mipmap.female2));
        contactList.add(new Contact("Percy Weasly", "brother", R.mipmap.male2));
        contactList.add(new Contact("Ginny Weasly", "brother", R.mipmap.male2));
        contactList.add(new Contact("Ron Weasly", "brother", R.mipmap.male2));
        contactList.add(new Contact("Morris Weasly", "brother", R.mipmap.male2));
        contactList.add(new Contact("Sadie Weasly", "brother", R.mipmap.male2));
        contactList.add(new Contact("Anne Weasly", "brother", R.mipmap.male2));
        contactList.add(new Contact("Jon Weasly", "sister", R.mipmap.female2));
        contactList.add(new Contact("Kris Weasly", "brother", R.mipmap.male2));

        //LinearLayout internal_linearlayout = (LinearLayout) findViewById(R.id.linearlayout);

        /*
        for(int i = 0; i < contactList.size(); i++){

            LinearLayout myContactItem = (LinearLayout) LayoutInflater.from(getBaseContext()).inflate(R.layout.contact_item, null);
            TextView name_text = myContactItem.findViewById(R.id.textView);
            TextView relationship_text = myContactItem.findViewById(R.id.textView2);
            ImageView photo_image = myContactItem.findViewById(R.id.imageView);
            name_text.setText(contactList.get(i).name);
            relationship_text.setText(contactList.get(i).relationship);
            photo_image.setImageResource(contactList.get(i).imageID);
            internal_linearlayout.addView(myContactItem);
            
        }

        */
        // A CUSTOM ARRAY ADAPTER TO LIST CONTACTS IN A CUSTOM LIST VIEW
        ContactAdapter contactAdapter = new ContactAdapter(this, contactList);

        // Find the ListView object in the view hierarchy of the Activity.
        ListView listView = (ListView) findViewById(R.id.listview);

        // Make the listView object use the ContactAdapter created above.
        listView.setAdapter(contactAdapter);
    }
}