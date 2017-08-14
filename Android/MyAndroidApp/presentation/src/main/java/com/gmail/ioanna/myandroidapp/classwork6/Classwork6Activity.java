package com.gmail.ioanna.myandroidapp.classwork6;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.gmail.ioanna.myandroidapp.R;

import java.util.ArrayList;


public class Classwork6Activity extends Activity {
    private RecyclerView recyclerView;
    private ArrayList<String> stringArrayList = new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_classwork6);

        stringArrayList.add("Item 1");
        stringArrayList.add("Item 2");
        stringArrayList.add("Item 3");
        stringArrayList.add("Item 4");
        stringArrayList.add("Item 5");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        Classwork6Adapter adapter = new Classwork6Adapter(stringArrayList);
        adapter.setListener(new Classwork6Adapter.OnItemClickListener(){
            @Override
            public void onItemClick(String item){
                Log.e("AAA", "onItemClick" + item);
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
