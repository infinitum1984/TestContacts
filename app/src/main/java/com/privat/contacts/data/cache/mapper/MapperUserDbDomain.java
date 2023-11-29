package com.privat.contacts.data.cache.mapper;

import com.privat.contacts.data.cache.model.AddressDb;
import com.privat.contacts.data.cache.model.EmploymentDb;
import com.privat.contacts.data.cache.model.SubscriptionDb;
import com.privat.contacts.data.cache.model.UserDb;
import com.privat.contacts.data.cache.model.UserFullDb;
import com.privat.contacts.domain.model.UserDomain;
import com.privat.contacts.domain.model.base.BaseAddressDomain;
import com.privat.contacts.domain.model.base.BaseEmploymentDomain;
import com.privat.contacts.domain.model.base.BaseSubscriptionDomain;
import com.privat.contacts.domain.model.base.BaseUserDomain;

import javax.inject.Inject;

public class MapperUserDbDomain implements UserFullDb.Mapper<UserDomain> {
    @Inject
    MapperUserDbDomain() {

    }

    @Override
    public UserDomain map(UserDb user, AddressDb address, EmploymentDb employment, SubscriptionDb subscription) {
        return new BaseUserDomain(
                user.getId(),
                user.getUid(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getEmail(),
                user.getAvatar(),
                user.getGender(),
                user.getPhoneNumber(),
                user.getSocialInsuranceNumber(),
                user.getDateOfBirth(),
                user.getCardNumber(),
                user.isFavorite(),
                new BaseAddressDomain(
                        user.getId(), address.getCity(),
                        address.getStreetName(),
                        address.getStreetAddress(),
                        address.getZipCode(),
                        address.getState(),
                        address.getCountry(),
                        address.getLat(),
                        address.getLng()
                ),
//                new BaseAddressDomain(user.getId(), "",
//                        "", "", "",
//                        "", "",0.0,0.0),
                new BaseEmploymentDomain(
                        user.getId(), employment.getTitle(), employment.getKeySkill()
                ),
//                new BaseEmploymentDomain(
//                        user.getId(), "",""
//                ),
                new BaseSubscriptionDomain(
                        user.getId(), subscription.getPlan(),
                        subscription.getStatus(),
                        subscription.getPaymentMethod(),
                        subscription.getTerm()
                )
                //new BaseSubscriptionDomain(user.getId(), "","","","")
        );
    }
}
