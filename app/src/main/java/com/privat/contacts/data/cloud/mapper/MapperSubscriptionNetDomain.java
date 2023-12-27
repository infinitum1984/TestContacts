package com.privat.contacts.data.cloud.mapper;

import androidx.annotation.NonNull;

import com.privat.contacts.data.cloud.model.SubscriptionNet;
import com.privat.contacts.domain.model.SubscriptionDomain;
import com.privat.contacts.domain.model.base.BaseSubscriptionDomain;

import javax.inject.Inject;

public class MapperSubscriptionNetDomain implements SubscriptionNet.Mapper<SubscriptionDomain> {
    @Inject
    public MapperSubscriptionNetDomain() {

    }

    @NonNull
    @Override
    public SubscriptionDomain map(int userId, @NonNull String plan, @NonNull String status, @NonNull String paymentMethod, @NonNull String term) {
        return new BaseSubscriptionDomain(userId, plan, status, paymentMethod, term);
    }
}
