package com.example.handler_messagequeue_practice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    private Counter count;
    private Handler countHandler;
    private TextView countTV;
    private Button startBtn;
    private Button stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countTV = findViewById(R.id.textView);
        startBtn = findViewById(R.id.button);
        stopBtn = findViewById(R.id.button2);

        stopBtn.setEnabled(false);

        count = new Counter();
        countHandler = new Handler();
    }
    public void startCount(View view){
        stopBtn.setEnabled(true);
        startBtn.setEnabled(false);
        countHandler.postDelayed(updateCountRunnable, 500);
    }


    private Runnable updateCountRunnable = new Runnable() {
        public void run() {
            count.setmCountUpdate();
            countTV.setText(count.toString());
            countHandler.postDelayed(this, 500);
        }
    };
    public void stopCount(View view){
        stopBtn.setEnabled(false);
        startBtn.setEnabled(true);
        countHandler.removeCallbacks(updateCountRunnable);
    }
}