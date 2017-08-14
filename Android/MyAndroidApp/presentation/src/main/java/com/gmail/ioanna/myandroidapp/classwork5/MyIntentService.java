package com.gmail.ioanna.myandroidapp.classwork5;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;



public class MyIntentService extends IntentService {

    public static final String KEY_ACTION = "KEY_ACTION";

    public static final String MY_ACTION = "com.gmail.ioanna.myandroidapp.classwork5.MY_ACTION";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String action = intent.getStringExtra(KEY_ACTION);

        Log.e("AAA", "onHandleIntent action = " + action);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent intentReceive = new Intent(MY_ACTION);
        sendBroadcast(intentReceive);

    }


}
