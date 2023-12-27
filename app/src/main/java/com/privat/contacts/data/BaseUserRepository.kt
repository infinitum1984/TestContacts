package com.privat.contacts.data

import com.privat.contacts.data.cache.UsersDao
import com.privat.contacts.data.cache.model.UserFullDb
import com.privat.contacts.data.cache.photos.PhotosDatasource
import com.privat.contacts.data.cloud.NetworkApiService
import com.privat.contacts.data.cloud.model.UserNet
import com.privat.contacts.domain.UsersRepository
import com.privat.contacts.domain.model.UserDomain
import io.reactivex.Completable
import io.reactivex.CompletableEmitter
import io.reactivex.Observable
import io.reactivex.functions.Function
import io.reactivex.subjects.ReplaySubject
import java.io.IOException
import java.util.LinkedList
import javax.inject.Inject

class BaseUserRepository @Inject internal constructor(private val networkApiService: NetworkApiService,
                                                      private val contactsDao: UsersDao,
                                                      private val userDomainMapper: UserNet.Mapper<UserDomain>, private val userFullDomainDbMapper: UserDomain.Mapper<UserFullDb>, private val userDbDomainMapper: UserFullDb.Mapper<UserDomain>, private val photosDatasource: PhotosDatasource) : UsersRepository {
    private val networkUsersList: LinkedList<UserDomain> = LinkedList()
    private val networkUsersSubject = ReplaySubject.createWithSize<List<UserDomain>>(1)
    override fun fetchNewUser(): Completable {
        return networkApiService.newUser.flatMapCompletable { userNet: UserNet ->
            networkUsersList.add(userNet!!.map(userDomainMapper))
            networkUsersSubject.onNext(networkUsersList)
            Completable.complete()
        }
    }

    override fun networkUsers(): Observable<List<UserDomain>> {
        return networkUsersSubject
    }

    override fun favoriteUsers(): Observable<List<UserDomain>> {
        return contactsDao.selectFavoriteUsers().map<List<UserDomain>>(Function<List<UserFullDb>, List<UserDomain>> { items: List<UserFullDb> -> UserFullDb.Companion.mapList<UserDomain>(items, userDbDomainMapper) })
    }

    private fun getItemByIdFromNetworkList(userId: Int): UserDomain {
        for (user in networkUsersList) {
            if (user!!.sameId(userId)) return user
        }
        throw Exception("user not found")
    }

    override fun changeUserFavorite(userId: Int): Completable {
        return contactsDao.changeUserFavorite(userId)
    }

    override fun saveUser(userId: Int): Completable {
        val user = getItemByIdFromNetworkList(userId)
        return user.map(userFullDomainDbMapper).insertNewItem(contactsDao).andThen(photosDatasource.savePhoto(userId, user.photoUrl()))
    }

    override fun clearTempData(): Completable {
        return contactsDao.selectTempUserIds().flatMapCompletable { ids: List<Int> ->
            Completable.create { completable: CompletableEmitter ->
                try {
                    for (id in ids!!) {
                        photosDatasource.removePhoto(id)
                    }
                    completable.onComplete()
                } catch (e: IOException) {
                    completable.onError(e)
                }
            }
        }.andThen(contactsDao.deleteTempAddress())
                .andThen(contactsDao.deleteTempEmployment())
                .andThen(contactsDao.deleteTempSubscription())
                .andThen(contactsDao.deleteTempUsersData())
    }

    override fun getUserById(userId: Int): Observable<UserDomain> {
        return contactsDao.selectUserById(userId).map { item: UserFullDb -> item!!.map(userDbDomainMapper) }
    }
}