package com.privat.contacts.domain.model.base;

import androidx.annotation.NonNull;

import com.privat.contacts.domain.model.AddressDomain;

import org.jetbrains.annotations.NotNull;

public class BaseAddressDomain implements AddressDomain {
    @NotNull
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
    private final double coordinateLat;
    @NotNull
    private final double coordinateLng;

    public BaseAddressDomain(int userId,
                             @NotNull String city,
                             @NotNull String streetName,
                             @NotNull String streetAddress,
                             @NotNull String zipCode,
                             @NotNull String state,
                             @NotNull String country,
                             double coordinateLat,
                             double coordinateLng) {
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
