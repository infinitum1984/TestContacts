package com.privat.contacts.di;

import com.privat.contacts.ContactsApplication;
import com.privat.contacts.di.modules.AppModule;
import com.privat.contacts.di.modules.DataMappersModule;
import com.privat.contacts.di.modules.DatabaseModule;
import com.privat.contacts.di.modules.NetworkModule;
import com.privat.contacts.di.modules.PresentationMappersModule;
import com.privat.contacts.di.modules.PresentationModule;
import com.privat.contacts.di.modules.RepositoriesModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        NetworkModule.class,
        DatabaseModule.class,
        RepositoriesModule.class,
        PresentationModule.class,
        DataMappersModule.class,
        PresentationMappersModule.class
})
public interface AppComponent extends AndroidInjector<ContactsApplication> {
    @Component.Factory
    interface Factory extends AndroidInjector.Factory<ContactsApplication> {
    }
}