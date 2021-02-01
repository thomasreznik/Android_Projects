package com.example.burger_calorie_counter;

public class Burger {

    // Constants
    static final int BEEF = 100;
    static final int LAMB = 170;
    static final int OSTRICH = 150;
    static final int ASIAGO = 90;
    static final int CREME_FRAICHE = 120;
    static final int PROSCIUTTO = 115;

    //
    private int mPattyCal;
    private int mCheeseCal;
    private int mProsciuttoCal;
    private int mSauceCal;

    //Default Constructor
    public Burger(){
        mPattyCal = 0;
        mCheeseCal = 0;
        mProsciuttoCal = 0;
        mSauceCal = 0;
    }

    public void setPattyCalories(int calories) {
        this.mPattyCal = calories;
    }

    public void setCheeseCalories(int calories) {
        this.mCheeseCal = calories;
    }


    public void setProsciuttoCalories(int calories) {
        this.mProsciuttoCal = calories;
    }

    public void setSauceCalories(int calories) {
        this.mSauceCal = calories;
    }

    public void clearProsciuttoCalories(){
        mProsciuttoCal = 0;
    }

    public int getTotalCalories(){
        return mCheeseCal + mProsciuttoCal + mSauceCal + mPattyCal;
    }

}
