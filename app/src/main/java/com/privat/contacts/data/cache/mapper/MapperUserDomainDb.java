package com.privat.contacts.data.cache.mapper;

import androidx.annotation.NonNull;

import com.privat.contacts.data.cache.model.AddressDb;
import com.privat.contacts.data.cache.model.EmploymentDb;
import com.privat.contacts.data.cache.model.SubscriptionDb;
import com.privat.contacts.data.cache.model.UserDb;
import com.privat.contacts.data.cache.model.UserFullDb;
import com.privat.contacts.domain.model.AddressDomain;
import com.privat.contacts.domain.model.EmploymentDomain;
import com.privat.contacts.domain.model.SubscriptionDomain;
import com.privat.contacts.domain.model.UserDomain;

import javax.inject.Inject;

public class MapperUserDomainDb implements UserDomain.Mapper<UserFullDb> {
    private final AddressDomain.Mapper<AddressDb> addressDbMapper;
    private final EmploymentDomain.Mapper<EmploymentDb> employmentDbMapper;
    private final SubscriptionDomain.Mapper<SubscriptionDb> subscriptionDbMapper;

    @Inject
    MapperUserDomainDb(AddressDomain.Mapper<AddressDb> addressDbMapper,
                       EmploymentDomain.Mapper<EmploymentDb> employmentDbMapper,
                       SubscriptionDomain.Mapper<SubscriptionDb> subscriptionDbMapper) {

        this.addressDbMapper = addressDbMapper;
        this.employmentDbMapper = employmentDbMapper;
        this.subscriptionDbMapper = subscriptionDbMapper;
    }

    @NonNull
    @Override
    public UserFullDb map(int id,
                          @NonNull String uid,
                          @NonNull String password,
                          @NonNull String firstName,
                          @NonNull String lastName,
                          @NonNull String username,
                          @NonNull String email,
                          @NonNull String avatar,
                          @NonNull String gender,
                          @NonNull String phoneNumber,
                          @NonNull String socialInsuranceNumber,
                          @NonNull String dateOfBirth,
                          @NonNull String cardNumber,
                          boolean favorite,
                          @NonNull AddressDomain address,
                          @NonNull EmploymentDomain employment,
                          @NonNull SubscriptionDomain subscription) {
        return new UserFullDb(
                new UserDb(
                        id,
                        uid,
                        password,
                        firstName,
                        lastName,
                        username,
                        email,
                        avatar,
                        gender,
                        phoneNumber,
                        socialInsuranceNumber,
                        dateOfBirth,
                        cardNumber,
                        false
                ),
                address.map(addressDbMapper),
                employment.map(employmentDbMapper),
                subscription.map(subscriptionDbMapper)
        );
    }
}
