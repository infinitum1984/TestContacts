package com.privat.contacts.data.cloud.mapper;

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

    @Override
    public UserDomain map(int id,
                          String uid,
                          String password,
                          String firstName,
                          String lastName,
                          String username,
                          String email,
                          String avatar,
                          String gender,
                          String phoneNumber,
                          String socialInsuranceNumber,
                          String dateOfBirth,
                          EmploymentNet employment,
                          AddressNet address,
                          CreditCardNet creditCard,
                          SubscriptionNet subscription) {
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
