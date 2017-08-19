package com.gmail.ioanna.myandroidapp.domain.interaction.old;

import com.gmail.ioanna.myandroidapp.data.entity.Profile;
import com.gmail.ioanna.myandroidapp.data.net.RestService;
import com.gmail.ioanna.myandroidapp.domain.entity.ProfilId;
import com.gmail.ioanna.myandroidapp.domain.entity.ProfileModel;
import com.gmail.ioanna.myandroidapp.domain.interaction.base.UseCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class ProfileUseCase extends UseCase<ProfilId, ProfileModel> {
    @Override
    protected Observable<ProfileModel> buildUseCase(ProfilId param) {

        return RestService.getInstance().getProfiles()
                .map(new Function<List<Profile>, ProfileModel>() {
                    @Override
                    public ProfileModel apply(@NonNull List<Profile> profileList)
                            throws Exception {

                        Profile profileData = profileList.get(0);

                        ProfileModel profileModel = new ProfileModel();
                        profileModel.setName(profileData.getName());
                        profileModel.setSurname(profileData.getSurname());
                        profileModel.setAge(profileData.getAge());

                        return profileModel;
                    }
                });
    }
}
