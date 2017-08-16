package com.gmail.ioanna.myandroidapp.classwork9;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.gmail.ioanna.myandroidapp.base.BaseViewModel;
import com.gmail.ioanna.myandroidapp.domain.entity.ProfileModel;
import com.gmail.ioanna.myandroidapp.domain.entity.ProfileId;
import com.gmail.ioanna.myandroidapp.domain.interaction.ProfileUseCase;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.PublishSubject;


public class Classwork9ViewModel implements BaseViewModel {


    public PublishSubject<String> publishSubject =PublishSubject.create();
    public enum STATE{PROGRESS, DATA}

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> surname = new ObservableField<>("");
    public ObservableInt age = new ObservableInt();
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private ProfileUseCase useCase = new ProfileUseCase();



    @Override
    public void init() {

    }

    @Override
    public void release() {


    }

    @Override
    public void resume() {
        ProfileId profileId = new ProfileId();
        profileId.setId("123");
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

    }
}
