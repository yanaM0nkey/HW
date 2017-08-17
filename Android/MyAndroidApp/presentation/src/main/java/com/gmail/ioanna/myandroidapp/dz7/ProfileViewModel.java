package com.gmail.ioanna.myandroidapp.dz7;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class ProfileViewModel {

    public String getImageUrl() {
        return "http://www.etoday.ru/uploads/2014/03/26/Scarlett-Johannson-WSJ-Magazine-Alasdair-McLellan-06.jpg";
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }
}
