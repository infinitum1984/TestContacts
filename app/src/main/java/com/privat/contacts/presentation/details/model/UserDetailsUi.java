package com.privat.contacts.presentation.details.model;

import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public interface UserDetailsUi {
    void showName(TextView textView);
    void showPhone(TextView textView);
    void loadAvatar(ImageView imageView);
    void showFavorite(FloatingActionButton floatingActionButton);
}
