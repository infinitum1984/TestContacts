package com.privat.contacts.data;

import com.privat.contacts.data.cache.UsersDao;
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

    @Inject
    BaseUserRepository(NetworkApiService networkApiService,
                       UsersDao usersDao,
                       UserNet.Mapper<UserDomain> userDomainMapper) {
        this.networkApiService = networkApiService;
        this.contactsDao = usersDao;
        this.userDomainMapper = userDomainMapper;
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
