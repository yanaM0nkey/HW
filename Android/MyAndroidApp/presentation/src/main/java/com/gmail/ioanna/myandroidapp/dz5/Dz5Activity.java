package com.gmail.ioanna.myandroidapp.dz5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.gmail.ioanna.myandroidapp.R;
import com.gmail.ioanna.myandroidapp.dz4.Dz4Activity;


public class Dz5Activity extends Activity {
    private TextView textView;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String text = intent.getStringExtra(Dz5Service.KEY_ACTION);
            textView.setText("wi-fi: " + text);
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz5);
        textView = (TextView) findViewById(R.id.dz5TextView);
        Intent intent = new Intent(this, Dz5Service.class);
        startService(intent);
        //textView.setText(intent.getStringExtra(Dz5Service.KEY_ACTION));
    }



    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(Dz5Service.MY_ACTION);
        registerReceiver(receiver,intentFilter);
        Log.e("ACTIVITY", "CREATE");

    }


    @Override
    protected void onStop() {
        super.onStop();
        Intent intent = new Intent(this, Dz5Service.class);
        stopService(intent);
        unregisterReceiver(receiver);
        Log.e("ACTIVITY", "DESTROY");
    }


}
