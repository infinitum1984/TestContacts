package com.privat.contacts.domain.model

interface SubscriptionDomain {
    fun <T> map(mapper: Mapper<T>): T
    interface Mapper<T> {
        fun map(
                userId: Int,
                plan: String,
                status: String,
                paymentMethod: String,
                term: String): T
    }
}
