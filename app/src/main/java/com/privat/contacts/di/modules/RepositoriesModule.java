package com.privat.contacts.di.modules;

import com.privat.contacts.data.BaseUserRepository;
import com.privat.contacts.data.cache.photos.BasePhotosDatasource;
import com.privat.contacts.data.cache.photos.PhotosDatasource;
import com.privat.contacts.domain.UsersRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public interface RepositoriesModule {
    @Singleton
    @Binds
    UsersRepository bindUserRepository(BaseUserRepository userRepository);

    @Binds
    PhotosDatasource bindPhotoDatasource(BasePhotosDatasource photosDatasource);
}
