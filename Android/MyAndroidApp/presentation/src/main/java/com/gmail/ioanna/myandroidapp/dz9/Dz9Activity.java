package com.gmail.ioanna.myandroidapp.dz9;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.gmail.ioanna.myandroidapp.R;
import com.gmail.ioanna.myandroidapp.base.BaseActivity;
import com.gmail.ioanna.myandroidapp.databinding.ActivityDz9Binding;


public class Dz9Activity extends BaseActivity {

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Dz9Activity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        Dz9ViewModel viewModel = new Dz9ViewModel(this);
        this.viewModel = viewModel;
        ActivityDz9Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_dz9);

        binding.setModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(viewModel.adapter);

        super.onCreate(savedInstanceState);
    }
}
