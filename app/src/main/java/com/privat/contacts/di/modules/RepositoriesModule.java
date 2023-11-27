package com.privat.contacts.di.modules;

import com.privat.contacts.data.BaseUserRepository;
import com.privat.contacts.domain.UsersRepository;

import dagger.Binds;
import dagger.Module;

@Module
public interface RepositoriesModule {
    @Binds
    UsersRepository bindUserRepository(BaseUserRepository userRepository);
}
