package com.gmail.ioanna.myandroidapp.dz11;


import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.util.Log;

import com.gmail.ioanna.myandroidapp.base.BaseViewModel;
import com.gmail.ioanna.myandroidapp.domain.entity.Dz11ProfileId;
import com.gmail.ioanna.myandroidapp.domain.entity.Dz11ProfileModel;
import com.gmail.ioanna.myandroidapp.domain.interaction.Dz11GetProfileUseCaseById;
import com.gmail.ioanna.myandroidapp.domain.interaction.Dz11UpdateProfileUseCase;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class Dz11_3ViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}

    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> surname = new ObservableField<>();
    public ObservableField<String> country = new ObservableField<>();
    public ObservableField<String> age = new ObservableField<>();

    private Activity activity;
    private String id;

    private Dz11GetProfileUseCaseById getProfileUseCase = new Dz11GetProfileUseCaseById();
    private Dz11UpdateProfileUseCase updateProfileUseCase = new Dz11UpdateProfileUseCase();
    private Dz11ProfileId profileId;


    public Dz11_3ViewModel(Activity activity, String id) {
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
                name.set(profileModel.getName());
                surname.set(profileModel.getSurname());
                age.set(String.valueOf(profileModel.getAge()));
                country.set(profileModel.getCountry());
                Log.e("name", name.toString());
                Log.e("country", country.toString());
            }

            @Override
            public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                Log.e("AAAAA", "error = " +e.toString());
            }

            @Override
            public void onComplete() {}
        });

    }

    @Override
    public void pause() {
        getProfileUseCase.dispose();
        //updateProfileUseCase.dispose();
    }

    public void onButtonClick(){
        Log.e("Click", "ok");

        Dz11ProfileModel profileModel = new Dz11ProfileModel();
        profileModel.setId(id);
        profileModel.setName(name.get());
        profileModel.setSurname(surname.get());
        profileModel.setCountry(country.get());
        profileModel.setAge(Integer.valueOf(age.get()));

        updateProfileUseCase.execute(profileModel, new DisposableObserver<Void>() {
            @Override
            public void onNext(@NonNull Void aVoid) {
                Log.e("update", "ok");

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {


            }
        });

        Intent intent = new Intent(activity, Dz11_1Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);


    }

}
