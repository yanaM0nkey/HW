package com.gmail.ioanna.myandroidapp.dz11;


import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.util.Log;

import com.gmail.ioanna.myandroidapp.base.BaseViewModel;
import com.gmail.ioanna.myandroidapp.domain.entity.Dz11ProfileModel;
import com.gmail.ioanna.myandroidapp.domain.interaction.Dz11GetProfileUseCase;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class Dz11_1ViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private Activity activity;

    private Dz11GetProfileUseCase getProfileUseCase = new Dz11GetProfileUseCase();

    public Dz11_1ViewModel(Activity activity) {
        this.activity = activity;
    }

    public ProfileAdapter adapter = new ProfileAdapter(activity);

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        getProfileUseCase.execute(null, new DisposableObserver<List<Dz11ProfileModel>>() {
            @Override
            public void onNext(@io.reactivex.annotations.NonNull List<Dz11ProfileModel> profileModels) {
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
