package com.gmail.ioanna.myandroidapp.data.net;


import android.util.Log;

import com.gmail.ioanna.myandroidapp.data.entity.Dz11Profile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Dz11RestService {

    private static final Dz11RestService instance = new Dz11RestService();

    private Dz11RestApi restApi;

    private Dz11RestService(){
        init();
    }

    public static Dz11RestService getInstance() {
        return instance;
    }

    private void init() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        Gson gson =  new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.backendless.com/E6B86BBD-D332-2BF1-FFB0-F4E65BC9A300/7CFD6243-9E56-6AF9-FFFB-F5254C84F900/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient).build();

        restApi = retrofit.create(Dz11RestApi.class);
    }

    public Observable<List<Dz11Profile>> getProfiles() {
        return restApi.getProfiles();
    }

    public Observable<Dz11Profile> getProfileById(String id){
        Log.e("restser", id);
        return restApi.getProfileById(id);
    }

    public Observable<Void> updateProfile(Dz11Profile profile) {
        return restApi.updateProfile(profile, profile.getId());
    }
}
