package com.privat.contacts.di.modules;

import android.content.Context;

import androidx.annotation.NonNull;

import com.privat.contacts.ContactsApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    Context providesContext(@NonNull ContactsApplication application) {
        return application.getApplicationContext();
    }
}
