package com.privat.contacts.data.cloud.mapper

import com.privat.contacts.data.cloud.model.AddressNet
import com.privat.contacts.data.cloud.model.CoordinatesNet
import com.privat.contacts.domain.model.AddressDomain
import com.privat.contacts.domain.model.base.BaseAddressDomain
import javax.inject.Inject

class MapperAddressNetDomain @Inject constructor() : AddressNet.Mapper<AddressDomain> {
    override fun map(userId: Int, city: String, streetName: String, streetAddress: String, zipCode: String, state: String, country: String, coordinates: CoordinatesNet): AddressDomain {
        return BaseAddressDomain(
                userId, city,
                streetName,
                streetAddress,
                zipCode,
                state,
                country,
                coordinates.lat,
                coordinates.lng
        )
    }
}
