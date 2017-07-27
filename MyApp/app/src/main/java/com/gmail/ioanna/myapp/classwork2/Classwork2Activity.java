package com.gmail.ioanna.myapp.classwork2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gmail.ioanna.myapp.R;
import com.gmail.ioanna.myapp.dz1.Dz1Activity;
import com.gmail.ioanna.myapp.main.MainActivity;


public class Classwork2Activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork2);
        final EditText username = (EditText) findViewById(R.id.loginText);
        final EditText password = (EditText) findViewById(R.id.passwordText);
        Button loginButton = (Button) findViewById(R.id.class2LoginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Classwork2Activity.this, Dz1Activity.class);
                intent.putExtra(Dz1Activity.KEY_USERNAME, username.getText());
                intent.putExtra(Dz1Activity.KEY_PASSWORD, password.getText());
                startActivity(intent);

            }
        });
    }
}
