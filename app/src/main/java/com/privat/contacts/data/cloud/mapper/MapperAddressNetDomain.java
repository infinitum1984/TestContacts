package com.privat.contacts.data.cloud.mapper;

import com.privat.contacts.data.cloud.model.AddressNet;
import com.privat.contacts.data.cloud.model.CoordinatesNet;
import com.privat.contacts.domain.model.AddressDomain;
import com.privat.contacts.domain.model.base.BaseAddressDomain;

import javax.inject.Inject;

public class MapperAddressNetDomain implements AddressNet.Mapper<AddressDomain> {
    @Inject
    public MapperAddressNetDomain() {

    }

    @Override
    public AddressDomain map(int userId, String city, String streetName, String streetAddress, String zipCode, String state, String country, CoordinatesNet coordinates) {
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
