package com.privat.contacts.data.cache.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class AddressDb {
    @PrimaryKey
    private final int userId;
    @NotNull
    private final String city;
    @NotNull
    private final String streetName;
    @NotNull
    private final String streetAddress;
    @NotNull
    private final String zipCode;
    @NotNull
    private final String state;

    @NotNull
    private final String country;
    @NotNull
    private final double lat;
    @NotNull
    private final double lng;

    public AddressDb(int userId, @NonNull String city,
                     @NonNull String streetName,
                     @NonNull String streetAddress,
                     @NonNull String zipCode,
                     @NonNull String state,
                     @NonNull String country,
                     double lat, double lng) {
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

    @NonNull
    public String getCountry() {
        return country;
    }

    @NonNull
    public String getState() {
        return state;
    }

    @NonNull
    public String getZipCode() {
        return zipCode;
    }

    @NonNull
    public String getStreetAddress() {
        return streetAddress;
    }

    @NonNull
    public String getStreetName() {
        return streetName;
    }

    @NotNull
    public String getCity() {
        return city;
    }

    public int getUserId() {
        return userId;
    }
}
