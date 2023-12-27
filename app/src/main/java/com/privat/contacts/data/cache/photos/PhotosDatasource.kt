package com.privat.contacts.data.cache.photos

import io.reactivex.Completable
import java.io.IOException

interface PhotosDatasource {
    fun savePhoto(userId: Int, photoUrl: String): Completable

    @Throws(IOException::class)
    fun removePhoto(userId: Int)
}
