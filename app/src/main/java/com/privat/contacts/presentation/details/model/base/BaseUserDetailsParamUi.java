package com.privat.contacts.presentation.details.model.base;

import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.privat.contacts.R;
import com.privat.contacts.presentation.details.model.UserDetailsUi;

import org.jetbrains.annotations.NotNull;

import java.io.File;

public class BaseUserDetailsParamUi implements UserDetailsUi {
    private final int userId;
    @NotNull
    private final String name;
    @NotNull
    private final String phone;
    @NotNull
    private final boolean favorite;

    public BaseUserDetailsParamUi(int userId, @NotNull String name, @NotNull String phone, boolean favorite) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.favorite = favorite;
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
        File storageDir = new File(imageView.getContext().getExternalCacheDir(), "images");
        File imgFile = new File(storageDir, userId + ".png");
        Glide.with(imageView.getContext()).load(Uri.fromFile(imgFile)).placeholder(R.drawable.ic_person).into(imageView);
    }

    @Override
    public void showFavorite(FloatingActionButton floatingActionButton) {
        if (favorite)
            floatingActionButton.setImageResource(R.drawable.ic_favorite);
        else
            floatingActionButton.setImageResource(R.drawable.ic_favorite_border);
    }
}
