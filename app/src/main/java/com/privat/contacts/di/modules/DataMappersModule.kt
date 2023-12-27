package com.privat.contacts.di.modules

import com.privat.contacts.data.cache.mapper.MapperAddressDomainDb
import com.privat.contacts.data.cache.mapper.MapperEmploymentDomainDb
import com.privat.contacts.data.cache.mapper.MapperSubscriptionDomainDb
import com.privat.contacts.data.cache.mapper.MapperUserDbDomain
import com.privat.contacts.data.cache.mapper.MapperUserDomainDb
import com.privat.contacts.data.cache.model.AddressDb
import com.privat.contacts.data.cache.model.EmploymentDb
import com.privat.contacts.data.cache.model.SubscriptionDb
import com.privat.contacts.data.cache.model.UserFullDb
import com.privat.contacts.data.cloud.mapper.MapperAddressNetDomain
import com.privat.contacts.data.cloud.mapper.MapperEmploymentNetDomain
import com.privat.contacts.data.cloud.mapper.MapperSubscriptionNetDomain
import com.privat.contacts.data.cloud.mapper.MapperUserNetDomain
import com.privat.contacts.data.cloud.model.AddressNet
import com.privat.contacts.data.cloud.model.EmploymentNet
import com.privat.contacts.data.cloud.model.SubscriptionNet
import com.privat.contacts.data.cloud.model.UserNet
import com.privat.contacts.domain.model.AddressDomain
import com.privat.contacts.domain.model.EmploymentDomain
import com.privat.contacts.domain.model.SubscriptionDomain
import com.privat.contacts.domain.model.UserDomain
import dagger.Binds
import dagger.Module

@Module
interface DataMappersModule {
    @Binds
    fun bindAddressNetDomainMapper(addressNetDomain: MapperAddressNetDomain): AddressNet.Mapper<AddressDomain>

    @Binds
    fun bindEmploymentNetDomain(employmentNetDomain: MapperEmploymentNetDomain): EmploymentNet.Mapper<EmploymentDomain>

    @Binds
    fun bindSubscriptionNetDomain(subscriptionNetDomain: MapperSubscriptionNetDomain): SubscriptionNet.Mapper<SubscriptionDomain>

    @Binds
    fun bindUserNetDomain(mapperUserNetDomain: MapperUserNetDomain): UserNet.Mapper<UserDomain>

    @Binds
    fun bindUserDbDomain(mapperUserDbDomain: MapperUserDbDomain): UserFullDb.Mapper<UserDomain>

    @Binds
    fun bindUserDomainDb(mapperUserDomainDb: MapperUserDomainDb): UserDomain.Mapper<UserFullDb>

    @Binds
    fun bindAddressDomainDb(mapperAddressDomainDb: MapperAddressDomainDb): AddressDomain.Mapper<AddressDb>

    @Binds
    fun bindEmploymentDomainDb(mapperEmploymentDomainDb: MapperEmploymentDomainDb): EmploymentDomain.Mapper<EmploymentDb>

    @Binds
    fun bindSubscriptionDomainDb(mapperSubscriptionDomainDb: MapperSubscriptionDomainDb): SubscriptionDomain.Mapper<SubscriptionDb>
}
