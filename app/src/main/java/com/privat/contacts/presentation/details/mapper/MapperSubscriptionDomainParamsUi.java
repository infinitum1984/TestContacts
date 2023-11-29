package com.privat.contacts.presentation.details.mapper;

import androidx.annotation.NonNull;

import com.privat.contacts.domain.model.EmploymentDomain;
import com.privat.contacts.domain.model.SubscriptionDomain;
import com.privat.contacts.presentation.details.model.UserDetailsParamUi;
import com.privat.contacts.presentation.details.model.base.BaseUserParamUi;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

public class MapperSubscriptionDomainParamsUi implements SubscriptionDomain.Mapper<List<UserDetailsParamUi>> {
    @Inject
    MapperSubscriptionDomainParamsUi(){
    }
    @NonNull
    @Override
    public List<UserDetailsParamUi> map(int userId, String plan, String status, String paymentMethod, String term) {
        LinkedList<UserDetailsParamUi> params = new LinkedList<>();
        params.add(new BaseUserParamUi("subscription plan", plan));
        params.add(new BaseUserParamUi("subscription status", status));
        params.add(new BaseUserParamUi("subscription payment method", paymentMethod));
        params.add(new BaseUserParamUi("subscription term", term));
        return params;
    }
}
