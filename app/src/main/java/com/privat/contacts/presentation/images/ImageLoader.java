package com.privat.contacts.presentation.images;

import android.widget.ImageView;

public interface ImageLoader {
    void loadFromUrl(String avatarUrl, ImageView imageView);

    void loadFromCache(int userId, ImageView imageView);
}
