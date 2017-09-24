package com.gmail.ioanna.myandroidapp.domain.interaction;


import android.app.Activity;
import android.util.Log;

import com.gmail.ioanna.myandroidapp.domain.entity.Dz14Country;
import com.gmail.ioanna.myandroidapp.domain.interaction.base.UseCaseJson;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Dz14GetCountriesFromJson implements UseCaseJson<Activity, Dz14Country> {
    @Override

    public ArrayList<Dz14Country> execute(Activity activity) {

        String json;

        try {
            InputStream stream = activity.getAssets().open("countries.json");
            Log.e("ex1", stream.toString());
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            Log.e("ex2", ex.toString());
            return null;
        }

        Dz14Country[] countries = new Gson().fromJson(json, Dz14Country[].class);
        return new ArrayList<>(Arrays.asList(countries));
    }
}
