package com.example.fibonacci_flower;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ImageView> allPetals;
    private LayoutInflater layoutInflater;

    private Button pinkBtn;
    private Button goldBtn;
    private Button clearBtn;
    private ConstraintLayout constraintLayout;

    Flower flower;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flower = new Flower();
        allPetals = new ArrayList<ImageView>();

        //Initialize the fibonaci artwork
        initialize();

        //Create a layout inflator to add petals to constraint layout
        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);

        pinkBtn = (Button) findViewById(R.id.button);
        goldBtn = (Button) findViewById(R.id.button2);
        clearBtn = (Button) findViewById(R.id.button3);

        //Setting up center coordinate

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        flower.set_xCenter(metrics.widthPixels / 2);
        flower.set_yCenter(metrics.heightPixels / 2);
    }
    private void initialize(){

        flower.setRotate(0);
        flower.setScaleX((float).3);
        flower.setScaleY((float).3);
        flower.setDegenerate((float)1.001);
        flower.initializeAngle();
    }

    public void addPetal(View view){

        //Instantiate a view to store a petal image
        ImageView petal;

        //Inflating the correct petal
        String buttonText = ((Button) view).getText().toString();
        if(buttonText.equals("Add Pink")){
            petal = (ImageView)layoutInflater.inflate(R.layout.petal_pink,null);
        }
        else{
            petal = (ImageView)layoutInflater.inflate(R.layout.petal_gold,null);
        }

        //Setting visual properties of the petal
        petal.setX(flower.get_xCenter());
        petal.setY(flower.get_ycenter());
        petal.setPivotX(100);
        petal.setPivotY(0);
        petal.setScaleY(flower.getScaleY());
        petal.setScaleX(flower.getScaleX());
        petal.setRotation(flower.getRotate());

        //Place inflated imageview in the main layout
        constraintLayout.addView(petal,0);

        //Add imageview of petal to arraylist
        allPetals.add(petal);

        //Update angle and scale for next petal
        flower.updatePetalValues();
    }
    public void clearPetal(View view) {
       //Remove all petal image views off of layout
        for (int i =0; i<allPetals.size(); i++){
            //One by one removes petal
            ImageView petal = allPetals.get(i);
            constraintLayout.removeView(petal);
        }
        //Clear ArrayList and Reset the variables
        allPetals.clear();
        initialize();
    }
}