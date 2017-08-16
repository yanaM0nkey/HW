package com.gmail.ioanna.myandroidapp.dz6;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.gmail.ioanna.myandroidapp.R;
import com.gmail.ioanna.myandroidapp.classwork6.Classwork6Adapter;

import java.util.ArrayList;


public class Dz6Activity extends Activity {

    private RecyclerView recyclerView;
    private ArrayList<String> stringArrayList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz6);
        stringArrayList.add("http://dreempics.com/img/picture/Jun/04/58f589f7a94f77e32c94a55ad4cf23de/2.jpg");
        stringArrayList.add("http://fotohomka.ru/images/Nov/02/b8e19d2c2015845f5b509c837eae967e/mini_5.jpg");
        stringArrayList.add("http://img.izhlife.ru/posts/newsimg/imgs-117967.ru-Despicable-Me-2-2183494.jpg");
        stringArrayList.add("http://zainetom.ru/wp-content/uploads/2015/11/113.jpg");
        stringArrayList.add("http://cs619118.vk.me/v619118754/19564/m8yp5t8CI7U.jpg");
        stringArrayList.add("http://www.fullhdoboi.com/wallpapers/thumbs/6/kartinka-apelsiny-1885.jpg");

        recyclerView = (RecyclerView) findViewById(R.id.dz6_recyclerView);

        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        GridLayoutManager manager = new GridLayoutManager(this, 3);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (3 - position % 3);
            }
        });
        recyclerView.setLayoutManager(manager);

        //recyclerView.setLayoutManager(layoutManager);

        Dz6Adapter adapter = new Dz6Adapter(stringArrayList);
        adapter.setListener(new Dz6Adapter.OnItemClickListener(){
            @Override
            public void onItemClick(String item){
                Log.e("AAA", "onItemClick" + item);
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
