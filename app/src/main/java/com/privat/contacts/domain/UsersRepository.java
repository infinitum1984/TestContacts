package com.privat.contacts.domain;

import com.privat.contacts.domain.model.UserDomain;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface UsersRepository {
    Observable<List<UserDomain>> networkUsers();
    Observable<List<UserDomain>> favoriteUsers();
    Completable fetchNewUser();
    Completable changeUserFavorite(int userId);
    Completable saveUser(int userId);
    Completable clearTempData();
    Observable<UserDomain> getUserById(int userId);
}