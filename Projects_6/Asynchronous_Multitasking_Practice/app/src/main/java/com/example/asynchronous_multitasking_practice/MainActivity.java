package com.example.asynchronous_multitasking_practice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView toyImage;
    private Toy myToy;
    private MyAsyncTask myAsyncTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toyImage = findViewById(R.id.imageView);

        myToy = new Toy();
    }
    public void rotateAction(View view){

        if(!myToy.isRotating){
            myToy.isRotating = true;
            myAsyncTask = new MyAsyncTask();
            myAsyncTask.execute(myToy.angle);
        }
        else{
            myToy.isRotating = false;
        }
    }
    private class MyAsyncTask extends AsyncTask<Integer, Integer, Integer>{

        protected Integer doInBackground(Integer...values){
            myToy.angle = values[0];
            while (myToy.isRotating){
                try {
                    Thread.sleep(100);
                    myToy.angle = (myToy.angle + 10) % 360;
                    publishProgress(myToy.angle);
                }
                catch (InterruptedException e){}
            }
            return myToy.angle;
        }
        protected void onProgressUpdate(Integer...values){
            super.onProgressUpdate(values);
            toyImage.setRotation(values[0]);
        }
    }
}