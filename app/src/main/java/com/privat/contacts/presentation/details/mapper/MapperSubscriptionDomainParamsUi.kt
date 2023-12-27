package com.privat.contacts.presentation.details.mapper

import com.privat.contacts.domain.model.SubscriptionDomain
import com.privat.contacts.presentation.details.model.UserDetailsParamUi
import com.privat.contacts.presentation.details.model.base.BaseUserParamUi
import java.util.LinkedList
import javax.inject.Inject

class MapperSubscriptionDomainParamsUi @Inject internal constructor() : SubscriptionDomain.Mapper<@JvmSuppressWildcards List<UserDetailsParamUi>> {
    override fun map(userId: Int, plan: String, status: String, paymentMethod: String, term: String): List<UserDetailsParamUi> {
        val params = LinkedList<UserDetailsParamUi>()
        params.add(BaseUserParamUi("subscription plan", plan))
        params.add(BaseUserParamUi("subscription status", status))
        params.add(BaseUserParamUi("subscription payment method", paymentMethod))
        params.add(BaseUserParamUi("subscription term", term))
        return params
    }
}
