package com.example.levic_curve;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private TextView levelsTV;
    private Integer level;
    private ConstraintLayout constraintLayout;
    private FractalView fractalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.constraintLayout);
        fractalView = new FractalView(this);

        constraintLayout.addView(fractalView,0);

        level = 1;
        levelsTV = findViewById(R.id.textView);

    }
    public void drawFractal(View view){
        fractalView.level = level;
        fractalView.invalidate();
    }

    //NUMBERS FOR STEP UP AND STEP DOWN CAN RANGE FROM 1 THROUGH 14
    public void stepUp(View view){
        if(level <14){
            level++;
            levelsTV.setText(level.toString());
        }
    }
    public void stepDown(View view){
        if(level > 1){
            level--;
            levelsTV.setText(level.toString());
        }
    }
}