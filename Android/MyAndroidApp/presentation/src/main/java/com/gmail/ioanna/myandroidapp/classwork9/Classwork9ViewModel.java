package com.gmail.ioanna.myandroidapp.classwork9;


import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.gmail.ioanna.myandroidapp.base.BaseViewModel;
import com.gmail.ioanna.myandroidapp.domain.entity.ProfilId;
import com.gmail.ioanna.myandroidapp.domain.entity.ProfileModel;
import com.gmail.ioanna.myandroidapp.domain.interaction.old.ProfileUseCase;
import com.gmail.ioanna.myandroidapp.domain.interaction.old.SaveProfileUseCase;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class Classwork9ViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> surname = new ObservableField<>("");
    public ObservableInt age = new ObservableInt(0);
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private ProfileUseCase useCase = new ProfileUseCase();

    private SaveProfileUseCase saveProfileUseCase = new SaveProfileUseCase();

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

        ProfileModel profileModel = new ProfileModel();
        profileModel.setAge(27);
        profileModel.setName("New name");
        profileModel.setSurname("New surname");
        saveProfileUseCase.execute(profileModel, new DisposableObserver<Void>() {
            @Override
            public void onNext(@NonNull Void aVoid) {
                Log.e("AAA", "OK");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAA", "error = ", e);
            }

            @Override
            public void onComplete() {}
        });



        ProfilId profileId = new ProfilId();
        profileId.setId("123"); // это для теста, как будто у нас есть id пользователя
        useCase.execute(profileId, new DisposableObserver<ProfileModel>() {
            @Override
            public void onNext(@NonNull ProfileModel profile) {
                name.set(profile.getName());
                surname.set(profile.getSurname());
                age.set(profile.getAge());
                state.set(STATE.DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAA", "error = ", e);
            }

            @Override
            public void onComplete() {
            }
        });

    }

    @Override
    public void pause() {
        useCase.dispose();
        saveProfileUseCase.dispose();

    }
}
