package com.gmail.ioanna.myandroidapp.domain.interaction;

import com.gmail.ioanna.myandroidapp.data.entity.AccessTokenData;
import com.gmail.ioanna.myandroidapp.data.entity.RegisterData;
import com.gmail.ioanna.myandroidapp.data.net.RestService;
import com.gmail.ioanna.myandroidapp.domain.entity.OkDomain;
import com.gmail.ioanna.myandroidapp.domain.entity.RegisterDomain;
import com.gmail.ioanna.myandroidapp.domain.interaction.base.UseCase;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by UX501 on 19.09.2017.
 */

public class RegisterUseCase extends UseCase<RegisterDomain, OkDomain> {

    private AuthService authService;

    @Inject
    public RegisterUseCase(AuthService authService){
        this.authService = authService;
    }

    @Override
    protected Observable<OkDomain> buildUseCase(RegisterDomain param) {

        return RestService.getInstance().register(convert(param))
                .doOnNext(new Consumer<AccessTokenData>() {
                    @Override
                    public void accept(AccessTokenData accessTokenData) throws Exception {
                        authService.saveAccessToken(accessTokenData.getAccessToken());
                    }
                })
                .map(new Function<AccessTokenData, OkDomain>() {
                    @Override
                    public OkDomain apply(@NonNull AccessTokenData accessTokenData) throws Exception {


                        return new OkDomain();
                    }
                });
    }

    private RegisterData convert (RegisterDomain registerDomain){
        RegisterData registerData = new RegisterData();
        registerData.setUsername(registerDomain.getUsername());
        registerData.setPassword(registerDomain.getPassword());
        return registerData;

    }
}
