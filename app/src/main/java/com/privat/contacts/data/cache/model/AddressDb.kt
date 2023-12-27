package com.privat.contacts.data.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class AddressDb(@PrimaryKey val userId: Int,
                val city: String,
                val streetName: String,
                val streetAddress: String,
                val zipCode: String,
                val state: String,
                val country: String,
                val lat: Double, @JvmField val lng: Double)
