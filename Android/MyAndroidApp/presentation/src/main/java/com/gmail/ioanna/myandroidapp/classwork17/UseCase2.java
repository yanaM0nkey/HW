package com.gmail.ioanna.myandroidapp.classwork17;



public class UseCase2 {

    private Rest rest;


    public UseCase2() {
        rest = new Rest(new OkHttp(), new Gson());
    }

    public String getRestData(){
        return "";
    }
}
