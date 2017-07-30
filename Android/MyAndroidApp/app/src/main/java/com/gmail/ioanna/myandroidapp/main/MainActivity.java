package com.gmail.ioanna.myandroidapp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.gmail.ioanna.myandroidapp.R;
import com.gmail.ioanna.myandroidapp.classwork2.Classwork2Activity;
import com.gmail.ioanna.myandroidapp.classwork3.Classwork3Activity;
import com.gmail.ioanna.myandroidapp.dz1.Dz1Activity;
import com.gmail.ioanna.myandroidapp.dz2.Dz2Activity;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dz1Button = (Button) findViewById(R.id.dz1Button);
        dz1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Dz1Activity.class);
                startActivity(intent);
            }
        });

        Button dz2Button = (Button) findViewById(R.id.dz2Button);
        dz2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Dz2Activity.class);
                startActivity(intent);
            }
        });

        Button classwork2Button = (Button) findViewById(R.id.classWork2Button);
        classwork2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Classwork2Activity.class);
                startActivity(intent);
            }
        });

        Button classwork3Button = (Button) findViewById(R.id.classWork3Button);
        classwork3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Classwork3Activity.class);
                startActivity(intent);
            }
        });
    }
}