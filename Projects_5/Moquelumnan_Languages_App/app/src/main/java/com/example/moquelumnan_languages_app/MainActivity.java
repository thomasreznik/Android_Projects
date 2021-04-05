package com.example.moquelumnan_languages_app;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    ArrayList<Item> AcornList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AcornList = new ArrayList<>();

        AcornList.add(new Item("One", "1", R.mipmap.number_one, R.raw.number_one ));
        AcornList.add(new Item("Two", "2", R.mipmap.number_two, R.raw.number_two));
        AcornList.add(new Item("Three", "3", R.mipmap.number_three, R.raw.number_three));
        AcornList.add(new Item("Four", "4", R.mipmap.number_four, R.raw.number_four));
        AcornList.add(new Item("Five", "5", R.mipmap.number_five, R.raw.number_five));
        AcornList.add(new Item("Six", "6", R.mipmap.number_six, R.raw.number_six));
        AcornList.add(new Item("Seven", "7", R.mipmap.number_seven, R.raw.number_seven));
        AcornList.add(new Item("Eight", "8", R.mipmap.number_eight, R.raw.number_eight));
        AcornList.add(new Item("Nine", "9", R.mipmap.number_nine, R.raw.number_nine));
        AcornList.add(new Item("Ten", "10", R.mipmap.number_ten, R.raw.number_ten));



        // A CUSTOM ARRAY ADAPTER TO LIST CONTACTS IN A CUSTOM LIST VIEW
        ItemAdapter itemAdapter = new ItemAdapter(this, AcornList);

        // Find the ListView object in the view hierarchy of the Activity.
        ListView listView = (ListView) findViewById(R.id.listview);

        // Make the listView object use the ContactAdapter created above.
        listView.setAdapter(itemAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                playSound(view,position);
            }
        });

    }
    public void playSound(View view, int position){
        mediaPlayer = MediaPlayer.create(this, AcornList.get(position).musicID);
        mediaPlayer.start();
    }

}