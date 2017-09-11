package com.gmail.ioanna.myandroidapp.domain.interaction;


import com.gmail.ioanna.myandroidapp.data.entity.Dz11Profile;
import com.gmail.ioanna.myandroidapp.data.net.Dz11RestService;
import com.gmail.ioanna.myandroidapp.domain.entity.Dz11ProfileModel;
import com.gmail.ioanna.myandroidapp.domain.interaction.base.UseCase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class Dz11GetProfileUseCase extends UseCase<Void, List<Dz11ProfileModel>> {
    @Override
    protected Observable<List<Dz11ProfileModel>> buildUseCase(Void param) {
        return Dz11RestService.getInstance().getProfiles().map(new Function<List<Dz11Profile>, List<Dz11ProfileModel>>() {
            @Override
            public List<Dz11ProfileModel> apply(@NonNull List<Dz11Profile> profiles) throws Exception {
                List<Dz11ProfileModel> list = new ArrayList<Dz11ProfileModel>();
                for (Dz11Profile profile : profiles) {
                    list.add(convert(profile));
                }
                return list;
            }
        });
    }

    private Dz11ProfileModel convert(Dz11Profile dataModel) {
        Dz11ProfileModel profileModel = new Dz11ProfileModel();
        profileModel.setName(dataModel.getName());
        profileModel.setId(dataModel.getId());
        return profileModel;
    }
}





/*@Override
protected Observable<List<Dz11ProfileModel>> buildUseCase(Dz11Profile param) {

        List<Dz11Profile> listProfiles = new ArrayList<>();


        return Observable.just(listProfiles)
        .map(new Function<List<Dz9Profile>, List<Dz9ProfileModel>>() {
            @Override
            public List<Dz9ProfileModel> apply(@NonNull List<Dz9Profile> profiles) throws Exception {
                    List<Dz9ProfileModel> list = new ArrayList<Dz9ProfileModel>();
                    for(Dz9Profile profile: profiles){
                    Log.e("AAA", profile.getLink());
                    list.add(convert(profile));
                    }
                    Log.e("AAA", "size = " + list.size());
                    return list;
                    }
                    });
                    }

            private Dz9ProfileModel convert(Dz9Profile dataModel){
                    Dz9ProfileModel profileModel = new Dz9ProfileModel();
                    profileModel.setLink(dataModel.getLink());
                    return profileModel;
                    }*/

