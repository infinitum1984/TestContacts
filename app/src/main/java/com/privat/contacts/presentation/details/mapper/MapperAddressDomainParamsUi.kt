package com.privat.contacts.presentation.details.mapper

import com.privat.contacts.domain.model.AddressDomain
import com.privat.contacts.presentation.details.model.UserDetailsParamUi
import com.privat.contacts.presentation.details.model.base.BaseUserParamUi
import java.util.LinkedList
import javax.inject.Inject

class MapperAddressDomainParamsUi @Inject internal constructor() : AddressDomain.Mapper<@JvmSuppressWildcards List<UserDetailsParamUi>> {
    override fun map(userId: Int,
                     city: String,
                     streetName: String,
                     streetAddress: String,
                     zipCode: String,
                     state: String,
                     country: String,
                     coordinateLat: Double,
                     coordinateLng: Double): List<UserDetailsParamUi> {
        val params = LinkedList<UserDetailsParamUi>()
        params.add(BaseUserParamUi("city", city))
        params.add(BaseUserParamUi("Street name", streetName))
        params.add(BaseUserParamUi("Street address", streetAddress))
        params.add(BaseUserParamUi("Zip code", zipCode))
        params.add(BaseUserParamUi("country", country))
        params.add(BaseUserParamUi("coordinates", "$coordinateLat, $coordinateLng"))
        return params
    }
}
