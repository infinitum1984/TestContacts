package com.privat.contacts;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class ContactsApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.factory().create(this);
    }
}
