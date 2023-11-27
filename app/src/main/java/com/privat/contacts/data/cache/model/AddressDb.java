package com.privat.contacts.data.cache.model;

import androidx.room.Entity;

@Entity
public class AddressDb {
    public int userId;
    public String city;
    public String streetName;
    public String streetAddress;
    public String zipCode;
    public String state;
    public String country;
}
