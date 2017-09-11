package com.gmail.ioanna.myandroidapp.domain.interaction.old;


import android.util.Log;

import com.gmail.ioanna.myandroidapp.data.entity.Dz9Profile;
import com.gmail.ioanna.myandroidapp.domain.entity.Dz9ProfileModel;
import com.gmail.ioanna.myandroidapp.domain.interaction.base.UseCase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class Dz9GetProfileUseCase extends UseCase<Dz9Profile, List<Dz9ProfileModel>> {
    @Override
    protected Observable<List<Dz9ProfileModel>> buildUseCase(Dz9Profile param) {

        List<Dz9Profile> listProfiles = new ArrayList<>();

        listProfiles.add(new Dz9Profile("http://dreempics.com/img/picture/Jun/04/58f589f7a94f77e32c94a55ad4cf23de/2.jpg"));
        listProfiles.add(new Dz9Profile("http://fotohomka.ru/images/Nov/02/b8e19d2c2015845f5b509c837eae967e/mini_5.jpg"));
        listProfiles.add(new Dz9Profile("http://img.izhlife.ru/posts/newsimg/imgs-117967.ru-Despicable-Me-2-2183494.jpg"));
        listProfiles.add(new Dz9Profile("http://zainetom.ru/wp-content/uploads/2015/11/113.jpg"));
        listProfiles.add(new Dz9Profile("http://cs619118.vk.me/v619118754/19564/m8yp5t8CI7U.jpg"));
        listProfiles.add(new Dz9Profile("http://www.fullhdoboi.com/wallpapers/thumbs/6/kartinka-apelsiny-1885.jpg"));


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
    }
}
