package com.example.threading_expirement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logcat(View view){
    new Thread(new Runnable() {
        @Override
        public void run() {
            for(;;) {
                Log.i("DEMO", "Working on it");
            }
        }
    }).start();
    }

    public void toast(View view){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, "Hello there!", duration);
        toast.show();
    }
}