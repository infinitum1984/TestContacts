package com.privat.contacts.data.cloud.mapper;

import androidx.annotation.NonNull;

import com.privat.contacts.data.cloud.model.AddressNet;
import com.privat.contacts.data.cloud.model.CoordinatesNet;
import com.privat.contacts.domain.model.AddressDomain;
import com.privat.contacts.domain.model.base.BaseAddressDomain;

import javax.inject.Inject;

public class MapperAddressNetDomain implements AddressNet.Mapper<AddressDomain> {
    @Inject
    public MapperAddressNetDomain() {

    }

    @NonNull
    @Override
    public AddressDomain map(int userId, @NonNull String city, @NonNull String streetName, @NonNull String streetAddress, @NonNull String zipCode, @NonNull String state, @NonNull String country, @NonNull CoordinatesNet coordinates) {
        return new BaseAddressDomain(
                userId, city,
                streetName,
                streetAddress,
                zipCode,
                state,
                country,
                coordinates.getLat(),
                coordinates.getLng()
        );
    }
}
