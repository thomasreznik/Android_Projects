package com.example.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mNumberDisplay;
    private SimpleExpression mExpression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumberDisplay = (TextView)findViewById(R.id.textView);

        mExpression = new SimpleExpression();
    }

    public void goAC (View view){
        mExpression.clearOperands();
        mNumberDisplay.setText("0");
    }
    public void goOperand(View view){

        String val = (String)mNumberDisplay.getText();
        String digit = (String)view.getContentDescription();
        if(val.charAt(0) == '0'){
           mNumberDisplay.setText(digit);
        }
        else{
            mNumberDisplay.setText((String)mNumberDisplay.getText() + digit.charAt(0));
        }
    }
    public void goOperator(View view){
        String operator = (String)view.getContentDescription();
        try{
            String val = (String)mNumberDisplay.getText();
            mExpression.setmOperand1(Integer.parseInt(val));
        }
        catch (NumberFormatException e){
           mExpression.setmOperand1(0);
        }
        mNumberDisplay.setText("0");
        mExpression.setmOperator(operator);
    }
    public void goCompute(View view) {
        try {
            String val = (String) mNumberDisplay.getText();
            mExpression.setmOperand2((Integer.parseInt(val)));
        } catch (NumberFormatException e) {
            mExpression.setmOperand2(0);
        }
        if (!mExpression.checkO()) {
            mNumberDisplay.setText(mExpression.getmValue().toString());
        }
        else{
            mNumberDisplay.setText("Error");
        }
    }
}