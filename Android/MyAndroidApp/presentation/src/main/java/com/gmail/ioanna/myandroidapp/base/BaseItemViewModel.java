package com.gmail.ioanna.myandroidapp.base;


import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.gmail.ioanna.myandroidapp.dz11.Dz11_2Activity;

public abstract class BaseItemViewModel<Model> implements BaseViewModel {

    public abstract void setItem(Model item, int position);

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
}
