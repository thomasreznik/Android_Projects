package com.example.bmi_calculator_app;

public class BMI {


    public Integer inches_quantity;
    public Integer pounds_quantity;


    public String type_unit;

    public BMI(){
        inches_quantity = 0;
        pounds_quantity = 0;
    }


    public String getUnits() {
        return type_unit;
    }

    public void setUnits(String units) {
        this.type_unit = units;
    }
    public void increaseInches() {
        inches_quantity++;
    }

    public void decreaseInches() {
        inches_quantity--;
    }

    public String inchesamount() {
        return inches_quantity.toString();
    }
    public void increasePounds() {
        pounds_quantity++;
    }

    public void decreasePounds() {
        pounds_quantity--;
    }

    public String poundsamount() {
        return pounds_quantity.toString();
    }

    public String standard_Calc(){
        Double BMI = 0.0;

        BMI = ((pounds_quantity.doubleValue())/((inches_quantity.doubleValue() * inches_quantity.doubleValue()))*703);

        return String.format("%.2f",BMI);

    }

    public String metric_Calc(){
        Double BMI2 = 0.0;

        BMI2 = (pounds_quantity.doubleValue()/(inches_quantity.doubleValue() * inches_quantity.doubleValue())*10000);

        return String.format("%.2f",BMI2);

    }

}
