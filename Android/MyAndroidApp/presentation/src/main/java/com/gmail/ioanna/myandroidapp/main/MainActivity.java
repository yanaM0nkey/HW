package com.gmail.ioanna.myandroidapp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.gmail.ioanna.myandroidapp.R;
import com.gmail.ioanna.myandroidapp.classwork12.Classwork12Activity;
import com.gmail.ioanna.myandroidapp.classwork13.Classwork13Activity;
import com.gmail.ioanna.myandroidapp.classwork14.Classwork14Activity;
import com.gmail.ioanna.myandroidapp.classwork16.Classwork16Activity;
import com.gmail.ioanna.myandroidapp.classwork18.Classwork18Activity;
import com.gmail.ioanna.myandroidapp.classwork2.Classwork2Activity;
import com.gmail.ioanna.myandroidapp.classwork21.RegisterActivity;
import com.gmail.ioanna.myandroidapp.classwork3.Classwork3Activity;
import com.gmail.ioanna.myandroidapp.classwork4.Classwork4Activity;
import com.gmail.ioanna.myandroidapp.classwork5.Classwork5Activity;
import com.gmail.ioanna.myandroidapp.classwork6.Classwork6Activity;
import com.gmail.ioanna.myandroidapp.classwork7.Classwork7Activity;
import com.gmail.ioanna.myandroidapp.classwork8.Classwork8Activity;
import com.gmail.ioanna.myandroidapp.classwork9.Classwork9Activity;
import com.gmail.ioanna.myandroidapp.dz1.Dz1Activity;
import com.gmail.ioanna.myandroidapp.dz10.Dz10Activity;
import com.gmail.ioanna.myandroidapp.dz11.Dz11_1Activity;
import com.gmail.ioanna.myandroidapp.dz2.Dz2Activity;
import com.gmail.ioanna.myandroidapp.dz3.Dz3Activity;
import com.gmail.ioanna.myandroidapp.dz4.Dz4Activity;
import com.gmail.ioanna.myandroidapp.dz5.Dz5Activity;
import com.gmail.ioanna.myandroidapp.dz6.Dz6Activity;
import com.gmail.ioanna.myandroidapp.dz7.Dz7Activity;
import com.gmail.ioanna.myandroidapp.dz9.Dz9Activity;


public class MainActivity extends Activity {


  //  public PublishSubject<String> publishSubject =PublishSubject.create();

    //public BehaviorSubject<String> behaviorSubject =BehaviorSubject.create();
    //public ReplaySubject<String> replaySubject =ReplaySubject.create();

    //Disposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*replaySubject.onNext("One");
        replaySubject.onNext("Two");
        replaySubject.onNext("Three");
        replaySubject.onNext("Four");
        replaySubject.onNext("Five");
        disposable = replaySubject.subscribeWith(new DisposableObserver<String>() {
            @Override
            public void onNext(@NonNull String s) {
                Log.e("AAAA",s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


        replaySubject.onNext("Four");
        replaySubject.onNext("Five");*/





        Button dz1Button = (Button) findViewById(R.id.dz1Button);
        dz1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Dz1Activity.class);
                startActivity(intent);
            }
        });

        Button dz2Button = (Button) findViewById(R.id.dz2Button);
        dz2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Dz2Activity.class);
                startActivity(intent);
            }
        });

        Button dz3Button = (Button) findViewById(R.id.dz3Button);
        dz3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Dz3Activity.class);
                startActivity(intent);
            }
        });

        Button dz4Button = (Button) findViewById(R.id.dz4Button);
        dz4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Dz4Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha);
            }
        });

        Button dz5Button = (Button) findViewById(R.id.dz5Button);
        dz5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Dz5Activity.class);
                startActivity(intent);
            }
        });

        Button dz6Button = (Button) findViewById(R.id.dz6Button);
        dz6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Dz6Activity.class);
                startActivity(intent);
            }
        });

        Button dz7Button = (Button) findViewById(R.id.dz7Button);
        dz7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Dz7Activity.class);
                startActivity(intent);
            }
        });

        //заменена 9ая кнопка
        Button dz9Button = (Button) findViewById(R.id.dz9Button);
        dz9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterActivity.show(MainActivity.this);
            }
        });

        Button dz10Button = (Button) findViewById(R.id.dz10Button);
        dz10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dz10Activity.show(MainActivity.this);
            }
        });

        Button dz11Button = (Button) findViewById(R.id.dz11Button);
        dz11Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dz11_1Activity.show(MainActivity.this);
            }
        });





        Button classwork2Button = (Button) findViewById(R.id.classWork2Button);
        classwork2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Classwork2Activity.class);
                startActivity(intent);
            }
        });

        Button classwork3Button = (Button) findViewById(R.id.classWork3Button);
        classwork3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Classwork3Activity.class);
                startActivity(intent);
            }
        });

        Button classwork4Button = (Button) findViewById(R.id.classWork4Button);
        classwork4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Classwork4Activity.class);
                startActivity(intent);
            }
        });

        Button classwork5Button = (Button) findViewById(R.id.classWork5Button);
        classwork5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Classwork5Activity.class);
                startActivity(intent);
            }
        });

        Button classwork6Button = (Button) findViewById(R.id.classWork6Button);
        classwork6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Classwork6Activity.class);
                startActivity(intent);
            }
        });

        Button classwork7Button = (Button) findViewById(R.id.classWork7Button);
        classwork7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Classwork7Activity.class);
                startActivity(intent);
            }
        });

        Button classwork8Button = (Button) findViewById(R.id.classWork8Button);
        classwork8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Classwork8Activity.class);
                startActivity(intent);
            }
        });

        Button classwork9Button = (Button) findViewById(R.id.classWork9Button);
        classwork9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Classwork9Activity.show(MainActivity.this);
            }
        });

        Button classwork12Button = (Button) findViewById(R.id.classWork12Button);
        classwork12Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Classwork12Activity.show(MainActivity.this);
            }
        });

        Button classwork13Button = (Button) findViewById(R.id.classWork13Button);
        classwork13Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Classwork13Activity.show(MainActivity.this);
            }
        });

        Button classwork14Button = (Button) findViewById(R.id.classWork14Button);
        classwork14Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Classwork14Activity.show(MainActivity.this);
            }
        });

        Button classwork16Button = (Button) findViewById(R.id.classWork16Button);
        classwork16Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Classwork16Activity.show(MainActivity.this);
            }
        });

        Button classwork18Button = (Button) findViewById(R.id.classWork18Button);
        classwork18Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Classwork18Activity.show(MainActivity.this);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}