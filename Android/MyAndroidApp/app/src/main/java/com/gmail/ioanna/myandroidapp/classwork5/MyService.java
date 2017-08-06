package com.gmail.ioanna.myandroidapp.classwork5;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;


public class MyService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("BBB", "onCreate()");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("AAAa", "onBind()");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("AAAa", "onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("AAAa", "onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("BBB", "onDestroy()");
    }
}
