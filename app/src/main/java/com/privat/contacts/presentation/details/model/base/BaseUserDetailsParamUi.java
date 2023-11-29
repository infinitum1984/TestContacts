package com.privat.contacts.presentation.details.model.base;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.privat.contacts.R;
import com.privat.contacts.presentation.details.model.UserDetailsParamUi;
import com.privat.contacts.presentation.details.model.UserDetailsUi;

import java.util.List;

public class BaseUserDetailsParamUi implements UserDetailsUi {
    private final String avatarUrl;
    private final String name;
    private final String phone;
    private final boolean favorite;
    public BaseUserDetailsParamUi(String name, String phone, boolean favorite, String avatarUrl) {
        this.avatarUrl = avatarUrl;
        this.name = name;
        this.phone = phone;
        this.favorite = favorite;}

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
        Glide.with(imageView.getContext()).load(avatarUrl).placeholder(R.drawable.ic_person)
                .into(imageView);
    }

    @Override
    public void showFavorite(FloatingActionButton floatingActionButton) {
        if (favorite)
            floatingActionButton.setImageResource(R.drawable.ic_favorite);
        else
            floatingActionButton.setImageResource(R.drawable.ic_favorite_border);
    }
}
