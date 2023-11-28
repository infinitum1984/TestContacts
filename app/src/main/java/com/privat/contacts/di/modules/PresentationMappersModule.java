package com.privat.contacts.di.modules;

import com.privat.contacts.domain.model.UserDomain;
import com.privat.contacts.presentation.users.mapper.MapperUserDomainUiItem;
import com.privat.contacts.presentation.users.model.UserItemUi;

import dagger.Binds;
import dagger.Module;

@Module
public interface PresentationMappersModule {
    @Binds
    UserDomain.Mapper<UserItemUi> bindUserDomainItemUi(MapperUserDomainUiItem mapperUserDomainUiItem);
}
