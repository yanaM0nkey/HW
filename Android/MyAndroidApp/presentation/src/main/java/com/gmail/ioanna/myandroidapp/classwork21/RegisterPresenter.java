package com.gmail.ioanna.myandroidapp.classwork21;

import com.gmail.ioanna.myandroidapp.ApplicationClass;
import com.gmail.ioanna.myandroidapp.domain.entity.AuthState;
import com.gmail.ioanna.myandroidapp.domain.entity.OkDomain;
import com.gmail.ioanna.myandroidapp.domain.entity.RegisterDomain;
import com.gmail.ioanna.myandroidapp.domain.interaction.AuthService;
import com.gmail.ioanna.myandroidapp.domain.interaction.RegisterUseCase;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class RegisterPresenter implements RegisterBasePresenter{

    private RegisterView registerView;

    @Inject
    public AuthService authService;

    private Disposable authDisposible;

    @Inject
    public RegisterUseCase useCase;

    public RegisterPresenter(RegisterView registerView) {
        ApplicationClass.appComponent.inject(this);
        this.registerView = registerView;
    }


    @Override
    public void onRegisterButtonClick(String username, String password) {
        registerView.showProgress();

        RegisterDomain register = new RegisterDomain();
        register.setUsername(username);
        register.setPassword(password);

        useCase.execute(register, new DisposableObserver<OkDomain>() {
            @Override
            public void onNext(@NonNull OkDomain okDomain) {
                registerView.dismissProgress();
                registerView.goToMainActivity();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                registerView.showError("error");

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onResume() {
        authDisposible = authService.observeState().subscribeWith(new DisposableObserver<AuthState>() {
            @Override
            public void onNext(@NonNull AuthState authState) {
                //проверяем состояние авторизации
                if(authState.isSigned()){
                    registerView.goToMainActivity();
                }

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    public void onPause() {
        if(authDisposible != null && !authDisposible.isDisposed())
            authDisposible.dispose();

    }
}
