package com.privat.contacts.di.modules;

import com.privat.contacts.data.BaseUserRepository;
import com.privat.contacts.data.cache.photos.BasePhotosDatasource;
import com.privat.contacts.data.cache.photos.PhotosDatasource;
import com.privat.contacts.domain.UsersRepository;

import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public interface RepositoriesModule {
    @NotNull
    @Singleton
    @Binds
    UsersRepository bindUserRepository(    @NotNull
                                           BaseUserRepository userRepository);

    @Binds
    @NotNull
    PhotosDatasource bindPhotoDatasource(    @NotNull
                                             BasePhotosDatasource photosDatasource);
}
