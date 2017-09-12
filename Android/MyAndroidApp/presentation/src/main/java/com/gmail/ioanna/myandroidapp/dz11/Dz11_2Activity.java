package com.gmail.ioanna.myandroidapp.dz11;


import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.gmail.ioanna.myandroidapp.R;
import com.gmail.ioanna.myandroidapp.base.BaseActivity;
import com.gmail.ioanna.myandroidapp.databinding.ActivityDz112Binding;

public class Dz11_2Activity extends BaseActivity {

    /*public static void show(Activity activity) {
        Intent intent = new Intent(activity, Dz11_2Activity.class);
        activity.startActivity(intent);
    }*/

    public void onCreate(@Nullable Bundle savedInstanceState) {
        String id = getIntent().getExtras().getString("id");
        Dz11_2ViewModel viewModel = new Dz11_2ViewModel(this, id);
        this.viewModel = viewModel;
        ActivityDz112Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_dz11_2);
        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);
        Log.e("AAA", "onCreate" + id);
    }
}
