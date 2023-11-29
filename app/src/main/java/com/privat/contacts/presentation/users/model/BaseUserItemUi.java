package com.privat.contacts.presentation.users.model;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.privat.contacts.R;
import com.privat.contacts.presentation.images.ImageLoader;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class BaseUserItemUi implements UserItemUi {
    private final int id;
    @NotNull
    private final String name;
    @NotNull
    private final String phone;
    @NotNull
    private final String imgUrl;
    @NotNull
    private final ImageLoader imageLoader;
    @NotNull
    private final boolean favorite;

    public BaseUserItemUi(int id, @NotNull String name, @NotNull String phone, @NotNull String imgUrl, @NotNull ImageLoader imageLoader, boolean favorite) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.imgUrl = imgUrl;
        this.imageLoader = imageLoader;
        this.favorite = favorite;
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public void loadAvatar(@NotNull ImageView imageView) {
        if (favorite)
            imageLoader.loadFromCache(id, imageView);
        else
            imageLoader.loadFromUrl(imgUrl, imageView);
    }

    @Override
    public void showTitle(@NotNull TextView textView) {
        textView.setText(name);
    }

    @Override
    public void showText(@NotNull TextView textView) {
        textView.setText(phone);
    }

    @Override
    public void showRemove(@NotNull ImageButton imageButton, @NotNull Consumer<Integer> clickAction) {
        imageButton.setImageResource(R.drawable.ic_delete);
        imageButton.setOnClickListener(listener -> {
            clickAction.accept(id);
        });
    }
}