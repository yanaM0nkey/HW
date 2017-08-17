package com.gmail.ioanna.myandroidapp.dz7;


import android.app.Activity;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.gmail.ioanna.myandroidapp.R;
import com.gmail.ioanna.myandroidapp.databinding.ActivityDz7Binding;
import com.gmail.ioanna.myandroidapp.domain.entity.ProfileModel;
import com.squareup.picasso.Picasso;

public class Dz7Activity extends Activity{

    public String name = "name: ";
    public String surname = "surname: ";
    public String age = "age: ";
    public String gender = "gender: ";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDz7Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_dz7);
        User user = new User("Name", "Surname", 20, "female");
        binding.setActivity(this);
        binding.setUser(user);
        binding.setViewModel(new ProfileViewModel());
    }
}

