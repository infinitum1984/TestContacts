package com.privat.contacts.presentation.users.model;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface UserItemUi {
    int id();

    void loadAvatar(@NotNull ImageView imageView);

    void showTitle(@NotNull TextView textView);

    void showText(@NotNull TextView textView);

    void showRemove(@NotNull ImageButton imageButton, @NotNull Consumer<Integer> clickAction);

    boolean favorite();
}