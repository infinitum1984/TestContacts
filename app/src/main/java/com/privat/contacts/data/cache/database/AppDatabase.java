package com.privat.contacts.data.cache.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.privat.contacts.data.cache.ContactsDao;

@Database(version = AppDatabase.VERSION, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    final static int VERSION = 0;

    abstract ContactsDao provideContactsDao();
}
