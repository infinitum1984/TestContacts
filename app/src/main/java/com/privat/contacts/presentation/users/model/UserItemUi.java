package com.privat.contacts.presentation.users.model;

import android.content.Context;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.function.Consumer;

public interface UserItemUi {
    int id();
    void loadAvatar(ImageView imageView);

    void showTitle(TextView textView);

    void showText(TextView textView);

    void showFavorite(ImageButton imageButton, Consumer<Integer> clickAction);
}
