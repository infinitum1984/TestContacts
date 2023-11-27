package com.privat.contacts.data.cache.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CreditCardDb {
    @PrimaryKey
    public int userId;
    public String ccNumber;
}
