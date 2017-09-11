package com.gmail.ioanna.myandroidapp.dz11;


import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.gmail.ioanna.myandroidapp.R;
import com.gmail.ioanna.myandroidapp.base.BaseActivity;
import com.gmail.ioanna.myandroidapp.databinding.ActivityDz111Binding;

public class Dz11_1Activity extends BaseActivity {

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Dz11_1Activity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Dz11_1ViewModel viewModel = new Dz11_1ViewModel(this);
        this.viewModel = viewModel;
        ActivityDz111Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_dz11_1);

        binding.setModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(viewModel.adapter);
        super.onCreate(savedInstanceState);
    }
}
