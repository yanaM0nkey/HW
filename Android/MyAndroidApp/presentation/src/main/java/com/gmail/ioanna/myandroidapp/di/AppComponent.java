package com.gmail.ioanna.myandroidapp.di;


import com.gmail.ioanna.myandroidapp.classwork17.UI;
import com.gmail.ioanna.myandroidapp.classwork21.RegisterPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    public void inject(UI ui);

    public void inject(RegisterPresenter presenter);


}
