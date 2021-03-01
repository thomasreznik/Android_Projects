package com.hello_goodbye2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hello_goodbye2.R;

public class MainActivity extends AppCompatActivity {

    //Declare text reference to the interface layout component
    private TextView greetingTextView;

    //Indicates hello is currently displayed
    private boolean isHello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Task 1: Inflate the main screen layout used by the app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Task 2: Establish refrences to the textview and button
        greetingTextView = (TextView)findViewById(R.id.textView);
        //Task 3: Initialize greetings
        initializeGreeting();
        //Task 4: Register the listener event for the button
        Button exclaimBtn = (Button) findViewById(R.id.button);
        exclaimBtn.setOnClickListener(toggleGreeting);

    }
    private final View.OnClickListener toggleGreeting = new View.OnClickListener(){

        public void onClick(View btn) {
            //Task: Construct the toggle greeting
            if(isHello){
                isHello = false;
                greetingTextView.setText(R.string.goodbye);
            }
            else {
                isHello = true;
                greetingTextView.setText(R.string.hello);
            }
        }
    };
    private void initializeGreeting(){
        isHello = true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu
        //this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}