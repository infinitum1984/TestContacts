package com.privat.contacts.data.cache;

import androidx.room.Dao;
import androidx.room.Query;

import com.privat.contacts.data.cache.model.UserFullDb;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

@Dao
public interface ContactsDao {
    @Query("SELECT * FROM userdb")
    Observable<List<UserFullDb>> selectFavoriteUsers();

    @Query("SELECT EXISTS(SELECT * FROM userdb WHERE id=:id)")
    Single<Boolean> userIsFavorite(int id);


}
