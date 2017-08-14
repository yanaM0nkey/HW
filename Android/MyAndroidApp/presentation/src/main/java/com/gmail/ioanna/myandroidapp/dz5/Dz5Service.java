package com.gmail.ioanna.myandroidapp.dz5;

import android.app.IntentService;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.gmail.ioanna.myandroidapp.classwork5.Classwork5Activity;
import com.gmail.ioanna.myandroidapp.classwork5.MyIntentService;


public class Dz5Service extends Service {
    public static final String KEY_ACTION = "KEY_ACTION";

    public static final String MY_ACTION = "com.gmail.ioanna.myandroidapp.dz5.MY_ACTION";

    private static String status;

    public BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("SERVICE BROADCAST", "onRecieve");
            ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = cm.getActiveNetworkInfo();
            Intent intent1 = new Intent(MY_ACTION);
            if(info != null && info.isConnected()){
                status = "on";
                intent1.putExtra(KEY_ACTION, status);
                sendBroadcast(intent1);
                Log.e("WI-FI", "ON");
            }else{
                status = "off";
                intent1.putExtra(KEY_ACTION, status);
                sendBroadcast(intent1);
                Log.e("WI-FI", "OFF");
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
       // intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver,intentFilter);
        Log.e("SERVICE", "CREATE");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        Log.e("SERVICE", "DESTROY");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
