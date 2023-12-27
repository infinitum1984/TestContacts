package com.privat.contacts.data.cache.mapper

import com.privat.contacts.data.cache.model.SubscriptionDb
import com.privat.contacts.domain.model.SubscriptionDomain
import javax.inject.Inject

class MapperSubscriptionDomainDb @Inject internal constructor() : SubscriptionDomain.Mapper<SubscriptionDb> {
    override fun map(userId: Int,
                     plan: String,
                     status: String,
                     paymentMethod: String,
                     term: String): SubscriptionDb {
        return SubscriptionDb(
                userId,
                plan,
                status,
                paymentMethod,
                term
        )
    }
}
