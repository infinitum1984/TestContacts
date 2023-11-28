package com.privat.contacts.presentation.users.model;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.privat.contacts.R;

import java.util.function.Consumer;

public class BaseUserItemUi implements UserItemUi {
    private final int id;
    private final String name;
    private final String phone;
    private final Boolean favorite;
    private final String imgUrl;

    public BaseUserItemUi(int id, String name, String phone, Boolean favorite, String imgUrl) {
        this.id = id;
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
    public void showFavorite(ImageButton imageButton, Consumer<Integer> clickAction) {
        if (favorite)
            imageButton.setImageResource(R.drawable.ic_favorite);
        else
            imageButton.setImageResource(R.drawable.ic_favorite_border);
        imageButton.setOnClickListener(listener -> {
            clickAction.accept(id);
        });
    }
}
