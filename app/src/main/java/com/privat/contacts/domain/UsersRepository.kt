package com.privat.contacts.domain

import com.privat.contacts.domain.model.UserDomain
import io.reactivex.Completable
import io.reactivex.Observable

interface UsersRepository {
    fun networkUsers(): Observable<List<UserDomain>>
    fun favoriteUsers(): Observable<List<UserDomain>>
    fun fetchNewUser(): Completable
    fun changeUserFavorite(userId: Int): Completable
    fun saveUser(userId: Int): Completable
    fun clearTempData(): Completable
    fun getUserById(userId: Int): Observable<UserDomain>
}
