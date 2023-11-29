package com.privat.contacts.presentation.details.model;

import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

public interface UserDetailsUi {
    void showName(@NotNull TextView textView);

    void showPhone(@NotNull TextView textView);

    void loadAvatar(@NotNull ImageView imageView);

    void showFavorite(@NotNull FloatingActionButton floatingActionButton);
}
