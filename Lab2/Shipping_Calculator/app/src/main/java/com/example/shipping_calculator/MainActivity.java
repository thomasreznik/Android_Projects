package com.example.shipping_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextWatcher;


public class MainActivity extends AppCompatActivity {
    private ShipItem shipItem;

    //View Objects for the layout UI Reference
    private EditText weightET;
    private TextView baseCostTV;
    private TextView addedCostTV;
    private TextView totalCostTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shipItem = new ShipItem();

        //Establish reference to input weight element
        weightET = (EditText) findViewById(R.id.simpleEditText);


        //Establish the references to the output element

        baseCostTV = (TextView) findViewById(R.id.textView4);
        addedCostTV = (TextView) findViewById(R.id.textView6);
        totalCostTV = (TextView) findViewById(R.id.textView8);

        //Register the listener event for Weight Input
        weightET.addTextChangedListener(weightTextWatcher);
    }
    private TextWatcher weightTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try{
                shipItem.setWeight((int)Double.parseDouble(s.toString()));
            }catch(NumberFormatException e){
                shipItem.setWeight(0);
            }
            displayShipping();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    private void displayShipping (){
        baseCostTV.setText("$" + String.format("%.02f", shipItem.getBaseCost()));
        addedCostTV.setText("$" + String.format("%.02f", shipItem.getAddedCost()));
        totalCostTV.setText("$" + String.format("%.02f", shipItem.getTotalCost()));
    }
}