package com.privat.contacts.presentation.images;

import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.privat.contacts.R;

import java.io.File;

import javax.inject.Inject;

public class BaseImageLoader implements ImageLoader {
    @Inject
    BaseImageLoader() {
    }

    @Override
    public void loadFromUrl(String avatarUrl, ImageView imageView) {
        Glide.with(imageView.getContext()).load(avatarUrl).placeholder(R.drawable.ic_person)
                .into(imageView);
    }

    @Override
    public void loadFromCache(int userId, ImageView imageView) {
        File storageDir = new File(imageView.getContext().getExternalCacheDir(), "images");
        File imgFile = new File(storageDir, userId + ".png");
        Glide.with(imageView.getContext())
                .load(Uri.fromFile(imgFile))
                .placeholder(R.drawable.ic_person).into(imageView);
    }
}