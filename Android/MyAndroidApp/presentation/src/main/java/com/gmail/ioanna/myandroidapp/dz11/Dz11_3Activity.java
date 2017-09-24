package com.gmail.ioanna.myandroidapp.dz11;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.gmail.ioanna.myandroidapp.R;
import com.gmail.ioanna.myandroidapp.base.BaseActivity;
import com.gmail.ioanna.myandroidapp.databinding.ActivityDz112Binding;
import com.gmail.ioanna.myandroidapp.databinding.ActivityDz113Binding;

public class Dz11_3Activity extends BaseActivity{

    public void onCreate(@Nullable Bundle savedInstanceState) {
        String id = getIntent().getExtras().getString("id");
        Dz11_3ViewModel viewModel = new Dz11_3ViewModel(this, id);
        this.viewModel = viewModel;
        ActivityDz113Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_dz11_3);
        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);
    }
}
