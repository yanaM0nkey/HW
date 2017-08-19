package com.gmail.ioanna.myandroidapp.classwork12;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gmail.ioanna.myandroidapp.base.BaseItemViewHolder;
import com.gmail.ioanna.myandroidapp.databinding.ItemProfileBinding;
import com.gmail.ioanna.myandroidapp.domain.entity.ProfileModel;


public class ProfileItemViewHolder extends BaseItemViewHolder<ProfileModel,
        ProfileItemViewModel, ItemProfileBinding> {

    public ProfileItemViewHolder(ItemProfileBinding dataBinding, ProfileItemViewModel viewModel) {
        super(dataBinding, viewModel);
        dataBinding.setViewModel(viewModel);
    }

    public static ProfileItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                               ProfileItemViewModel viewModel){
        ItemProfileBinding binding = ItemProfileBinding.inflate(inflater,parent,false);
        return new ProfileItemViewHolder(binding, viewModel);
    }
}
