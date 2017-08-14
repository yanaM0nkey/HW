package com.gmail.ioanna.myandroidapp.domain.interaction;

import com.gmail.ioanna.myandroidapp.domain.entity.Profile;
import com.gmail.ioanna.myandroidapp.domain.entity.ProfileId;
import com.gmail.ioanna.myandroidapp.domain.interaction.base.UseCase;


public class ProfileUseCase extends UseCase<ProfileId, Profile> {
    @Override
    protected Profile buildUseCase() {
        Profile profile = new Profile();
        profile.setName("Name");
        profile.setSurname("Surname");
        profile.setAge(20);
        return profile;
    }
}
