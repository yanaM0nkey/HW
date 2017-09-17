package com.gmail.ioanna.myandroidapp.classwork18;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.gmail.ioanna.myandroidapp.R;

public class Classwork18Activity extends AppCompatActivity {

    //View view;
    //Button button1;
    //Button button2;

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, Classwork18Activity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork18);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.owl);


       // view = findViewById(R.id.classWork18View);
        //button1 = (Button) findViewById(R.id.classWork18Button1);
        //button2 = (Button) findViewById(R.id.classWork18Button2);

        //final View viewRoot = findViewById(R.id.root);

        //view.setVisibility(View.VISIBLE);
        //view.bringToFront();
        //button1.bringToFront();
        //viewRoot.requestLayout();

        /*button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                button2.getParent().bringChildToFront(button2);
                view.bringToFront();
                button2.bringToFront();
                viewRoot.requestLayout();

            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.classwork18_menu, menu );
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
