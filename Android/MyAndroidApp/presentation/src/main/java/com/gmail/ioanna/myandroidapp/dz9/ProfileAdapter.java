package com.gmail.ioanna.myandroidapp.dz9;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gmail.ioanna.myandroidapp.base.BaseAdapter;
import com.gmail.ioanna.myandroidapp.base.BaseItemViewHolder;
import com.gmail.ioanna.myandroidapp.domain.entity.Dz9ProfileModel;
import com.gmail.ioanna.myandroidapp.dz9.ProfileItemViewModel;

public class ProfileAdapter extends BaseAdapter<Dz9ProfileModel, ProfileItemViewModel> {

    @Override
    public BaseItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ProfileItemViewModel itemViewModel = new ProfileItemViewModel();
        return ProfileItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }
}
