package com.gmail.ioanna.myandroidapp.domain.interaction.old;


import com.gmail.ioanna.myandroidapp.data.entity.Profile;
import com.gmail.ioanna.myandroidapp.data.net.RestService;
import com.gmail.ioanna.myandroidapp.domain.entity.ProfilId;
import com.gmail.ioanna.myandroidapp.domain.entity.ProfileModel;
import com.gmail.ioanna.myandroidapp.domain.interaction.base.UseCase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class GetProfileUseCase extends UseCase<ProfilId, List<ProfileModel>> {
    @Override
    protected Observable<List<ProfileModel>> buildUseCase(ProfilId param) {
        return RestService.getInstance().getProfiles().map(new Function<List<Profile>, List<ProfileModel>>() {
            @Override
            public List<ProfileModel> apply(@NonNull List<Profile> profiles) throws Exception {
                List<ProfileModel> list = new ArrayList<ProfileModel>();
                for(Profile profile: profiles){
                    list.add(convert(profile));
                }
                return list;
            }
        });
    }

    private ProfileModel convert(Profile dataModel){
        ProfileModel profileModel = new ProfileModel();
        profileModel.setName(dataModel.getName());
        profileModel.setSurname(dataModel.getSurname());
        profileModel.setAge(dataModel.getAge());
        return profileModel;
    }
}
