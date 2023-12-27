package com.privat.contacts.di.modules

import com.privat.contacts.domain.model.AddressDomain
import com.privat.contacts.domain.model.EmploymentDomain
import com.privat.contacts.domain.model.SubscriptionDomain
import com.privat.contacts.domain.model.UserDomain
import com.privat.contacts.presentation.details.mapper.MapperAddressDomainParamsUi
import com.privat.contacts.presentation.details.mapper.MapperEmploymentDomainParamsUi
import com.privat.contacts.presentation.details.mapper.MapperSubscriptionDomainParamsUi
import com.privat.contacts.presentation.details.mapper.MapperUserDomainDetailsUi
import com.privat.contacts.presentation.details.mapper.MapperUserDomainParamsUi
import com.privat.contacts.presentation.details.model.UserDetailsParamUi
import com.privat.contacts.presentation.details.model.UserDetailsUi
import com.privat.contacts.presentation.users.mapper.MapperUserDomainUiItem
import com.privat.contacts.presentation.users.model.UserItemUi
import dagger.Binds
import dagger.Module

@Module
interface PresentationMappersModule {
    @Binds
    fun bindUserDomainItemUi(mapperUserDomainUiItem: MapperUserDomainUiItem): UserDomain.Mapper<UserItemUi>

    @Binds
    fun bindUserDomainDetailsUi(mapperUserDomainDetailsUi: MapperUserDomainDetailsUi): UserDomain.Mapper<UserDetailsUi>

    @Binds
    fun bindUserDomainParamsUi(userDomainParamsUi: MapperUserDomainParamsUi): UserDomain.Mapper<@JvmSuppressWildcards List<UserDetailsParamUi>>

    @Binds
    fun bindAddressDomainParamsUi(addressDomainParamsUi: MapperAddressDomainParamsUi): AddressDomain.Mapper<@JvmSuppressWildcards List<UserDetailsParamUi>>

    @Binds
    fun bindSubscriptionDomainParamsUi(subscriptionDomainParamsUi: MapperSubscriptionDomainParamsUi): SubscriptionDomain.Mapper<@JvmSuppressWildcards List<UserDetailsParamUi>>

    @Binds
    fun bindEmploymentDomainParamsUi(mapperEmploymentDomainParamsUi: MapperEmploymentDomainParamsUi): EmploymentDomain.Mapper<@JvmSuppressWildcards List<UserDetailsParamUi>>
}
