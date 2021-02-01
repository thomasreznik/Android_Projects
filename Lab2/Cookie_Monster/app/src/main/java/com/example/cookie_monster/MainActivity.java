package com.example.cookie_monster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView hunger_level_txt;
    private ImageView hunger_image;
    private Button tapBtn;
    private CookieMonster monster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        hunger_level_txt = (TextView)findViewById(R.id.textView);
        hunger_image = (ImageView)findViewById(R.id.imageView);
        monster = new CookieMonster();
        tapBtn = (Button) findViewById(R.id.button);
        tapBtn.setOnClickListener(toggleHunger);
        monster.initializeHunger();
    }

    private final View.OnClickListener toggleHunger = new View.OnClickListener() {
        public void onClick(View btn) {

            if(monster.getHunger()){
                monster.changeHunger();
                hunger_level_txt.setText(R.string.full);
                tapBtn.setText(R.string.done);
                hunger_image.setImageResource(R.mipmap.full);
            }
            else {
                monster.initializeHunger();
                hunger_level_txt.setText(R.string.hungry);
                tapBtn.setText(R.string.cookie);
                hunger_image.setImageResource(R.mipmap.hungry);
            }
        }

    };
    }
