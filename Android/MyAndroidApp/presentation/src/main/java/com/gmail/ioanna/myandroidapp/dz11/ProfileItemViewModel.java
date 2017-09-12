package com.gmail.ioanna.myandroidapp.dz11;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

import com.gmail.ioanna.myandroidapp.base.BaseItemViewModel;
import com.gmail.ioanna.myandroidapp.domain.entity.Dz11ProfileModel;
import com.gmail.ioanna.myandroidapp.dz2.Dz2Activity;

public class ProfileItemViewModel extends BaseItemViewModel<Dz11ProfileModel>{

    Activity activity;

    public ProfileItemViewModel(Activity activity) {
        this.activity = activity;
    }

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> id = new ObservableField<>("");

    @Override
    public void setItem(Dz11ProfileModel item, int position) {
        name.set(item.getName());
        id.set(item.getId());
    }


    public void onSuperButtonClick(){
        Log.e("AAA", "Click");
        Intent intent = new Intent(activity, Dz11_2Activity.class);
        intent.putExtra("id", id.get());
        Log.e("AAA", id.get());
        activity.startActivity(intent);
    }
}
