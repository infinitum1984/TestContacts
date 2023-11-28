package com.privat.contacts.domain.model.base;

import androidx.annotation.NonNull;

import com.privat.contacts.domain.model.SubscriptionDomain;

public class BaseSubscriptionDomain implements SubscriptionDomain {
    private final int userId;
    private final String plan;
    private final String status;
    private final String paymentMethod;
    private final String term;

    public BaseSubscriptionDomain(int userId, String plan, String status, String paymentMethod, String term) {
        this.userId = userId;
        this.plan = plan;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.term = term;
    }

    @NonNull
    @Override
    public <T> T map(Mapper<T> mapper) {
        return mapper.map(userId, plan, status, paymentMethod, term);
    }
}
