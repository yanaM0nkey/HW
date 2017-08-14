package com.gmail.ioanna.myandroidapp.classwork9;

import android.app.Activity;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.gmail.ioanna.myandroidapp.base.BaseViewModel;
import com.gmail.ioanna.myandroidapp.domain.entity.Profile;
import com.gmail.ioanna.myandroidapp.domain.entity.ProfileId;
import com.gmail.ioanna.myandroidapp.domain.interaction.ProfileUseCase;


public class Classwork9ViewModel implements BaseViewModel {

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
        Profile profile = useCase.execute(profileId);

        name.set(profile.getName());
        surname.set(profile.getSurname());
        age.set(profile.getAge());

        state.set(STATE.DATA);

    }

    @Override
    public void pause() {

    }
}
