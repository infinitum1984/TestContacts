package com.privat.contacts.domain.model.base;

import androidx.annotation.NonNull;

import com.privat.contacts.domain.model.SubscriptionDomain;

import org.jetbrains.annotations.NotNull;

public class BaseSubscriptionDomain implements SubscriptionDomain {
    @NotNull
    private final int userId;
    @NotNull
    private final String plan;
    @NotNull
    private final String status;
    @NotNull
    private final String paymentMethod;
    @NotNull
    private final String term;

    public BaseSubscriptionDomain(int userId, @NotNull String plan, @NotNull String status, @NotNull String paymentMethod, @NotNull String term) {
        this.userId = userId;
        this.plan = plan;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.term = term;
    }

    @NotNull
    @Override
    public <T> T map(@NonNull Mapper<T> mapper) {
        return mapper.map(userId, plan, status, paymentMethod, term);
    }
}
