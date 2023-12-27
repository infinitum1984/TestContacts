package com.privat.contacts.data.cache.mapper;

import androidx.annotation.NonNull;

import com.privat.contacts.data.cache.model.AddressDb;
import com.privat.contacts.domain.model.AddressDomain;

import javax.inject.Inject;

public class MapperAddressDomainDb implements AddressDomain.Mapper<AddressDb> {
    @Inject
    MapperAddressDomainDb() {

    }

    @NonNull
    @Override
    public AddressDb map(int userId,
                         @NonNull String city,
                         @NonNull String streetName,
                         @NonNull String streetAddress,
                         @NonNull String zipCode,
                         @NonNull String state,
                         @NonNull String country,
                         double coordinateLat,
                         double coordinateLng) {
        return new AddressDb(
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
