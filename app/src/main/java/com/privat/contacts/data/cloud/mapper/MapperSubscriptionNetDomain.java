package com.privat.contacts.data.cloud.mapper;

import com.privat.contacts.data.cloud.model.SubscriptionNet;
import com.privat.contacts.domain.model.SubscriptionDomain;
import com.privat.contacts.domain.model.base.BaseSubscriptionDomain;

import javax.inject.Inject;

public class MapperSubscriptionNetDomain implements SubscriptionNet.Mapper<SubscriptionDomain> {
    @Inject
    public MapperSubscriptionNetDomain() {

    }

    @Override
    public SubscriptionDomain map(int userId, String plan, String status, String paymentMethod, String term) {
        return new BaseSubscriptionDomain(userId, plan, status, paymentMethod, term);
    }
}