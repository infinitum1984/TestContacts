package com.privat.contacts.di.modules;

import com.privat.contacts.domain.model.AddressDomain;
import com.privat.contacts.domain.model.EmploymentDomain;
import com.privat.contacts.domain.model.SubscriptionDomain;
import com.privat.contacts.domain.model.UserDomain;
import com.privat.contacts.presentation.details.mapper.MapperAddressDomainParamsUi;
import com.privat.contacts.presentation.details.mapper.MapperEmploymentDomainParamsUi;
import com.privat.contacts.presentation.details.mapper.MapperSubscriptionDomainParamsUi;
import com.privat.contacts.presentation.details.mapper.MapperUserDomainDetailsUi;
import com.privat.contacts.presentation.details.mapper.MapperUserDomainParamsUi;
import com.privat.contacts.presentation.details.model.UserDetailsParamUi;
import com.privat.contacts.presentation.details.model.UserDetailsUi;
import com.privat.contacts.presentation.users.mapper.MapperUserDomainUiItem;
import com.privat.contacts.presentation.users.model.UserItemUi;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import dagger.Binds;
import dagger.Module;

@Module
public interface PresentationMappersModule {
    @NotNull
    @Binds
    UserDomain.Mapper<UserItemUi> bindUserDomainItemUi(@NotNull MapperUserDomainUiItem mapperUserDomainUiItem);
    @NotNull
    @Binds
    UserDomain.Mapper<UserDetailsUi> bindUserDomainDetailsUi(@NotNull MapperUserDomainDetailsUi mapperUserDomainDetailsUi);
    @NotNull
    @Binds
    UserDomain.Mapper<List<UserDetailsParamUi>> bindUserDomainParamsUi(@NotNull MapperUserDomainParamsUi userDomainParamsUi);
    @NotNull
    @Binds
    AddressDomain.Mapper<List<UserDetailsParamUi>> bindAddressDomainParamsUi(@NotNull MapperAddressDomainParamsUi addressDomainParamsUi);
    @NotNull
    @Binds
    SubscriptionDomain.Mapper<List<UserDetailsParamUi>> bindSubscriptionDomainParamsUi(MapperSubscriptionDomainParamsUi subscriptionDomainParamsUi);
    @NotNull
    @Binds
    EmploymentDomain.Mapper<List<UserDetailsParamUi>> bindEmploymentDomainParamsUi(MapperEmploymentDomainParamsUi mapperEmploymentDomainParamsUi);
}
