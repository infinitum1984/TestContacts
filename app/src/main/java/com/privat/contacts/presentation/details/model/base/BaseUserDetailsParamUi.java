package com.privat.contacts.presentation.details.model.base;

import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.privat.contacts.R;
import com.privat.contacts.presentation.details.model.UserDetailsUi;
import com.privat.contacts.presentation.images.ImageLoader;

import org.jetbrains.annotations.NotNull;

public class BaseUserDetailsParamUi implements UserDetailsUi {
    private final int userId;
    @NotNull
    private final String name;
    @NotNull
    private final String phone;
    @NotNull
    private final boolean favorite;
    @NotNull
    private final ImageLoader imageLoader;

    public BaseUserDetailsParamUi(int userId, @NotNull String name, @NotNull String phone, boolean favorite, @NotNull ImageLoader imageLoader) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.favorite = favorite;
        this.imageLoader = imageLoader;
    }

    @Override
    public void showName(TextView textView) {
        textView.setText(name);
    }

    @Override
    public void showPhone(TextView textView) {
        textView.setText(phone);
    }

    @Override
    public void loadAvatar(ImageView imageView) {
        imageLoader.loadFromCache(userId, imageView);
    }

    @Override
    public void showFavorite(FloatingActionButton floatingActionButton) {
        if (favorite)
            floatingActionButton.setImageResource(R.drawable.ic_favorite);
        else
            floatingActionButton.setImageResource(R.drawable.ic_favorite_border);
    }
}