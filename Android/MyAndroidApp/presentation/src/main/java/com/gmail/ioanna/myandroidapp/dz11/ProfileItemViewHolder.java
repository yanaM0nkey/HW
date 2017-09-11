package com.gmail.ioanna.myandroidapp.dz11;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.ioanna.myandroidapp.base.BaseItemViewHolder;
import com.gmail.ioanna.myandroidapp.databinding.ItemDz11RecycleViewBinding;
import com.gmail.ioanna.myandroidapp.domain.entity.Dz11ProfileModel;

public class ProfileItemViewHolder extends BaseItemViewHolder<Dz11ProfileModel,
        ProfileItemViewModel, ItemDz11RecycleViewBinding> {


    public ProfileItemViewHolder(ItemDz11RecycleViewBinding dataBinding, ProfileItemViewModel viewModel) {
        super(dataBinding, viewModel);
        dataBinding.setViewModel(viewModel);
    }

    public static ProfileItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                               ProfileItemViewModel viewModel){
        ItemDz11RecycleViewBinding binding = ItemDz11RecycleViewBinding.inflate(inflater,parent,false);
        return new ProfileItemViewHolder(binding, viewModel);
    }

}
