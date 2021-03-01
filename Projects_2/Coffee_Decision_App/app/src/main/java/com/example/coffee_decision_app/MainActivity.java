package com.example.coffee_decision_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;
import android.view.View;
//This class is like a cash register and coffee is a blue print
//Just a good way of thinking of this Model-View-Controller
public class MainActivity extends AppCompatActivity {

    //Data Model
    private TextView quantity_txt;
    private TextView output_txt;
    private CheckBox hasChoco;
    private CheckBox hasWhipped;

    //Coffee Class
    private Coffee coffee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Instantiate Coffee Object
        coffee = new Coffee();
        //Establishing References
        quantity_txt = (TextView)findViewById(R.id.quantity_amount);

        output_txt = (TextView)findViewById(R.id.final_textView);

        hasWhipped = (CheckBox)findViewById(R.id.checkBox);

        hasChoco = (CheckBox)findViewById(R.id.checkBox2);

    }
    //This method increases the quantity
    //then sets text to the quantity
    public void increase(View view){
        coffee.increaseQuantity();
        quantity_txt.setText(coffee.coffeeAmount());
    }
    //This method decreases the quantity
    //then sets text to the quantity
    public void decrease(View view){
        coffee.decreaseQuantity();
        quantity_txt.setText(coffee.coffeeAmount());
    }
    //This method set Chocolate and Whipped Cream
    public void setChocolate(View view){
        coffee.setChoco(hasChoco.isChecked());
    }
    public void setWhipped(View view){
        coffee.setWhipped(hasWhipped.isChecked());
    }
    //Computes the total and puts the summary into the textbox
    public void Compute(View view){
        output_txt.setText(coffee.total());
    }



}