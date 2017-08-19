package com.gmail.ioanna.myandroidapp.dz9;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gmail.ioanna.myandroidapp.base.BaseItemViewHolder;
import com.gmail.ioanna.myandroidapp.databinding.ItemNewRecycleViewBinding;
import com.gmail.ioanna.myandroidapp.domain.entity.Dz9ProfileModel;

public class ProfileItemViewHolder extends BaseItemViewHolder<Dz9ProfileModel,
        ProfileItemViewModel, ItemNewRecycleViewBinding> {


    public ProfileItemViewHolder(ItemNewRecycleViewBinding dataBinding, ProfileItemViewModel viewModel) {
        super(dataBinding, viewModel);
        dataBinding.setViewModel(viewModel);
    }

    public static ProfileItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                               ProfileItemViewModel viewModel){
        ItemNewRecycleViewBinding binding = ItemNewRecycleViewBinding.inflate(inflater,parent,false);
        return new ProfileItemViewHolder(binding, viewModel);
    }
}

