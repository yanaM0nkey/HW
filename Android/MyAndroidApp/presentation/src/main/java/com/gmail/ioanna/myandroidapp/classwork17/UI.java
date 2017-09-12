package com.gmail.ioanna.myandroidapp.classwork17;


import com.gmail.ioanna.myandroidapp.ApplicationClass;

import javax.inject.Inject;

public class UI {

    @Inject
    UseCase1 useCase1;

    public UI() {
        ApplicationClass.appComponent.inject(this);
    }

    public void testUseCase1(){

        useCase1.getRestData();
    }
}
