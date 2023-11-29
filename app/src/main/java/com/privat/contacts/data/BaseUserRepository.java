package com.privat.contacts.data;

import androidx.annotation.Nullable;

import com.privat.contacts.data.cache.UsersDao;
import com.privat.contacts.data.cache.model.UserFullDb;
import com.privat.contacts.data.cloud.NetworkApiService;
import com.privat.contacts.data.cloud.model.UserNet;
import com.privat.contacts.domain.UsersRepository;
import com.privat.contacts.domain.model.UserDomain;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.subjects.ReplaySubject;

public class BaseUserRepository implements UsersRepository {
    private final NetworkApiService networkApiService;
    private final UsersDao contactsDao;
    private final UserNet.Mapper<UserDomain> userDomainMapper;
    private final LinkedList<UserDomain> networkUsersList = new LinkedList();
    private final ReplaySubject<List<UserDomain>> networkUsersSubject = ReplaySubject.createWithSize(1);
    private final UserDomain.Mapper<UserFullDb> userFullDomainDbMapper;
    private final UserFullDb.Mapper<UserDomain> userDbDomainMapper;

    @Inject
    BaseUserRepository(NetworkApiService networkApiService,
                       UsersDao usersDao,
                       UserNet.Mapper<UserDomain> userDomainMapper, UserDomain.Mapper<UserFullDb> userFullDbDomainMapper, UserFullDb.Mapper<UserDomain> userDbDomainMapper) {
        this.networkApiService = networkApiService;
        this.contactsDao = usersDao;
        this.userDomainMapper = userDomainMapper;
        this.userFullDomainDbMapper = userFullDbDomainMapper;
        this.userDbDomainMapper = userDbDomainMapper;
    }

    @Override
    public Completable fetchNewUser() {
        return networkApiService.getNewUser().flatMapCompletable(userNet -> {
            networkUsersList.add(userNet.map(userDomainMapper));
            networkUsersSubject.onNext(networkUsersList);
            return Completable.complete();
        });
    }

    @Override
    public Observable<List<UserDomain>> networkUsers() {
        return networkUsersSubject;
    }

    @Override
    public Observable<List<UserDomain>> favoriteUsers() {
        return contactsDao.selectFavoriteUsers().map(items -> {
            return UserFullDb.mapList(items, userDbDomainMapper);
        });
    }

    @Nullable
    private UserDomain getItemByIdFromNetworkList(int userId) {
        for (UserDomain user :
                networkUsersList) {
            if (user.sameId(userId))
                return user;
        }
        return null;
    }

    @Override
    public Completable changeUserFavorite(int userId) {
        return contactsDao.changeUserFavorite(userId);
    }

    @Override
    public Completable saveUser(int userId) {
        UserDomain user = getItemByIdFromNetworkList(userId);
        if (user == null)
            return Completable.error(new Exception("User not found"));
        else
            return user.map(userFullDomainDbMapper).insertNewItem(contactsDao);
    }

    @Override
    public Completable clearTempData() {
        return contactsDao.deleteTempAddress()
                .andThen(contactsDao.deleteTempEmployment())
                .andThen(contactsDao.deleteTempSubscription())
                .andThen(contactsDao.deleteTempUsersData());
    }

    @Override
    public Observable<UserDomain> getUserById(int userId) {
        return contactsDao.selectUserById(userId).map(item -> {
            return item.map(userDbDomainMapper);
        });
    }
}