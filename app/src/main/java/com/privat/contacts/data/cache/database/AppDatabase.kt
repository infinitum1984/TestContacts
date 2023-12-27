package com.privat.contacts.data.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.privat.contacts.data.cache.UsersDao
import com.privat.contacts.data.cache.database.AppDatabase
import com.privat.contacts.data.cache.model.AddressDb
import com.privat.contacts.data.cache.model.EmploymentDb
import com.privat.contacts.data.cache.model.SubscriptionDb
import com.privat.contacts.data.cache.model.UserDb

@Database(version = AppDatabase.VERSION, exportSchema = false, entities = [UserDb::class, AddressDb::class, EmploymentDb::class, SubscriptionDb::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun provideUsersDao(): UsersDao

    companion object {
        const val VERSION = 1
    }
}
