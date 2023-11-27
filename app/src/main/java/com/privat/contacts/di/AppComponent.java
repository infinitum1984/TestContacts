package com.privat.contacts.di;

import com.privat.contacts.ContactsApplication;
import com.privat.contacts.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = NetworkModule.class)
public interface AppComponent extends AndroidInjector<ContactsApplication> {
    @Component.Factory
    abstract class Factory implements AndroidInjector.Factory<ContactsApplication> {

    }
}
