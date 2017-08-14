package com.gmail.ioanna.myandroidapp.classwork9;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gmail.ioanna.myandroidapp.R;
import com.gmail.ioanna.myandroidapp.base.BaseActivity;
import com.gmail.ioanna.myandroidapp.classwork9.Classwork9Activity;
import com.gmail.ioanna.myandroidapp.classwork9.Classwork9ViewModel;
import com.gmail.ioanna.myandroidapp.databinding.ActivityClasswork9Binding;


public class Classwork9Activity extends BaseActivity {
    public static void show(Activity activity){
        Intent intent = new Intent(activity, Classwork9Activity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        Classwork9ViewModel viewModel = new Classwork9ViewModel();
        this.viewModel = viewModel;

        ActivityClasswork9Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_classwork9);
        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);

    }
}
