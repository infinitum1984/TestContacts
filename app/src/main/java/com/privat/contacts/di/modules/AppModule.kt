package com.privat.contacts.di.modules

import android.content.Context
import com.privat.contacts.ContactsApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun providesContext(application: ContactsApplication): Context {
        return application.applicationContext
    }
}
