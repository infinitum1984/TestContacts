package com.privat.contacts.data.cloud.model;

import com.google.gson.annotations.SerializedName;

public class SubscriptionNet {
    private final String plan;
    private final String status;
    @SerializedName("payment_method")
    private final String paymentMethod;
    private final String term;

    public SubscriptionNet(String plan,
                           String status,
                           String paymentMethod,
                           String term) {
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
              String plan,
              String status,
              String paymentMethod,
              String term);
    }
}
