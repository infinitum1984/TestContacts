package com.privat.contacts.data.cloud.mapper;

import androidx.annotation.NonNull;

import com.privat.contacts.data.cloud.model.AddressNet;
import com.privat.contacts.data.cloud.model.CreditCardNet;
import com.privat.contacts.data.cloud.model.EmploymentNet;
import com.privat.contacts.data.cloud.model.SubscriptionNet;
import com.privat.contacts.data.cloud.model.UserNet;
import com.privat.contacts.domain.model.AddressDomain;
import com.privat.contacts.domain.model.EmploymentDomain;
import com.privat.contacts.domain.model.SubscriptionDomain;
import com.privat.contacts.domain.model.UserDomain;
import com.privat.contacts.domain.model.base.BaseUserDomain;

import javax.inject.Inject;

public class MapperUserNetDomain implements UserNet.Mapper<UserDomain> {
    private final AddressNet.Mapper<AddressDomain> addressDomainMapper;
    private final EmploymentNet.Mapper<EmploymentDomain> employmentDomainMapper;
    private final SubscriptionNet.Mapper<SubscriptionDomain> subscriptionDomainMapper;

    @Inject
    public MapperUserNetDomain(AddressNet.Mapper<AddressDomain> addressDomainMapper,
                               EmploymentNet.Mapper<EmploymentDomain> employmentDomainMapper,
                               SubscriptionNet.Mapper<SubscriptionDomain> subscriptionDomainMapper) {
        this.addressDomainMapper = addressDomainMapper;
        this.employmentDomainMapper = employmentDomainMapper;
        this.subscriptionDomainMapper = subscriptionDomainMapper;
    }

    @NonNull
    @Override
    public UserDomain map(int id,
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
                          @NonNull EmploymentNet employment,
                          @NonNull AddressNet address,
                          @NonNull CreditCardNet creditCard,
                          @NonNull SubscriptionNet subscription) {
        return new BaseUserDomain(
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
                creditCard.cardNumber(),
                false,
                address.map(id, addressDomainMapper),
                employment.map(id, employmentDomainMapper),
                subscription.map(id, subscriptionDomainMapper)
        );
    }
}
