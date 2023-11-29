package com.privat.contacts.presentation.details.mapper;

import androidx.annotation.NonNull;

import com.privat.contacts.domain.model.AddressDomain;
import com.privat.contacts.domain.model.EmploymentDomain;
import com.privat.contacts.domain.model.SubscriptionDomain;
import com.privat.contacts.domain.model.UserDomain;
import com.privat.contacts.presentation.details.model.UserDetailsParamUi;
import com.privat.contacts.presentation.details.model.base.BaseUserParamUi;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

public class MapperUserDomainParamsUi implements UserDomain.Mapper<List<UserDetailsParamUi>> {
    private final AddressDomain.Mapper<List<UserDetailsParamUi>> addressParamsMapper;
    private final EmploymentDomain.Mapper<List<UserDetailsParamUi>> employmentParamsMapper;
    private final SubscriptionDomain.Mapper<List<UserDetailsParamUi>> subscriptionParamsMapper;

    @Inject
    public MapperUserDomainParamsUi(AddressDomain.Mapper<List<UserDetailsParamUi>> addressParams,
                                    EmploymentDomain.Mapper<List<UserDetailsParamUi>> employmentParams,
                                    SubscriptionDomain.Mapper<List<UserDetailsParamUi>> subscriptionParams) {
        this.addressParamsMapper = addressParams;
        this.employmentParamsMapper = employmentParams;
        this.subscriptionParamsMapper = subscriptionParams;
    }

    @NonNull
    @Override
    public List<UserDetailsParamUi> map(int id,
                                        String uid,
                                        String password, String firstName,
                                        String lastName, String username,
                                        String email, String avatar,
                                        String gender, String phoneNumber,
                                        String socialInsuranceNumber,
                                        String dateOfBirth, String cardNumber,
                                        boolean favorite, AddressDomain address,
                                        EmploymentDomain employment,
                                        SubscriptionDomain subscription) {
        LinkedList<UserDetailsParamUi> params = new LinkedList<>();
        params.add(new BaseUserParamUi("Id",String.valueOf(id)));
        params.add(new BaseUserParamUi("Uid",String.valueOf(uid)));
        params.add(new BaseUserParamUi("Password",String.valueOf(password)));
        params.add(new BaseUserParamUi("Username",String.valueOf(username)));
        params.add(new BaseUserParamUi("Email",String.valueOf(email)));
        params.add(new BaseUserParamUi("Gender",String.valueOf(gender)));
        params.add(new BaseUserParamUi("Social insurance number",String.valueOf(socialInsuranceNumber)));
        params.add(new BaseUserParamUi("Date Of Birth",String.valueOf(dateOfBirth)));
        params.add(new BaseUserParamUi("Card number",String.valueOf(cardNumber)));
        params.addAll(address.map(addressParamsMapper));
        params.addAll(employment.map(employmentParamsMapper));
        params.addAll(subscription.map(subscriptionParamsMapper));
        return params;
    }
}