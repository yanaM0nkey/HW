package com.gmail.ioanna.myandroidapp.classwork12;


import android.databinding.ObservableField;

import com.gmail.ioanna.myandroidapp.base.BaseItemViewModel;
import com.gmail.ioanna.myandroidapp.domain.entity.ProfileModel;

public class ProfileItemViewModel extends BaseItemViewModel<ProfileModel>{

    public ObservableField<String> name = new ObservableField<>("");

    @Override
    public void setItem(ProfileModel item, int position) {
        name.set(item.getName());
    }
}
