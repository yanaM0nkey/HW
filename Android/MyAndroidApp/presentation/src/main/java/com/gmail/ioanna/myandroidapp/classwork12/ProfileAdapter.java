package com.gmail.ioanna.myandroidapp.classwork12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gmail.ioanna.myandroidapp.base.BaseAdapter;
import com.gmail.ioanna.myandroidapp.base.BaseItemViewHolder;
import com.gmail.ioanna.myandroidapp.domain.entity.ProfileModel;
import com.gmail.ioanna.myandroidapp.dz7.ProfileViewModel;

public class ProfileAdapter extends BaseAdapter<ProfileModel,ProfileItemViewModel> {



    @Override
    public BaseItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ProfileItemViewModel itemViewModel = new ProfileItemViewModel();
        return ProfileItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }
}
