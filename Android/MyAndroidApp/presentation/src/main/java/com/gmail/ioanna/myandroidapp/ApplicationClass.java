package com.gmail.ioanna.myandroidapp;


import android.app.Application;

import com.gmail.ioanna.myandroidapp.di.AppComponent;
import com.gmail.ioanna.myandroidapp.di.AppModule;
import com.gmail.ioanna.myandroidapp.di.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;

import io.realm.Realm;

public class ApplicationClass extends Application{

    public static AppComponent appComponent;

    @Override public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...



        Realm.init(this);

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
