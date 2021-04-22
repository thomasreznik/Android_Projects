package com.example.roaming_ball;


import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends Activity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensorAccelerometer;

    private LayoutInflater layoutInflater;
    private RelativeLayout mainLayout;
    private ImageView ballImage;
    private Ball mBall;

    private Thread movementThread;

    static int TOP;
    static int BOTTOM;
    static int LEFT;
    static int RIGHT;

    private TextView x_axis;
    private TextView y_axis;
    private TextView z_axis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        x_axis = (TextView) findViewById(R.id.textView2);
        y_axis = (TextView) findViewById(R.id.textView4);
        z_axis = (TextView) findViewById(R.id.textView6);

        mBall = new Ball();
        initializeBall();
        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ballImage = (ImageView) layoutInflater.inflate(R.layout.ball_item, null);
        ballImage.setX(50.0f);
        ballImage.setY(50.0f);
        mainLayout.addView(ballImage,0);


        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        movementThread = new Thread(BallMovement);
    }

    private void initializeBall () {

        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        int screenWidth = metrics.widthPixels;
        int screenHeight = metrics.heightPixels;

        mBall.setX(50.0f);
        mBall.setY(50.0f);
        mBall.setWidth(225);

        mBall.setVelocityX(0.0f);
        mBall.setVelocityY(0.0f);

        TOP = 0;
        BOTTOM = screenHeight - mBall.getWidth();
        LEFT = 0;
        RIGHT = screenWidth - mBall.getWidth();

    }

    protected void onResume () {
        super.onResume();
        sensorManager.registerListener(this, sensorAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        movementThread.start();
    }

    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this, sensorAccelerometer);
    }

    protected void onStop () {
        super.onStop();
        finish();
    }

    @Override
    public void onDestroy () {
        finish();
        super.onDestroy();
    }

    public void onSensorChanged(SensorEvent sensorEvent) {

        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            mBall.setVelocityX(sensorEvent.values[0]);
            mBall.setVelocityY(sensorEvent.values[1]);

            x_axis.setText(" " + sensorEvent.values[0]);
            y_axis.setText(" " + sensorEvent.values[1]);
            z_axis.setText(" " + sensorEvent.values[2]);

        }
    }

    public void onAccuracyChanged(Sensor arg0, int arg1) {
    }

    private Runnable BallMovement = new Runnable() {
        private static final int DELAY = 20;

        @Override
        public void run() {
            try {
                while (true){

                    mBall.setX(mBall.getX() - mBall.getVelocityX());
                    mBall.setY(mBall.getY() + mBall.getVelocityY());

                    if (mBall.getY() < TOP) {
                        mBall.setY(TOP);
                    } else if (mBall.getY() > BOTTOM){
                        mBall.setY(BOTTOM);
                    }

                    if(mBall.getX() < LEFT) {
                        mBall.setX(LEFT);
                    } else if (mBall.getX() > RIGHT) {
                        mBall.setX(RIGHT);
                    }

                    Thread.sleep(DELAY);

                    threadHandler.sendEmptyMessage(0);


                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    };

    public Handler threadHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {

            ballImage.setX(mBall.getX());
            ballImage.setY(mBall.getY());
        }
    };

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}