package com.gmail.ioanna.myandroidapp.domain.interaction.base;


public abstract class UseCase<InParam, OutParam> {

    protected abstract OutParam buildUseCase();

    public OutParam execute(InParam param){
        return  buildUseCase();
    }

}
