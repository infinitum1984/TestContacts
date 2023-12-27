package com.privat.contacts.data.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class SubscriptionDb(@PrimaryKey val userId: Int,
                     val plan: String,
                     val status: String,
                     val paymentMethod: String,
                     val term: String)
