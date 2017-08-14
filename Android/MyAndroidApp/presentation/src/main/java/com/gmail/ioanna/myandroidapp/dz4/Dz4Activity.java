package com.gmail.ioanna.myandroidapp.dz4;


import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.gmail.ioanna.myandroidapp.R;

public class Dz4Activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz4);
        ImageView image = (ImageView)findViewById(R.id.owlImageView);
        image.setBackgroundResource(R.drawable.owl);
        AnimationDrawable animation = (AnimationDrawable)image.getBackground();
        animation.start();
    }
}
