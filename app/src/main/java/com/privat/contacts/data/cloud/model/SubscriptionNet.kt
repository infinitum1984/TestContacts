package com.privat.contacts.data.cloud.model

import com.google.gson.annotations.SerializedName

class SubscriptionNet(private val plan: String,
                      private val status: String,
                      @field:SerializedName("payment_method") private val paymentMethod: String,
                      private val term: String) {
    fun <T> map(userId: Int, mapper: Mapper<T>): T {
        return mapper.map(userId, plan,
                status,
                paymentMethod,
                term)
    }

    interface Mapper<T> {
        fun map(userId: Int,
                plan: String,
                status: String,
                paymentMethod: String,
                term: String): T
    }
}
