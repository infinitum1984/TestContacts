package com.privat.contacts.data.cloud.model;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class SubscriptionNet {
    @NotNull
    private final String plan;
    @NotNull
    private final String status;
    @SerializedName("payment_method")
    @NotNull
    private final String paymentMethod;
    @NotNull
    private final String term;

    public SubscriptionNet(@NotNull String plan,
                           @NotNull String status,
                           @NotNull String paymentMethod,
                           @NotNull String term) {
        this.plan = plan;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.term = term;
    }

    public <T> T map(int userId, Mapper<T> mapper) {
        return mapper.map(userId, plan,
                status,
                paymentMethod,
                term);
    }

    public interface Mapper<T> {
        T map(int userId,
              @NotNull String plan,
              @NotNull String status,
              @NotNull String paymentMethod,
              @NotNull String term);
    }
}