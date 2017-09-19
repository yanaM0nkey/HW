package com.gmail.ioanna.myandroidapp.di;


import android.content.Context;

import com.gmail.ioanna.myandroidapp.classwork17.Gson;
import com.gmail.ioanna.myandroidapp.classwork17.OkHttp;
import com.gmail.ioanna.myandroidapp.classwork17.Rest;
import com.gmail.ioanna.myandroidapp.classwork17.SharedPrefs;
import com.gmail.ioanna.myandroidapp.classwork17.UseCase1;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return context;
    }

    @Provides
    public UseCase1 provideUseCase1(Rest rest, SharedPrefs sharedPrefs){
        return new UseCase1(rest,sharedPrefs);
    }

    @Provides
    public OkHttp provideOkHttp(){
        return new OkHttp();
    }

    @Provides
    public Gson provideGson(){
        return new Gson();
    }

    @Provides
    public Rest provideRest(OkHttp okHttp, Gson gson){
        return new Rest(okHttp, gson);
    }

    @Provides
    public SharedPrefs provideSharedPrefs(){
        return new SharedPrefs();
    }
}
