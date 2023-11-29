package com.privat.contacts.di.modules;

import android.content.Context;

import androidx.room.Room;

import com.privat.contacts.data.cache.UsersDao;
import com.privat.contacts.data.cache.database.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
    @Singleton
    @Provides
    public AppDatabase provideDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "privat_contacts")
                .build();
    }

    @Singleton
    @Provides
    public UsersDao provideUsersDao(AppDatabase database) {
        return database.provideUsersDao();
    }
}
