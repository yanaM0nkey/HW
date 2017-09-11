package com.gmail.ioanna.myandroidapp.domain.interaction;

import com.gmail.ioanna.myandroidapp.data.database.DatabaseManager;

import com.gmail.ioanna.myandroidapp.domain.entity.AddUser;
import com.gmail.ioanna.myandroidapp.domain.entity.Country;
import com.gmail.ioanna.myandroidapp.domain.entity.User;
import com.gmail.ioanna.myandroidapp.domain.interaction.base.UseCase;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;


public class AddUserToDatabase extends UseCase<AddUser, Void> {
    @Override
    protected Observable<Void> buildUseCase(final AddUser param) {




        return Observable.create(new ObservableOnSubscribe<Void>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Void> e) throws Exception {
                DatabaseManager databaseManager = new DatabaseManager(param.getContext());
                databaseManager.open(true);
                databaseManager.insertUser(convert(param.getUser()));
                databaseManager.close();

            }
        }).just(null);
    }

    private com.gmail.ioanna.myandroidapp.data.dbentity.User convert(User user){
        com.gmail.ioanna.myandroidapp.data.dbentity.User userData = new com.gmail.ioanna.myandroidapp.data.dbentity.User();
        userData.setName(user.getName());
        userData.setAge(user.getAge());
        userData.setCountry(convertCountry(user.getCountry()));
        return userData;
    }

    private com.gmail.ioanna.myandroidapp.data.dbentity.Country convertCountry(Country country) {

        com.gmail.ioanna.myandroidapp.data.dbentity.Country countryData = new com.gmail.ioanna.myandroidapp.data.dbentity.Country();
        countryData.setName(country.getName());
        countryData.setId(country.getId());
        return countryData;
    }




}
