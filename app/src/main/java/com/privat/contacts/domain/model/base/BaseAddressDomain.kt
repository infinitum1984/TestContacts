package com.privat.contacts.domain.model.base

import com.privat.contacts.domain.model.AddressDomain

class BaseAddressDomain(private val userId: Int,
                        private val city: String,
                        private val streetName: String,
                        private val streetAddress: String,
                        private val zipCode: String,
                        private val state: String,
                        private val country: String,
                        private val coordinateLat: Double,
                        private val coordinateLng: Double) : AddressDomain {
    override fun <T> map(mapper: AddressDomain.Mapper<T>): T {
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
        )
    }
}
