package com.gmail.ioanna.myandroidapp.domain.interaction;

import com.gmail.ioanna.myandroidapp.data.entity.Profile;
import com.gmail.ioanna.myandroidapp.data.net.RestService;
import com.gmail.ioanna.myandroidapp.domain.entity.ProfileModel;
import com.gmail.ioanna.myandroidapp.domain.entity.ProfileId;
import com.gmail.ioanna.myandroidapp.domain.interaction.base.UseCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;


public class ProfileUseCase extends UseCase<ProfileId, ProfileModel> {
    @Override
    protected Observable<ProfileModel> buildUseCase(ProfileId param) {

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




//тут делаем запрос к слою data в котором дергаем метод на сервер Rest
//создаем объект Profile который лежит в data слое
//это для теста, в будущем этот объект нам вернет слой data
       /* Profile profile = new Profile();
        profile.setName("Name");
        profile.setSurname("Surname");
        profile.setAge(20);
        return Observable.just(profile)
                .filter(new Predicate<Profile>() {
                    @Override
                    public boolean test(@NonNull Profile profile) throws Exception {
                        return profile.getName() != null;
                    }
                })
                .delay(3, TimeUnit.SECONDS)
                .map(new Function<Profile, ProfileModel>() {
            @Override
            public ProfileModel apply(@NonNull Profile profile) throws Exception {
                ProfileModel profileModel = new ProfileModel();
                profileModel.setName(profile.getName());
                profileModel.setSurname(profile.getSurname());
                profileModel.setAge(profile.getAge());
                return profileModel;
            }
        });*/
