package com.gmail.ioanna.myandroidapp.data.net;


import com.gmail.ioanna.myandroidapp.data.entity.Dz11Profile;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Dz11RestApi {

    @GET("data/people")
    Observable<List<Dz11Profile>> getProfiles();

    /*@POST("data/profile")
    Observable<Void> saveProfile(@Body Profile profile);*/
}
