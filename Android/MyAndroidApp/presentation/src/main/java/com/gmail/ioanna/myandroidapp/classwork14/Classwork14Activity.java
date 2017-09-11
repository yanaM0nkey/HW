package com.gmail.ioanna.myandroidapp.classwork14;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gmail.ioanna.myandroidapp.R;
import com.gmail.ioanna.myandroidapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Classwork14Activity extends Activity {

    @BindView(R.id.classwork14_editText)
    EditText editText;

    @BindView(R.id.classwork14_button)
    Button button;

    SharedPreferences preferences;
    private static final String SHARED_PREFER_NAME = "klmmkm";
    private static final String KEY = "KEY_NAME";

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Classwork14Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork14);
        ButterKnife.bind(this);


        //сохраняем текст
        preferences = getSharedPreferences(SHARED_PREFER_NAME, Context.MODE_PRIVATE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences.edit()
                        .putString(KEY, String.valueOf(editText.getText()))
                        .apply();
            }
        });

        //берем текст
        String data = preferences.getString(KEY, null);
        if(data != null) editText.setText(data);


    }
}
