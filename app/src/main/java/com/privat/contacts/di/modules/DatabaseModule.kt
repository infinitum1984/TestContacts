package com.privat.contacts.di.modules

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.privat.contacts.data.cache.UsersDao
import com.privat.contacts.data.cache.database.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(context: Context): AppDatabase {
        return databaseBuilder(context, AppDatabase::class.java, "privat_contacts")
                .build()
    }

    @Singleton
    @Provides
    fun provideUsersDao(database: AppDatabase): UsersDao {
        return database.provideUsersDao()
    }
}
