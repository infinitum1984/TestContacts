package com.privat.contacts.domain.model.base;

import androidx.annotation.NonNull;

import com.privat.contacts.domain.model.AddressDomain;

public class BaseAddressDomain implements AddressDomain {
    private final int userId;
    private final String city;
    private final String streetName;
    private final String streetAddress;
    private final String zipCode;
    private final String state;
    private final String country;
    private final double coordinateLat;
    private final double coordinateLng;

    public BaseAddressDomain(int userId, String city, String streetName, String streetAddress, String zipCode, String state, String country, double coordinateLat, double coordinateLng) {
        this.userId = userId;
        this.city = city;
        this.streetName = streetName;
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
        this.coordinateLat = coordinateLat;
        this.coordinateLng = coordinateLng;
    }

    @NonNull
    @Override
    public <T> T map(Mapper<T> mapper) {
        return mapper.map(
                userId,
                city,
                streetName,
                streetAddress,
                zipCode,
                state,
                country,
                coordinateLat,
                coordinateLng
        );
    }
}
