package com.privat.contacts.presentation.users.model;

import android.content.Context;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.privat.contacts.R;

import java.util.function.Consumer;

public class BaseUserItemUi implements UserItemUi {
    private final int id;
    private final String name;
    private final String phone;
    private final String imgUrl;

    public BaseUserItemUi(int id, String name, String phone,String imgUrl) {
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
    public void loadAvatar(ImageView imageView) {
        Glide.with(imageView.getContext()).load(imgUrl).placeholder(R.drawable.ic_person)
                .into(imageView);
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
    public void showFavorite(ImageButton imageButton, Consumer<Integer> clickAction) {
        imageButton.setImageResource(R.drawable.ic_delete);
        imageButton.setOnClickListener(listener -> {
            clickAction.accept(id);
        });
    }
}
