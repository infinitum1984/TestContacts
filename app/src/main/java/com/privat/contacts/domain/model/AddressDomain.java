package com.privat.contacts.domain.model;

import org.jetbrains.annotations.NotNull;

public interface AddressDomain {
    @NotNull
    <T> T map(Mapper<T> mapper);

    interface Mapper<T> {
        @NotNull
        T map(
                int userId,
                String city,
                String streetName,
                String streetAddress,
                String zipCode,
                String state,
                String country,
                double coordinateLat,
                double coordinateLng);
    }
}
