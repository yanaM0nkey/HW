package com.gmail.ioanna.myandroidapp.domain.interaction.old;

import com.gmail.ioanna.myandroidapp.data.entity.Profile;
import com.gmail.ioanna.myandroidapp.data.net.RestService;
import com.gmail.ioanna.myandroidapp.domain.entity.ProfileModel;
import com.gmail.ioanna.myandroidapp.domain.interaction.base.UseCase;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class SaveProfileUseCase extends UseCase<ProfileModel, Void> {
    @Override
    protected Observable<Void> buildUseCase(ProfileModel param) {

        Profile profileData = new Profile();
        profileData.setName(param.getName());
        profileData.setSurname(param.getSurname());
        profileData.setAge(param.getAge());

        return RestService.getInstance().saveProfile(profileData);
    }
}
