package com.privat.contacts.di.modules;

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
}
