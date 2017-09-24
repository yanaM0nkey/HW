package com.gmail.ioanna.myandroidapp.dz14;


import android.databinding.ObservableField;

import com.gmail.ioanna.myandroidapp.domain.entity.Dz14Country;

public class Dz14ItemViewModel  {

    public ObservableField<Dz14Country> country = new ObservableField<>();

    public Dz14ItemViewModel(Dz14Country country) {
        this.country.set(country);
    }

    public void setCountry(Dz14Country country) {
        this.country.set(country);
    }
}
