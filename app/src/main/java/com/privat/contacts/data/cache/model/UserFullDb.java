package com.privat.contacts.data.cache.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.privat.contacts.data.cache.UsersDao;

import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;
import java.util.List;

import io.reactivex.Completable;

public class UserFullDb {
    @Embedded
    private final UserDb user;
    @Nullable
    @Relation(parentColumn = "id", entityColumn = "userId")
    private final AddressDb address;
    @Relation(parentColumn = "id", entityColumn = "userId")
    private final EmploymentDb employment;
    @Relation(parentColumn = "id", entityColumn = "userId")
    private final SubscriptionDb subscription;

    public UserFullDb(UserDb user, AddressDb address, EmploymentDb employment, SubscriptionDb subscription) {
        this.user = user;
        this.address = address;
        this.employment = employment;
        this.subscription = subscription;
    }

    public static <T> List<T> mapList(List<UserFullDb> userFullDbs, UserFullDb.Mapper<T> mapper) {
        LinkedList<T> newList = new LinkedList();
        for (UserFullDb item :
                userFullDbs) {
            newList.add(item.map(mapper));
        }
        return newList;
    }

    public Completable insertNewItem(UsersDao usersDao) {
        return usersDao.insertUserDb(user)
                .andThen(usersDao.insertAddressDb(address))
                .andThen(usersDao.insertEmploymentDb(employment))
                .andThen(usersDao.insertSubscriptionDb(subscription));
    }

    public <T> T map(Mapper<T> mapper) {
        return mapper.map(user, address, employment, subscription);
    }

    public interface Mapper<T> {
        T map(UserDb user, AddressDb address, EmploymentDb employment, SubscriptionDb subscription);
    }
}