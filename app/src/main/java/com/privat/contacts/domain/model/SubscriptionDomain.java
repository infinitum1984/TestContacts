package com.privat.contacts.domain.model;

import org.jetbrains.annotations.NotNull;

public interface SubscriptionDomain {
    @NotNull
    <T> T map(Mapper<T> mapper);

    interface Mapper<T> {
        @NotNull
        T map(
                int userId,
                String plan,
                String status,
                String paymentMethod,
                String term);
    }
}
