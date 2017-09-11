package com.gmail.ioanna.myandroidapp.classwork16;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gmail.ioanna.myandroidapp.R;
import com.gmail.ioanna.myandroidapp.classwork16.Classwork16Activity;

import io.realm.Realm;


public class Classwork16Activity extends FragmentActivity {

    private Realm realm;
    private EditText editText;
    private Button button;
    private UserDb user;

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Classwork16Activity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork16);
        editText = (EditText)findViewById(R.id.classwork16_editText);
        button = (Button) findViewById(R.id.classwork16_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        realm = Realm.getDefaultInstance();
        loadData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(user != null)
            user.removeAllChangeListeners();
        realm.close();
    }

    private void saveData(){

        if(user == null){
            user = realm.createObject(UserDb.class);
            realm.beginTransaction();
            user.setId(10);
            realm.commitTransaction();
        }

        realm.beginTransaction();
        user.setName(String.valueOf(editText.getText()));
        realm.commitTransaction();
    }

    private void loadData(){

        user = realm.where(UserDb.class)
                .equalTo("id", 10)
                .findFirst();

        if(user != null){
            editText.setText(user.getName());
        }

    }
}
