package com.gmail.ioanna.myandroidapp.dz10;


import android.content.Intent;
import android.databinding.ObservableField;
import android.util.Log;

import com.gmail.ioanna.myandroidapp.base.BaseViewModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;


public class Dz10ViewModel implements BaseViewModel {


    public Observable<Long> values = Observable.interval(1, TimeUnit.SECONDS);
    public ObservableField<Long> text = new ObservableField<>();
    DisposableObserver<Long> disposableObserver;
    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        disposableObserver = new DisposableObserver<Long>() {
            @Override
            public void onNext(@NonNull Long aLong) {
                Log.e("timer", aLong.toString());
                text.set(aLong);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        values.map(new Function<Long, Long>() {

            @Override
            public Long apply(@NonNull Long aLong) throws Exception {
                if(aLong % 2 == 0)
                 return aLong;
                return aLong-1;
            }
        })
                .subscribe(disposableObserver);
    }

    @Override
    public void pause() {
        disposableObserver.dispose();
    }
}
