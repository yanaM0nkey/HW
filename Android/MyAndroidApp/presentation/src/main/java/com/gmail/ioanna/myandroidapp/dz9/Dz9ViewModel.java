package com.gmail.ioanna.myandroidapp.dz9;


import android.app.Activity;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.gmail.ioanna.myandroidapp.base.BaseViewModel;
import com.gmail.ioanna.myandroidapp.classwork12.Classwork12ViewModel;
import com.gmail.ioanna.myandroidapp.domain.entity.Dz9ProfileModel;
import com.gmail.ioanna.myandroidapp.domain.entity.ProfileModel;
import com.gmail.ioanna.myandroidapp.domain.interaction.Dz9GetProfileUseCase;
import com.gmail.ioanna.myandroidapp.domain.interaction.GetProfileUseCase;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class Dz9ViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private Activity activity;

    private Dz9GetProfileUseCase getProfileUseCase = new Dz9GetProfileUseCase();

    public ProfileAdapter adapter = new ProfileAdapter();

    public Dz9ViewModel(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        getProfileUseCase.execute(null, new DisposableObserver<List<Dz9ProfileModel>>() {
            @Override
            public void onNext(@io.reactivex.annotations.NonNull List<Dz9ProfileModel> profileModels) {
                Log.e("AAA viw Model", "size = " + profileModels.size());



                adapter.setItems(profileModels);
                state.set(STATE.DATA);

                Log.e("AAA viw Model", "adapter size = " + adapter.getItemCount());

            }

            @Override
            public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                Log.e("AAAA items = ", e.toString());

            }

            @Override
            public void onComplete() {
                Log.e("AAAA item", "onComplete");

            }
        });

    }

    @Override
    public void pause() {

    }
}
