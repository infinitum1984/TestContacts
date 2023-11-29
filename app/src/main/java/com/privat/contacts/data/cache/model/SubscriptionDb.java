package com.privat.contacts.data.cache.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class SubscriptionDb {
    @PrimaryKey
    private final int userId;
    @NotNull
    private final String plan;
    @NotNull
    private final String status;
    @NotNull
    private final String paymentMethod;
    @NotNull
    private final String term;

    public SubscriptionDb(int userId, @NonNull String plan, @NonNull String status, @NonNull String paymentMethod, @NonNull String term) {
        this.userId = userId;
        this.plan = plan;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.term = term;
    }
    @NonNull
    public String getTerm() {
        return term;
    }
    @NonNull
    public String getPaymentMethod() {
        return paymentMethod;
    }
    @NonNull
    public String getStatus() {
        return status;
    }
    @NonNull
    public String getPlan() {
        return plan;
    }
    public int getUserId() {
        return userId;
    }
}
