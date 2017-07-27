package com.gmail.ioanna.myapp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.gmail.ioanna.myapp.R;
import com.gmail.ioanna.myapp.classwork2.Classwork2Activity;
import com.gmail.ioanna.myapp.dz1.Dz1Activity;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button dz1Button = (Button) findViewById(R.id.dz1Button);
        dz1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Classwork2Activity.class);
                startActivity(intent);

            }
        });
    }
}
