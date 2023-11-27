package com.privat.contacts.data;

import com.privat.contacts.base.mapper.Mapper;
import com.privat.contacts.data.cache.ContactsDao;
import com.privat.contacts.data.cache.model.UserFullDb;
import com.privat.contacts.data.cloud.NetworkApiService;
import com.privat.contacts.data.cloud.model.UserNet;
import com.privat.contacts.domain.UserDomain;
import com.privat.contacts.domain.UsersRepository;

import java.util.LinkedList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class BaseUserRepository implements UsersRepository {
    private final NetworkApiService networkApiService;
    private final ContactsDao contactsDao;
    private final Mapper<UserNet, UserDomain> mapperNetDomain;
    private final Mapper<UserFullDb, UserDomain> mapperDbDomain;
    private final LinkedList<UserDomain> networkUsersList = new LinkedList();
    private final PublishSubject<List<UserDomain>> networkUsersSubject = PublishSubject.create();

    BaseUserRepository(NetworkApiService networkApiService,
                       ContactsDao contactsDao,
                       Mapper<UserNet, UserDomain> mapperNetDomain,
                       Mapper<UserFullDb, UserDomain> mapperDbDomain) {
        this.networkApiService = networkApiService;
        this.contactsDao = contactsDao;
        this.mapperNetDomain = mapperNetDomain;
        this.mapperDbDomain = mapperDbDomain;
    }

    @Override
    public Completable fetchNewUser() {
        return networkApiService.getNewUser().flatMapCompletable(userNet -> {
            networkUsersList.add(mapperNetDomain.map(userNet));
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
            return mapperDbDomain.map(items);
        });
    }

    @Override
    public Completable changeUserFavorite(int userId) {
        return null;
    }
}
