package com.gmail.ioanna.myandroidapp.dz14;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;

import com.gmail.ioanna.myandroidapp.base.BaseViewModel;
import com.gmail.ioanna.myandroidapp.domain.entity.Dz14Country;
import com.gmail.ioanna.myandroidapp.domain.interaction.Dz14GetCountriesFromJson;

import java.util.ArrayList;

public class Dz14ViewModel implements BaseViewModel, AdapterView.OnItemSelectedListener {

    Activity activity;
    private static final String COUNTRY = "COUNTRY";
    private static final String COUNTRY_KEY = "KEY";

    public int countryListSelectedPosition = 0;
    private ArrayList<Dz14Country> countries;

    SpinnerAdapter adapter;

    SharedPreferences preferences;

    public Dz14ViewModel(Activity activity) {
        this.activity = activity;
        countries = new Dz14GetCountriesFromJson().execute(activity);
        adapter = new Dz14SpinnerAdapter(countries);
        preferences = activity.getSharedPreferences(COUNTRY, Context.MODE_PRIVATE);
        String countryCode = preferences.getString(COUNTRY_KEY, null);
        countryListSelectedPosition = findCountryIndexByCode(countryCode);
    }

    @Override
    public void init() {}

    @Override
    public void resume() {}

    @Override
    public void pause() {
        preferences.edit()
                .putString(COUNTRY_KEY, countries.get(countryListSelectedPosition).getCode())
                .apply();
    }

    @Override
    public void release() {}

    public int findCountryIndexByCode(String code) {
        if (null == code) return 0;
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getCode().equals(code)) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        countryListSelectedPosition = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

}
