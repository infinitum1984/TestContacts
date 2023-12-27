package com.privat.contacts.di.modules

import com.privat.contacts.data.BaseUserRepository
import com.privat.contacts.data.cache.photos.BasePhotosDatasource
import com.privat.contacts.data.cache.photos.PhotosDatasource
import com.privat.contacts.domain.UsersRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoriesModule {
    @Singleton
    @Binds
    fun bindUserRepository(userRepository: BaseUserRepository): UsersRepository

    @Binds
    fun bindPhotoDatasource(photosDatasource: BasePhotosDatasource): PhotosDatasource
}
