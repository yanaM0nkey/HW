package com.gmail.ioanna.myandroidapp.data.net;


import android.util.Log;

import com.gmail.ioanna.myandroidapp.data.entity.Dz11Profile;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Dz11RestApi {

    @GET("data/people")
    Observable<List<Dz11Profile>> getProfiles();

    @GET("data/people/{id}")
    Observable<Dz11Profile> getProfileById(@Path("id") String id);

    @PUT("data/people/{id}")
    Observable<Void> updateProfile(@Body Dz11Profile profile, @Path("id") String id);
}
