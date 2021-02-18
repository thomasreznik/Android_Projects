package com.example.bmi_calculator_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView height_txt;
    private TextView pounds_txt;
    private TextView unitchanger1;
    private TextView unitchanger2;
    private TextView output_txt;
    private RadioGroup Units_RadioGroup;
    private BMI bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bmi = new BMI();

        height_txt =  (TextView)findViewById(R.id.textView4);
        pounds_txt =  (TextView)findViewById(R.id.textView7);

        output_txt = (TextView)findViewById(R.id.textView8);

        unitchanger1 = (TextView)findViewById(R.id.textView2);
        unitchanger2 = (TextView)findViewById(R.id.textView6);

        Units_RadioGroup = (RadioGroup)findViewById(R.id.radioGroup);

        Units_RadioGroup.setOnCheckedChangeListener(unitsListener);
    }


    private RadioGroup.OnCheckedChangeListener unitsListener = new RadioGroup.OnCheckedChangeListener(){

        public void onCheckedChanged(RadioGroup rbGroup, int radioId) {
            switch (radioId) {
                case R.id.radioButton:
                    bmi.setUnits("Metric_Units");
                    unitchanger1.setText("Centimeters");
                    unitchanger2.setText("Kilograms");
                    break;

                case R.id.radioButton2:
                    bmi.setUnits("Standard_Units");
                    unitchanger1.setText("Inches");
                    unitchanger2.setText("Pounds");
                    break;
            }

        }
    };

    public void increaseheight(View view){
        bmi.increaseInches();
        height_txt.setText(bmi.inchesamount());
    }

    public void decreaseheight(View view){
        bmi.decreaseInches();
        height_txt.setText(bmi.inchesamount());
    }
    public void increaseweight(View view){
        bmi.increasePounds();
        pounds_txt.setText(bmi.poundsamount());
    }

    public void decreaseweight(View view){
        bmi.decreasePounds();
        pounds_txt.setText(bmi.poundsamount());
    }

    public void ComputeTotal(View view){
        if(bmi.getUnits().equals("Metric_Units")){
            bmi.standard_Calc();
            output_txt.setText("Your BMI is "  + bmi.metric_Calc());
        }
        else{
            output_txt.setText("Your BMI is " + bmi.standard_Calc());
        }
    }

}