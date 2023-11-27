package com.privat.contacts.data;

import android.util.Log;

import com.privat.contacts.data.cache.UsersDao;
import com.privat.contacts.data.cloud.NetworkApiService;
import com.privat.contacts.domain.UserDomain;
import com.privat.contacts.domain.UsersRepository;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class BaseUserRepository implements UsersRepository {
    private final NetworkApiService networkApiService;
    private final UsersDao contactsDao;
    //    private final Mapper<UserNet, UserDomain> mapperNetDomain;
//    private final Mapper<UserFullDb, UserDomain> mapperDbDomain;
    private final LinkedList<UserDomain> networkUsersList = new LinkedList();
    private final PublishSubject<List<UserDomain>> networkUsersSubject = PublishSubject.create();

    @Inject
    BaseUserRepository(NetworkApiService networkApiService,
                       UsersDao usersDao
    ) {
        this.networkApiService = networkApiService;
        this.contactsDao = usersDao;
//        this.mapperNetDomain = mapperNetDomain;
//        this.mapperDbDomain = mapperDbDomain;
    }

    @Override
    public Completable fetchNewUser() {
        return networkApiService.getNewUser().flatMapCompletable(userNet -> {
//            networkUsersList.add(mapperNetDomain.map(userNet));
//            networkUsersSubject.onNext(networkUsersList);
            Log.d("BaseUserRepository", "user : " + userNet.data() + " " + userNet);
            return Completable.complete();
        });
    }

    @Override
    public Observable<List<UserDomain>> networkUsers() {
        return networkUsersSubject;
    }

    @Override
    public Observable<List<UserDomain>> favoriteUsers() {
//        return contactsDao.selectFavoriteUsers().map(items -> {
//            return mapperDbDomain.map(items);
//        });
        return null;
    }

    @Override
    public Completable changeUserFavorite(int userId) {
        return null;
    }
}
