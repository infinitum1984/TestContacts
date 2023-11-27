package com.privat.contacts.data.cache.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SubscriptionDb {
    @PrimaryKey
    public int userId;
    public String plan;
    public String status;
    public String paymentMethod;
    public String term;
}
