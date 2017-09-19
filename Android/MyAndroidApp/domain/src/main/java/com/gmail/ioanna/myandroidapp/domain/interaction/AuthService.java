package com.gmail.ioanna.myandroidapp.domain.interaction;


import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.gmail.ioanna.myandroidapp.domain.entity.AuthState;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

@Singleton
public class AuthService {

    private static final String KEY_ACCESS_TOKEN = "accessToken";
    private static final String SHARED_PREFS_NAME = "sharedPrefs";
    private Context context;

    private BehaviorSubject<AuthState> state = BehaviorSubject.createDefault(new AuthState(false));

    //private static AuthService instance = new AuthService();

    @Inject
    public AuthService(Context context) {
        this.context = context;
        restoreAccessToken();
    }

    /*public static AuthService getInstance(){
        return instance;
    }*/

    public Observable<AuthState> observeState(){
        return state;
    }

    void saveAccessToken(String accessToken){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        preferences.edit().putString(KEY_ACCESS_TOKEN, accessToken).apply();
        //уведомляем всех подписчиков
        state.onNext(new AuthState(true));

    }

    void removeAccessToken(){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        preferences.edit().remove(KEY_ACCESS_TOKEN).apply();

        state.onNext(new AuthState(false));

    }

    private void restoreAccessToken(){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
        String token = preferences.getString(KEY_ACCESS_TOKEN, null);

        if(!TextUtils.isEmpty(token)){
            state.onNext(new AuthState(true));
        }else{
            state.onNext(new AuthState(false));
        }

    }
}
