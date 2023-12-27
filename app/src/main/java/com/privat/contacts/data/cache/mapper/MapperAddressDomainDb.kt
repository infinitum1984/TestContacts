package com.privat.contacts.data.cache.mapper

import com.privat.contacts.data.cache.model.AddressDb
import com.privat.contacts.domain.model.AddressDomain
import javax.inject.Inject

class MapperAddressDomainDb @Inject internal constructor() : AddressDomain.Mapper<AddressDb> {
    override fun map(userId: Int,
                     city: String,
                     streetName: String,
                     streetAddress: String,
                     zipCode: String,
                     state: String,
                     country: String,
                     coordinateLat: Double,
                     coordinateLng: Double): AddressDb {
        return AddressDb(
                userId,
                city,
                streetName,
                streetAddress,
                zipCode,
                state,
                country,
                coordinateLat,
                coordinateLng
        )
    }
}
