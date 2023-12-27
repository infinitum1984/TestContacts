package com.privat.contacts.domain.model

interface AddressDomain {
    fun <T> map(mapper: Mapper<T>): T
    interface Mapper<T> {
        fun map(
                userId: Int,
                city: String,
                streetName: String,
                streetAddress: String,
                zipCode: String,
                state: String,
                country: String,
                coordinateLat: Double,
                coordinateLng: Double): T
    }
}
