package com.gmail.ioanna.myandroidapp.dz1;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.gmail.ioanna.myandroidapp.R;

public class Dz1Activity extends Activity /*implements View.OnClickListener*/ {

    public static final String KEY_USERNAME = "KEY_USERNAME";
    public static final String KEY_PASSWORD = "KEY_PASSWORD";
    private Button changeButton;
    private TextView textView1;
    private TextView textView2;
    private String temp;
    private int i;

    //второй способ
    /*private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            temp = (String) textView1.getText();
            textView1.setText(textView2.getText().toString());
            textView2.setText(temp);
        }
    };*/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz1);
        Log.d("Dz1Activity", "onCreate()");


        String username = getIntent().getStringExtra(KEY_USERNAME);
        String password = getIntent().getStringExtra(KEY_PASSWORD);
        //из-за того что добавили classwork2
        if (username == null){
            username = "null 1";
            password = "null 2";
        }


        changeButton = (Button)findViewById(R.id.change_button);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        textView1.setText(username);
        textView2.setText(password);
        //первый способ
        //changeButton.setOnClickListener(this);

        //changeButton.setOnClickListener(listener);  //второй способ
        // третий способ
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = (String) textView1.getText();
                textView1.setText(textView2.getText().toString());
                textView2.setText(temp);
                i++;
                changeButton.setText("Button" + i);
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = (String) textView1.getText();
                textView1.setText(textView2.getText().toString());
                textView2.setText(temp);
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = (String) textView1.getText();
                textView1.setText(textView2.getText().toString());
                textView2.setText(temp);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    //первый способ
   /* @Override
    public void onClick(View view) {
        temp = (String) textView1.getText();
        textView1.setText(textView2.getText().toString());
        textView2.setText(temp);
        i++;
        changeButton.setText("Button" + i);
    }*/
}
