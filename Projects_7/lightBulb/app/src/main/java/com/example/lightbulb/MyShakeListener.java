package com.example.lightbulb;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
public class MyShakeListener implements SensorEventListener {
    private long mTimeOfLastShake;
    private static final float SHAKE_THRESHOLD = 22.0f;
    private static final int SHAKE_TIME_LAPSE = 500;
    private OnShakeListener mShakeListener;
    public MyShakeListener(OnShakeListener shakeListener){
        mShakeListener = shakeListener;
    }
    @Override
    public void onSensorChanged(SensorEvent event){
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            float gForceX = x - SensorManager.GRAVITY_EARTH;
            float gForceY = y - SensorManager.GRAVITY_EARTH;
            float gForceZ = z - SensorManager.GRAVITY_EARTH;
            double value = Math.pow(gForceX,2.0) + Math.pow(gForceY,2.0) + Math.pow(gForceZ,2.0);
            float gForce = (float)Math.sqrt(value);
            String gForceOutput = "" + gForce;
            Log.v("gForce", gForceOutput);
            if(gForce > SHAKE_THRESHOLD){
                final long now = System.currentTimeMillis();
                if(mTimeOfLastShake + SHAKE_TIME_LAPSE > now) {
                    return;
                }
                mTimeOfLastShake = now;
                mShakeListener.onShake();
            }
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){
    }
    public interface OnShakeListener{
        public void onShake();
    }
}