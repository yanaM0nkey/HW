package com.gmail.ioanna.myandroidapp.dz14;


import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gmail.ioanna.myandroidapp.R;
import com.gmail.ioanna.myandroidapp.base.BaseActivity;
import com.gmail.ioanna.myandroidapp.databinding.ActivityDz14Binding;

public class Dz14Activity extends BaseActivity{

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Dz14Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ActivityDz14Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_dz14);

        Dz14ViewModel viewModel = new Dz14ViewModel(this);
        this.viewModel = viewModel;

        binding.spinner.setAdapter(viewModel.adapter);
        binding.spinner.setOnItemSelectedListener(viewModel);
        binding.spinner.setSelection(viewModel.countryListSelectedPosition);

        super.onCreate(savedInstanceState);
    }
}
