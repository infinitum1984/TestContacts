package com.privat.contacts.data.cache.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class AddressDb {
    @PrimaryKey
    public int userId;
    public String city;
    public String streetName;
    public String streetAddress;
    public String zipCode;
    public String state;
    public String country;
}
