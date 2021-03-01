package com.example.music_player_app;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button play;
    private Button pause;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.button);

        pause = findViewById(R.id.button2);

        mediaPlayer = MediaPlayer.create(this, R.raw.cow_mad_x);


    }
    public void play_music(View view){
        Log.v("msg", "Play!");
        mediaPlayer.start();


    }
    public void pause_music(View view){
        mediaPlayer.pause();
    }

}