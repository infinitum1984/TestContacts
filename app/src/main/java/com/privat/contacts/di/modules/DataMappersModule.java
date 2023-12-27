package com.privat.contacts.di.modules;

import androidx.annotation.NonNull;

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

import org.jetbrains.annotations.NotNull;

import dagger.Binds;
import dagger.Module;
import kotlin.jvm.JvmWildcard;

@Module
public interface DataMappersModule {
    @NotNull
    @Binds
    AddressNet.Mapper<AddressDomain>  bindAddressNetDomainMapper(@NotNull MapperAddressNetDomain addressNetDomain);

    @NonNull
    @Binds
    EmploymentNet.Mapper<EmploymentDomain> bindEmploymentNetDomain(@NotNull MapperEmploymentNetDomain employmentNetDomain);

    @NotNull
    @Binds
    SubscriptionNet.Mapper<SubscriptionDomain> bindSubscriptionNetDomain(@NotNull MapperSubscriptionNetDomain subscriptionNetDomain);
    @NotNull
    @Binds
    UserNet.Mapper<UserDomain> bindUserNetDomain(@NotNull MapperUserNetDomain mapperUserNetDomain);

    @NotNull
    @Binds
    UserFullDb.Mapper<UserDomain> bindUserDbDomain(@NotNull MapperUserDbDomain mapperUserDbDomain);
    @NotNull
    @Binds
    UserDomain.Mapper<UserFullDb> bindUserDomainDb(@NotNull MapperUserDomainDb mapperUserDomainDb);
    @NotNull
    @Binds
    AddressDomain.Mapper<AddressDb> bindAddressDomainDb(@NotNull MapperAddressDomainDb mapperAddressDomainDb);
    @NotNull
    @Binds
    EmploymentDomain.Mapper<EmploymentDb> bindEmploymentDomainDb(@NotNull MapperEmploymentDomainDb mapperEmploymentDomainDb);
    @NotNull
    @Binds
    SubscriptionDomain.Mapper<SubscriptionDb> bindSubscriptionDomainDb(@NotNull MapperSubscriptionDomainDb mapperSubscriptionDomainDb);
}
