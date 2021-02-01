package com.example.coffee_decision_app;

public class Coffee {

    public Boolean whipped;
    public Boolean choco;
    public Integer quantity;

    public final int MAX = 25;
    public final int MIN = 0;

    public Coffee() {
        whipped = false;
        choco = false;
        quantity = 0;
    }

    public void increaseQuantity() {
        if (quantity < MAX) {
            quantity++;
        }
    }

    public void decreaseQuantity() {
        if (quantity > MIN) {
            quantity--;
        }
    }

    public String coffeeAmount() {
        return quantity.toString();
    }

    public void setWhipped(Boolean whipped) {
        this.whipped = whipped;
    }

    public void setChoco(Boolean choco) {
        this.choco = choco;
    }

    public String total(){


        Double whipped_price = 0.50;
        Double choco_price = 1.00;

        Double coffee_price = 3.50 * quantity;

        if(choco){
            coffee_price += (choco_price * quantity);
        }
        if(whipped){
            coffee_price +=  (whipped_price * quantity);
        }
        String order = "";
        order+= "Add whipped cream? " + (this.whipped?"yes":"no") + "\n";
        order+= "Add chocolate? " + (this.choco? "yes":"no") + "\n";
        order+= "Quantity: " + quantity.toString() + "\n\n";
        order+= "Price: $" + String.format("%.2f",coffee_price) + "\nTHANK YOU!";
        return order;

    }
}