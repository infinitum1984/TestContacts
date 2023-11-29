package com.privat.contacts.data.cache.photos;

import java.io.IOException;

import io.reactivex.Completable;

public interface PhotosDatasource {
    Completable savePhoto(int userId, String photoUrl);

    void removePhoto(int userId) throws IOException;
}
