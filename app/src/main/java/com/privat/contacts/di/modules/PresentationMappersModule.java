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

import java.util.List;

import dagger.Binds;
import dagger.Module;

@Module
public interface PresentationMappersModule {
    @Binds
    UserDomain.Mapper<UserItemUi> bindUserDomainItemUi(MapperUserDomainUiItem mapperUserDomainUiItem);

    @Binds
    UserDomain.Mapper<UserDetailsUi> bindUserDomainDetailsUi(MapperUserDomainDetailsUi mapperUserDomainDetailsUi);

    @Binds
    UserDomain.Mapper<List<UserDetailsParamUi>> bindUserDomainParamsUi(MapperUserDomainParamsUi userDomainParamsUi);

    @Binds
    AddressDomain.Mapper<List<UserDetailsParamUi>> bindAddressDomainParamsUi(MapperAddressDomainParamsUi addressDomainParamsUi);

    @Binds
    SubscriptionDomain.Mapper<List<UserDetailsParamUi>> bindSubscriptionDomainParamsUi(MapperSubscriptionDomainParamsUi subscriptionDomainParamsUi);

    @Binds
    EmploymentDomain.Mapper<List<UserDetailsParamUi>> bindEmploymentDomainParamsUi(MapperEmploymentDomainParamsUi mapperEmploymentDomainParamsUi);
}
