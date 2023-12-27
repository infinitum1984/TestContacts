package com.privat.contacts.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.privat.contacts.data.cache.model.AddressDb
import com.privat.contacts.data.cache.model.EmploymentDb
import com.privat.contacts.data.cache.model.SubscriptionDb
import com.privat.contacts.data.cache.model.UserDb
import com.privat.contacts.data.cache.model.UserFullDb
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface UsersDao {
    @Transaction
    @Query("SELECT * FROM userdb WHERE favorite=1")
    fun selectFavoriteUsers(): Observable<List<UserFullDb>>

    @Transaction
    @Query("SELECT * FROM userdb WHERE id=:userId")
    fun selectUserById(userId: Int): Observable<UserFullDb>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUserDb(userDb: UserDb): Completable

    @Query("DELETE FROM addressdb WHERE userId IN (SELECT u.id FROM userdb AS u WHERE u.favorite=0)")
    fun deleteTempAddress(): Completable

    @Query("DELETE FROM employmentdb WHERE userId IN (SELECT u.id FROM userdb AS u WHERE u.favorite=0)")
    fun deleteTempEmployment(): Completable

    @Query("DELETE FROM subscriptiondb WHERE userId IN (SELECT u.id FROM userdb AS u WHERE u.favorite=0)")
    fun deleteTempSubscription(): Completable

    @Query("DELETE FROM userdb WHERE favorite=0")
    fun deleteTempUsersData(): Completable

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAddressDb(addressDb: AddressDb): Completable

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertEmploymentDb(employmentDb: EmploymentDb): Completable

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertSubscriptionDb(subscriptionDb: SubscriptionDb): Completable

    @Query("UPDATE UserDb SET favorite = (CASE WHEN favorite=1 THEN 0 ELSE 1 END) WHERE id=:userId")
    fun changeUserFavorite(userId: Int): Completable

    @Query("SELECT id FROM userdb WHERE favorite=0")
    fun selectTempUserIds(): Single<List<Int>>
}
