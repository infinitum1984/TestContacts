package com.privat.contacts.data.cache.model;

import androidx.room.Entity;

@Entity
public class SubscriptionDb {
    public int userId;
    public String plan;
    public String status;
    public String paymentMethod;
    public String term;
}
