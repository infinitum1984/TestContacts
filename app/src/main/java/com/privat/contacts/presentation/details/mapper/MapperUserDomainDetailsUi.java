package com.privat.contacts.presentation.details.mapper;

import androidx.annotation.NonNull;

import com.privat.contacts.domain.model.AddressDomain;
import com.privat.contacts.domain.model.EmploymentDomain;
import com.privat.contacts.domain.model.SubscriptionDomain;
import com.privat.contacts.domain.model.UserDomain;
import com.privat.contacts.presentation.details.model.UserDetailsParamUi;
import com.privat.contacts.presentation.details.model.UserDetailsUi;
import com.privat.contacts.presentation.details.model.base.BaseUserDetailsParamUi;

import java.util.List;

import javax.inject.Inject;

public class MapperUserDomainDetailsUi implements UserDomain.Mapper<UserDetailsUi> {
    private final UserDomain.Mapper<List<UserDetailsParamUi>> userParamsMapper;
    @Inject
    MapperUserDomainDetailsUi(UserDomain.Mapper<List<UserDetailsParamUi>> userParamsMapper){
        this.userParamsMapper = userParamsMapper;
    }
    @NonNull
    @Override
    public UserDetailsUi map(int id,
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
        return new BaseUserDetailsParamUi(
                id, firstName + " " + lastName,
                phoneNumber,
                favorite);
    }
}
