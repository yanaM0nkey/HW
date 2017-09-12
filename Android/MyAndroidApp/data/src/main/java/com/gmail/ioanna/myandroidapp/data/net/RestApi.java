package com.gmail.ioanna.myandroidapp.data.net;

import com.gmail.ioanna.myandroidapp.data.entity.Profile;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestApi {

    @GET("data/profile")
    Observable<List<Profile>> getProfiles();

    @POST("data/profile")
    Observable<Void> saveProfile(@Body Profile profile);


}
