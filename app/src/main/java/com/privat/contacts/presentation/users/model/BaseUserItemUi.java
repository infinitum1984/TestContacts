package com.privat.contacts.presentation.users.model;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class BaseUserItemUi implements UserItemUi {
    private final String name;
    private final String phone;
    private final Boolean favorite;
    private final String imgUrl;

    public BaseUserItemUi(String name, String phone, Boolean favorite, String imgUrl) {
        this.name = name;
        this.phone = phone;
        this.favorite = favorite;
        this.imgUrl = imgUrl;
    }

    @Override
    public void loadAvatar(ImageView imageView) {

    }

    @Override
    public void showTitle(TextView textView) {
        textView.setText(name);
    }

    @Override
    public void showText(TextView textView) {
        textView.setText(phone);
    }

    @Override
    public void showFavorite(ImageButton imageButton) {

    }
}
