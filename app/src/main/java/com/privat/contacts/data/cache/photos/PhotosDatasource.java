package com.privat.contacts.data.cache.photos;

import io.reactivex.Completable;

public interface PhotosDatasource {
    Completable savePhoto(int userId, String photoUrl);

    Completable removePhoto(int userId);
}
