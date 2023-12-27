package com.privat.contacts.data.cloud.model

import com.google.gson.annotations.SerializedName

class AddressNet(private val city: String,
                 @field:SerializedName("street_name") private val streetName: String,
                 @field:SerializedName("street_address") private val streetAddress: String,
                 @field:SerializedName("zip_code") private val zipCode: String,
                 @field:SerializedName("state") private val state: String,
                 private val country: String,
                 private val coordinates: CoordinatesNet) {
    fun <T> map(userId: Int, mapper: Mapper<T>): T {
        return mapper.map(
                userId,
                city,
                streetName,
                streetAddress,
                zipCode,
                state,
                country,
                coordinates)
    }

    interface Mapper<T> {
        fun map(userId: Int,
                city: String,
                streetName: String,
                streetAddress: String,
                zipCode: String,
                state: String,
                country: String,
                coordinates: CoordinatesNet): T
    }
}