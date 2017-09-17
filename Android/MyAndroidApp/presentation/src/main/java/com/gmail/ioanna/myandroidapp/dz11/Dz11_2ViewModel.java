package com.gmail.ioanna.myandroidapp.dz11;


import android.app.Activity;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.gmail.ioanna.myandroidapp.base.BaseViewModel;
import com.gmail.ioanna.myandroidapp.domain.entity.Dz11ProfileId;
import com.gmail.ioanna.myandroidapp.domain.entity.Dz11ProfileModel;
import com.gmail.ioanna.myandroidapp.domain.interaction.Dz11GetProfileUseCaseById;

import io.reactivex.observers.DisposableObserver;

public class Dz11_2ViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> surname = new ObservableField<>();
    public ObservableField<String> country = new ObservableField<>();
    public ObservableField<String> age = new ObservableField<>();

    private Activity activity;
    private String id;

    private Dz11GetProfileUseCaseById getProfileUseCase = new Dz11GetProfileUseCaseById();
    private Dz11ProfileId profileId;


    public Dz11_2ViewModel(Activity activity, String id) {
        this.id = id;
        this.activity = activity;
        profileId = new Dz11ProfileId();
        profileId.setId(id);
    }

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        Log.e("AAAbbbb", "resume()" + profileId.getId());
        getProfileUseCase.execute(profileId, new DisposableObserver<Dz11ProfileModel>() {
            @Override
            public void onNext(@io.reactivex.annotations.NonNull Dz11ProfileModel profileModel) {
                state.set(STATE.DATA);
                name.set("Name: " + profileModel.getName());
                surname.set("Surname: " + profileModel.getSurname());
                age.set("Age: " + String.valueOf(profileModel.getAge()));
                country.set("Country: " + profileModel.getCountry());
                Log.e("name", name.toString());
                Log.e("country", country.toString());
            }

            @Override
            public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                Log.e("AAAAA", "error = " +e.toString());
            }

            @Override
            public void onComplete() {


            }
        });

    }

    @Override
    public void pause() {
        getProfileUseCase.dispose();
    }
}
