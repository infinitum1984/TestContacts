package com.privat.contacts.data.cache.model

import androidx.room.Embedded
import androidx.room.Relation
import com.privat.contacts.data.cache.UsersDao
import io.reactivex.Completable
import java.util.LinkedList

class UserFullDb(@Embedded val user: UserDb,
                 @Relation(parentColumn = "id", entityColumn = "userId") val address: AddressDb,
                 @Relation(parentColumn = "id", entityColumn = "userId") val employment: EmploymentDb,
                 @Relation(parentColumn = "id", entityColumn = "userId") val subscription: SubscriptionDb) {
    fun insertNewItem(usersDao: UsersDao): Completable {
        return usersDao.insertUserDb(user)
                .andThen(usersDao.insertAddressDb(address))
                .andThen(usersDao.insertEmploymentDb(employment))
                .andThen(usersDao.insertSubscriptionDb(subscription))
    }

    fun <T> map(mapper: Mapper<T>): T {
        return mapper.map(user, address, employment, subscription)
    }

    interface Mapper<T> {
        fun map(user: UserDb, address: AddressDb, employment: EmploymentDb, subscription: SubscriptionDb): T
    }

    companion object {
        fun <T> mapList(userFullDbs: List<UserFullDb>, mapper: Mapper<T>): List<T> {
            val newList: LinkedList<T> = LinkedList()
            for (item in userFullDbs) {
                newList.add(item.map(mapper))
            }
            return newList
        }
    }
}