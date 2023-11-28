package com.privat.contacts.data.cache.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class AddressDb {
    @PrimaryKey
    private final int userId;
    private final String city;
    private final String streetName;
    private final String streetAddress;
    private final String zipCode;
    private final String state;
    private final String country;
    private final double lat;
    private final double lng;

    public AddressDb(int userId, String city, String streetName, String streetAddress, String zipCode, String state, String country, double lat, double lng) {
        this.userId = userId;
        this.city = city;
        this.streetName = streetName;
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
        this.lat = lat;
        this.lng = lng;
    }

    public double getLng() {
        return lng;
    }

    public double getLat() {
        return lat;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public int getUserId() {
        return userId;
    }
}
