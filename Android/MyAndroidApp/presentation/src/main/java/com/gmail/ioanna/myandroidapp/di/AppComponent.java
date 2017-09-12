package com.gmail.ioanna.myandroidapp.di;


import com.gmail.ioanna.myandroidapp.classwork17.UI;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    public void inject(UI ui);


}
