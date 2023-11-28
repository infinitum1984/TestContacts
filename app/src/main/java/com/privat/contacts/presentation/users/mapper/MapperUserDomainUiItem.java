package com.privat.contacts.presentation.users.mapper;

import androidx.annotation.NonNull;

import com.privat.contacts.domain.model.AddressDomain;
import com.privat.contacts.domain.model.EmploymentDomain;
import com.privat.contacts.domain.model.SubscriptionDomain;
import com.privat.contacts.domain.model.UserDomain;
import com.privat.contacts.presentation.users.model.BaseUserItemUi;
import com.privat.contacts.presentation.users.model.UserItemUi;

import javax.inject.Inject;

public class MapperUserDomainUiItem implements UserDomain.Mapper<UserItemUi> {
    @Inject
    MapperUserDomainUiItem() {

    }

    @NonNull
    @Override
    public UserItemUi map(int id,
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
                          String cardNumber,
                          boolean favorite,
                          AddressDomain address,
                          EmploymentDomain employment,
                          SubscriptionDomain subscription) {
        return new BaseUserItemUi(
                firstName + " " + lastName, phoneNumber, favorite, avatar
        );
    }
}
