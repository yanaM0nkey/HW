package com.gmail.ioanna.myandroidapp.classwork13;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.gmail.ioanna.myandroidapp.R;
import com.gmail.ioanna.myandroidapp.base.BaseActivity;


public class Classwork13Activity extends FragmentActivity {

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Classwork13Activity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork13);

        if(savedInstanceState == null)
            showFragment(getSupportFragmentManager(), new Classwork13Fragment(),false);


        findViewById(R.id.classWork13Button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(getSupportFragmentManager(), Classwork13Fragment.newInstance(getSupportFragmentManager(),"nlskfnv"), true);
            }
        });

        findViewById(R.id.classWork13Button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(getSupportFragmentManager(), new Classwork13FragmentSecond(), true);


            }
        });
    }

    public static void showFragment(FragmentManager fragmentManager, Fragment fragment, boolean addToBack){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, fragment.getClass().getName());
        if(addToBack) fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


}
