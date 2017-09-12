package com.gmail.ioanna.myandroidapp.classwork17;


import javax.inject.Inject;

public class UseCase1 {

    private Rest rest;
    private SharedPrefs sharedPrefs;

    public UseCase1(Rest rest, SharedPrefs sharedPrefs) {
        this.rest = rest;
        this.sharedPrefs = sharedPrefs;
    }

    public String getRestData(){
        return "";
    }
}
