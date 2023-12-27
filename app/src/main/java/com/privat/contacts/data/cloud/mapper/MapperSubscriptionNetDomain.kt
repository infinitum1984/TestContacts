package com.privat.contacts.data.cloud.mapper

import com.privat.contacts.data.cloud.model.SubscriptionNet
import com.privat.contacts.domain.model.SubscriptionDomain
import com.privat.contacts.domain.model.base.BaseSubscriptionDomain
import javax.inject.Inject

class MapperSubscriptionNetDomain @Inject constructor() : SubscriptionNet.Mapper<SubscriptionDomain> {
    override fun map(userId: Int, plan: String, status: String, paymentMethod: String, term: String): SubscriptionDomain {
        return BaseSubscriptionDomain(userId, plan, status, paymentMethod, term)
    }
}
