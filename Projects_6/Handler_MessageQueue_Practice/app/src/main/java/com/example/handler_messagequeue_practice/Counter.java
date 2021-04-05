package com.example.handler_messagequeue_practice;

public class Counter {
    private Integer mCountUpdate;
    public Counter(){
        mCountUpdate = 0;
    }
    public void setmCountUpdate(){
        mCountUpdate++;
    }
    public Integer getCountUpdate(){
        return mCountUpdate;
    }
    public String toString(){
        return mCountUpdate.toString();
    }
}