package com.gmail.ioanna.myandroidapp.dz9;


import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.gmail.ioanna.myandroidapp.base.BaseItemViewModel;
import com.gmail.ioanna.myandroidapp.domain.entity.Dz9ProfileModel;
import com.squareup.picasso.Picasso;

public class ProfileItemViewModel extends BaseItemViewModel<Dz9ProfileModel> {

    public ObservableField<String> url = new ObservableField<>("");

    /*public String getImageUrl(Dz9ProfileModel item) {
        return item.getLink();
    }*/


    @BindingAdapter({"bind:src"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }

    @Override
    public void setItem(Dz9ProfileModel item, int position) {
        url.set(item.getLink());
    }
}
