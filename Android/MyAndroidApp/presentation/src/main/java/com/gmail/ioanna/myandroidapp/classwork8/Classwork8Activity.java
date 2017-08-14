package com.gmail.ioanna.myandroidapp.classwork8;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.gmail.ioanna.myandroidapp.R;
import com.gmail.ioanna.myandroidapp.base.BaseActivity;
import com.gmail.ioanna.myandroidapp.databinding.ActivityClasswork8Binding;



public class Classwork8Activity extends BaseActivity {

    public static void show(Activity activity){
        Intent intent = new Intent(activity, Classwork8Activity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


        Classwork8ViewModel viewModel = new Classwork8ViewModel(this);
        this.viewModel = viewModel;

        ActivityClasswork8Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_classwork8);
        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);

    }
}
