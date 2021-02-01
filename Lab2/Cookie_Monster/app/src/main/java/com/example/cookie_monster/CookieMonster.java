package com.example.cookie_monster;

import android.widget.TextView;

public class CookieMonster {
    private boolean food;

    public CookieMonster() {
    }

    public void initializeHunger() {
        food = true;
    }

    public Boolean getHunger() {
        return food;
    }

    public void changeHunger() {
        food = false;
    }
}

