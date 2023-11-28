package com.privat.contacts.data.cache.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SubscriptionDb {
    @PrimaryKey
    private final int userId;
    private final String plan;
    private final String status;
    private final String paymentMethod;
    private final String term;

    public SubscriptionDb(int userId, String plan, String status, String paymentMethod, String term) {
        this.userId = userId;
        this.plan = plan;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.term = term;
    }

    public String getTerm() {
        return term;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public String getPlan() {
        return plan;
    }

    public int getUserId() {
        return userId;
    }
}
