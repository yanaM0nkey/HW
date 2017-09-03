package com.gmail.ioanna.myandroidapp.dz10;


import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gmail.ioanna.myandroidapp.R;
import com.gmail.ioanna.myandroidapp.base.BaseActivity;
import com.gmail.ioanna.myandroidapp.classwork9.Classwork9ViewModel;
import com.gmail.ioanna.myandroidapp.databinding.ActivityDz10Binding;

public class Dz10Activity extends BaseActivity {

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Dz10Activity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        Dz10ViewModel viewModel = new Dz10ViewModel();
        this.viewModel = viewModel;

        ActivityDz10Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_dz10);

        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);
    }
}
