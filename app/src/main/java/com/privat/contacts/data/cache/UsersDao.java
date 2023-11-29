package com.privat.contacts.data.cache;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.privat.contacts.data.cache.model.AddressDb;
import com.privat.contacts.data.cache.model.EmploymentDb;
import com.privat.contacts.data.cache.model.SubscriptionDb;
import com.privat.contacts.data.cache.model.UserDb;
import com.privat.contacts.data.cache.model.UserFullDb;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

@Dao
public interface UsersDao {
    @Transaction
    @Query("SELECT * FROM userdb WHERE favorite=1")
    Observable<List<UserFullDb>> selectFavoriteUsers();
    @Transaction
    @Query("SELECT * FROM userdb WHERE id=:userId")
    Observable<UserFullDb> selectUserById(int userId);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertUserDb(UserDb userDb);
    @Query("DELETE FROM addressdb WHERE userId IN (SELECT u.id FROM userdb AS u WHERE u.favorite=0)")
    Completable deleteTempAddress();
    @Query("DELETE FROM employmentdb WHERE userId IN (SELECT u.id FROM userdb AS u WHERE u.favorite=0)")
    Completable deleteTempEmployment();
    @Query("DELETE FROM subscriptiondb WHERE userId IN (SELECT u.id FROM userdb AS u WHERE u.favorite=0)")
    Completable deleteTempSubscription();
    @Query("DELETE FROM userdb WHERE favorite=0")
    Completable deleteTempUsersData();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertAddressDb(AddressDb addressDb);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertEmploymentDb(EmploymentDb employmentDb);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertSubscriptionDb(SubscriptionDb subscriptionDb);
    @Query("UPDATE UserDb SET favorite = (CASE WHEN favorite=1 THEN 0 ELSE 1 END) WHERE id=:userId")
    Completable changeUserFavorite(int userId);
}
