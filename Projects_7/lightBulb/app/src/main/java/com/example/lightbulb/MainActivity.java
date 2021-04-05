package com.example.lightbulb;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
    private final int ON = 1;
    private final int OFF = 0;
    private ImageView lightImage;
    private int lightStatus;
    private SensorManager mSensorManager;
    private Sensor mSensorAccelerometer;
    private MyShakeListener mShakeDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lightStatus = OFF;
        lightImage = findViewById(R.id.imageView);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new MyShakeListener(new MyShakeListener.OnShakeListener() {
            @Override
            public void onShake(){
                if(lightStatus == ON){
                    lightStatus = OFF;
                    lightImage.setImageResource(R.mipmap.light_off);
                }
                else{
                    lightStatus = ON;
                    lightImage.setImageResource(R.mipmap.light_on);
                }
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mShakeDetector,mSensorAccelerometer,SensorManager.SENSOR_DELAY_UI);
    }
    @Override
    protected void onPause(){
        mSensorManager.unregisterListener(mShakeDetector,mSensorAccelerometer);
        super.onPause();
    }
    /*public void toggleLight(View view){
        if(lightStatus == ON){
            lightStatus = OFF;
            lightImage.setImageResource(R.mipmap.light_off);
        }
        else {
            lightStatus = ON;
            lightImage.setImageResource(R.mipmap.light_on);
        }
    }*/
}