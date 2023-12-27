package com.privat.contacts.presentation.details.mapper

import com.privat.contacts.domain.model.AddressDomain
import com.privat.contacts.domain.model.EmploymentDomain
import com.privat.contacts.domain.model.SubscriptionDomain
import com.privat.contacts.domain.model.UserDomain
import com.privat.contacts.presentation.details.model.UserDetailsParamUi
import com.privat.contacts.presentation.details.model.UserDetailsUi
import com.privat.contacts.presentation.details.model.base.BaseUserDetailsParamUi
import javax.inject.Inject

class MapperUserDomainDetailsUi @Inject internal constructor(private val userParamsMapper: UserDomain.Mapper<List<UserDetailsParamUi>>) : UserDomain.Mapper<UserDetailsUi> {
    override fun map(id: Int,
                     uid: String,
                     password: String,
                     firstName: String,
                     lastName: String,
                     username: String,
                     email: String,
                     avatar: String,
                     gender: String,
                     phoneNumber: String,
                     socialInsuranceNumber: String,
                     dateOfBirth: String,
                     cardNumber: String,
                     favorite: Boolean,
                     address: AddressDomain,
                     employment: EmploymentDomain,
                     subscription: SubscriptionDomain): UserDetailsUi {
        return BaseUserDetailsParamUi(
                id, "$firstName $lastName",
                phoneNumber,
                favorite)
    }
}
