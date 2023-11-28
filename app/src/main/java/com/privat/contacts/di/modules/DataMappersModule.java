package com.privat.contacts.di.modules;

import com.privat.contacts.data.cache.mapper.MapperAddressDomainDb;
import com.privat.contacts.data.cache.mapper.MapperEmploymentDomainDb;
import com.privat.contacts.data.cache.mapper.MapperSubscriptionDomainDb;
import com.privat.contacts.data.cache.mapper.MapperUserDbDomain;
import com.privat.contacts.data.cache.mapper.MapperUserDomainDb;
import com.privat.contacts.data.cache.model.AddressDb;
import com.privat.contacts.data.cache.model.EmploymentDb;
import com.privat.contacts.data.cache.model.SubscriptionDb;
import com.privat.contacts.data.cache.model.UserFullDb;
import com.privat.contacts.data.cloud.mapper.MapperAddressNetDomain;
import com.privat.contacts.data.cloud.mapper.MapperEmploymentNetDomain;
import com.privat.contacts.data.cloud.mapper.MapperSubscriptionNetDomain;
import com.privat.contacts.data.cloud.mapper.MapperUserNetDomain;
import com.privat.contacts.data.cloud.model.AddressNet;
import com.privat.contacts.data.cloud.model.EmploymentNet;
import com.privat.contacts.data.cloud.model.SubscriptionNet;
import com.privat.contacts.data.cloud.model.UserNet;
import com.privat.contacts.domain.model.AddressDomain;
import com.privat.contacts.domain.model.EmploymentDomain;
import com.privat.contacts.domain.model.SubscriptionDomain;
import com.privat.contacts.domain.model.UserDomain;

import dagger.Binds;
import dagger.Module;

@Module
public interface DataMappersModule {
    @Binds
    AddressNet.Mapper<AddressDomain> bindAddressNetDomainMapper(MapperAddressNetDomain addressNetDomain);

    @Binds
    EmploymentNet.Mapper<EmploymentDomain> bindEmploymentNetDomain(MapperEmploymentNetDomain employmentNetDomain);

    @Binds
    SubscriptionNet.Mapper<SubscriptionDomain> bindSubscriptionNetDomain(MapperSubscriptionNetDomain subscriptionNetDomain);

    @Binds
    UserNet.Mapper<UserDomain> bindUserNetDomain(MapperUserNetDomain mapperUserNetDomain);

    @Binds
    UserFullDb.Mapper<UserDomain> bindUserDbDomain(MapperUserDbDomain mapperUserDbDomain);

    @Binds
    UserDomain.Mapper<UserFullDb> bindUserDomainDb(MapperUserDomainDb mapperUserDomainDb);

    @Binds
    AddressDomain.Mapper<AddressDb> bindAddressDomainDb(MapperAddressDomainDb mapperAddressDomainDb);

    @Binds
    EmploymentDomain.Mapper<EmploymentDb> bindEmploymentDomainDb(MapperEmploymentDomainDb mapperEmploymentDomainDb);

    @Binds
    SubscriptionDomain.Mapper<SubscriptionDb> bindSubscriptionDomainDb(MapperSubscriptionDomainDb mapperSubscriptionDomainDb);
}
