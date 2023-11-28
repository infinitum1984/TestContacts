package com.privat.contacts.domain.model.base;

import androidx.annotation.NonNull;

import com.privat.contacts.domain.model.SubscriptionDomain;

public class BaseSubscriptionDomain implements SubscriptionDomain {
    private final String plan;
    private final String status;
    private final String paymentMethod;
    private final String term;

    public BaseSubscriptionDomain(String plan, String status, String paymentMethod, String term) {
        this.plan = plan;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.term = term;
    }

    @NonNull
    @Override
    public <T> T map(Mapper<T> mapper) {
        return mapper.map(plan, status, paymentMethod, term);
    }
}
