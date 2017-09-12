package com.gmail.ioanna.myandroidapp.dz11;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gmail.ioanna.myandroidapp.base.BaseAdapter;
import com.gmail.ioanna.myandroidapp.base.BaseItemViewHolder;
import com.gmail.ioanna.myandroidapp.data.entity.Profile;
import com.gmail.ioanna.myandroidapp.domain.entity.Dz11ProfileModel;

public class ProfileAdapter extends BaseAdapter<Dz11ProfileModel, ProfileItemViewModel> {

    Activity activity;
    ProfileItemViewModel itemViewModel;

    public ProfileAdapter(Activity activity) {
        this.activity = activity;

    }

    @Override
    public BaseItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemViewModel = new ProfileItemViewModel(activity);
        return ProfileItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }

}
