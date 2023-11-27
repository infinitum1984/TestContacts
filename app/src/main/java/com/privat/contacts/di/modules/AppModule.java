package com.privat.contacts.di.modules;

import android.content.Context;

import com.privat.contacts.ContactsApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    Context providesContext(ContactsApplication application) {
        return application.getApplicationContext();
    }
}
