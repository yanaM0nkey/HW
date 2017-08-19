package com.gmail.ioanna.myandroidapp.classwork12;


import android.app.Activity;
import android.databinding.ObservableField;
import android.util.Log;


import com.gmail.ioanna.myandroidapp.base.BaseViewModel;
import com.gmail.ioanna.myandroidapp.domain.entity.ProfileModel;
import com.gmail.ioanna.myandroidapp.domain.interaction.GetProfileUseCase;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;


public class Classwork12ViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private Activity activity;

    private GetProfileUseCase getProfileUseCase = new GetProfileUseCase();

    public ProfileAdapter adapter = new ProfileAdapter();

    public Classwork12ViewModel(Activity activity){
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
        getProfileUseCase.execute(null, new DisposableObserver<List<ProfileModel>>() {
            @Override
            public void onNext(@NonNull List<ProfileModel> profileModels) {
                adapter.setItems(profileModels);
                state.set(STATE.DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) {
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
        //getProfileUseCase.dispose();

    }
}
