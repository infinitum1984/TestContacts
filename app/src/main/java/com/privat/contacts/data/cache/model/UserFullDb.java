package com.privat.contacts.data.cache.model;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Relation;

import com.privat.contacts.data.cache.UsersDao;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

import io.reactivex.Completable;

public class UserFullDb {
    @NotNull
    @Embedded
    private final UserDb user;

    @NotNull
    @Relation(parentColumn = "id", entityColumn = "userId")
    private final AddressDb address;
    @NotNull
    @Relation(parentColumn = "id", entityColumn = "userId")
    private final EmploymentDb employment;
    @NotNull
    @Relation(parentColumn = "id", entityColumn = "userId")
    private final SubscriptionDb subscription;

    public UserFullDb(@NonNull UserDb user, @NonNull AddressDb address, @NonNull EmploymentDb employment, @NonNull SubscriptionDb subscription) {
        this.user = user;
        this.address = address;
        this.employment = employment;
        this.subscription = subscription;
    }

    @NotNull
    public static <T> List<T> mapList(@NotNull List<UserFullDb> userFullDbs, @NotNull UserFullDb.Mapper<T> mapper) {
        LinkedList<T> newList = new LinkedList();
        for (UserFullDb item :
                userFullDbs) {
            newList.add(item.map(mapper));
        }
        return newList;
    }

    @NotNull
    public Completable insertNewItem(@NotNull UsersDao usersDao) {
        return usersDao.insertUserDb(user)
                .andThen(usersDao.insertAddressDb(address))
                .andThen(usersDao.insertEmploymentDb(employment))
                .andThen(usersDao.insertSubscriptionDb(subscription));
    }

    @NotNull
    public <T> T map(@NotNull Mapper<T> mapper) {
        return mapper.map(user, address, employment, subscription);
    }

    public interface Mapper<T> {
        @NotNull
        T map(@NotNull UserDb user, @NotNull AddressDb address, @NotNull EmploymentDb employment, @NotNull SubscriptionDb subscription);
    }
}