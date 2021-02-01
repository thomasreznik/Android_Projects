package com.example.burger_calorie_counter;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    //Declare UI Objects

    private RadioGroup patty_RadioGroup;
    private CheckBox prosciutto_checkbox;
    private RadioGroup cheese_RadioGroup;
    private SeekBar sauce_SeekBar;
    private TextView calories_TextView;


    //Declare Burger Object

    private Burger burger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialization of UI objects and variables
        burger = new Burger();
        initialize();

        //Register Change Listener
        registerListeners();
    }

    private void initialize(){
        //Reference to each UI Component
        patty_RadioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        prosciutto_checkbox = (CheckBox)findViewById(R.id.checkBox);
        cheese_RadioGroup = (RadioGroup)findViewById(R.id.radioGroup2);
        sauce_SeekBar = (SeekBar)findViewById(R.id.seekBar);
        calories_TextView = (TextView)findViewById(R.id.textView2);
        displayCalories();
    }

    private void registerListeners(){
        patty_RadioGroup.setOnCheckedChangeListener(foodListener);
        prosciutto_checkbox.setOnClickListener(prosciuttoListener);
        cheese_RadioGroup.setOnCheckedChangeListener(foodListener);
        sauce_SeekBar.setOnSeekBarChangeListener(sauceListener);
    }

    private OnCheckedChangeListener foodListener = new OnCheckedChangeListener(){
        public void onCheckedChanged(RadioGroup rbGroup, int radioId) {
            switch (radioId) {
                case R.id.radioButton: // BEEF PATTY
                    burger.setPattyCalories(Burger.BEEF);
                    break;
                case R.id.radioButton2: // LAMB PATTY
                    burger.setPattyCalories(Burger.LAMB);
                    break;
                case R.id.radioButton3: // OSTRICH PATTY
                    burger.setPattyCalories(Burger.OSTRICH);
                    break;
                case R.id.radioButton7: // ASIAGO CHEESE
                    burger.setCheeseCalories(Burger.ASIAGO);
                    break;
                case R.id.radioButton8: // CREME FRAICHE
                    burger.setCheeseCalories(Burger.CREME_FRAICHE);
            }
            displayCalories();
        }
    };
    private OnClickListener prosciuttoListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
           if(((CheckBox) v).isChecked())
               burger.setProsciuttoCalories(Burger.PROSCIUTTO);
           else
               burger.clearProsciuttoCalories();
           displayCalories();
        }
    };

    private SeekBar.OnSeekBarChangeListener sauceListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            burger.setSauceCalories(seekBar.getProgress());
            displayCalories();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private void displayCalories(){
        String calorieText = "Calories: " + burger.getTotalCalories();
        calories_TextView.setText(calorieText);
    }
}