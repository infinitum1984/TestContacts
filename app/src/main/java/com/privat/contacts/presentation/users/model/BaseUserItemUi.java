package com.privat.contacts.presentation.users.model;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.privat.contacts.R;

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

    public BaseUserItemUi(int id, @NotNull String name, @NotNull String phone, @NotNull String imgUrl) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.imgUrl = imgUrl;
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public void loadAvatar(@NotNull ImageView imageView) {
        Glide.with(imageView.getContext()).load(imgUrl).placeholder(R.drawable.ic_person)
                .into(imageView);
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
    public void showFavorite(@NotNull ImageButton imageButton, @NotNull Consumer<Integer> clickAction) {
        imageButton.setImageResource(R.drawable.ic_delete);
        imageButton.setOnClickListener(listener -> {
            clickAction.accept(id);
        });
    }
}
