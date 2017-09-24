package com.gmail.ioanna.myandroidapp.domain.interaction;


import com.gmail.ioanna.myandroidapp.data.entity.Dz11Profile;
import com.gmail.ioanna.myandroidapp.data.net.Dz11RestService;
import com.gmail.ioanna.myandroidapp.domain.entity.Dz11ProfileModel;
import com.gmail.ioanna.myandroidapp.domain.interaction.base.UseCase;

import io.reactivex.Observable;

public class Dz11UpdateProfileUseCase extends UseCase<Dz11ProfileModel, Void> {
    @Override
    protected Observable<Void> buildUseCase(Dz11ProfileModel param) {

        Dz11Profile profileData = new Dz11Profile();
        profileData.setName(param.getName());
        profileData.setSurname(param.getSurname());
        profileData.setCountry(param.getCountry());
        profileData.setAge(param.getAge());
        profileData.setId(param.getId());

        return Dz11RestService.getInstance().updateProfile(profileData);
    }
}
