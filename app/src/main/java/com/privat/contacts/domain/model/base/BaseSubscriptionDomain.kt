package com.privat.contacts.domain.model.base

import com.privat.contacts.domain.model.SubscriptionDomain

class BaseSubscriptionDomain(private val userId: Int, private val plan: String, private val status: String, private val paymentMethod: String, private val term: String) : SubscriptionDomain {
    override fun <T> map(mapper: SubscriptionDomain.Mapper<T>): T {
        return mapper.map(userId, plan, status, paymentMethod, term)
    }
}
