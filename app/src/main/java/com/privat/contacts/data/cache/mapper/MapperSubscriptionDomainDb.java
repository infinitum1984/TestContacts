package com.privat.contacts.data.cache.mapper;

import androidx.annotation.NonNull;

import com.privat.contacts.data.cache.model.SubscriptionDb;
import com.privat.contacts.domain.model.SubscriptionDomain;

import javax.inject.Inject;

public class MapperSubscriptionDomainDb implements SubscriptionDomain.Mapper<SubscriptionDb> {
    @Inject
    MapperSubscriptionDomainDb() {

    }

    @NonNull
    @Override
    public SubscriptionDb map(int userId,
                              @NonNull String plan,
                              @NonNull String status,
                              @NonNull String paymentMethod,
                              @NonNull String term) {
        return new SubscriptionDb(
                userId,
                plan,
                status,
                paymentMethod,
                term
        );
    }
}
