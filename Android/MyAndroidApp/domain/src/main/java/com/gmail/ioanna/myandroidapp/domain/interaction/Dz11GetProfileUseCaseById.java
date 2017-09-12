package com.gmail.ioanna.myandroidapp.domain.interaction;

import android.util.Log;

import com.gmail.ioanna.myandroidapp.data.entity.Dz11Profile;
import com.gmail.ioanna.myandroidapp.data.net.Dz11RestService;
import com.gmail.ioanna.myandroidapp.domain.entity.Dz11ProfileId;
import com.gmail.ioanna.myandroidapp.domain.entity.Dz11ProfileModel;
import com.gmail.ioanna.myandroidapp.domain.interaction.base.UseCase;


import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class Dz11GetProfileUseCaseById extends UseCase<Dz11ProfileId, Dz11ProfileModel> {
    @Override
    protected Observable<Dz11ProfileModel> buildUseCase(Dz11ProfileId profileId) {
        String id = profileId.getId();
        Log.e("AAA", "GetProfileUseCaseById   " + id);
        return Dz11RestService.getInstance().getProfileById(id).map(new Function<Dz11Profile, Dz11ProfileModel>() {
            @Override
            public Dz11ProfileModel apply(@NonNull Dz11Profile profile) throws Exception {
                Dz11ProfileModel profileModel = new Dz11ProfileModel();
                Log.e("bbb",profile.getName());
                profileModel.setName(profile.getName());
                profileModel.setSurname(profile.getSurname());
                profileModel.setAge(profile.getAge());
                profileModel.setCountry(profile.getCountry());
                profileModel.setId(profile.getId());
                return profileModel;
            }
        });


    }
}
