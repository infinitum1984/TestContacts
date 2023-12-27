package com.privat.contacts.presentation.users.mapper

import com.privat.contacts.domain.model.AddressDomain
import com.privat.contacts.domain.model.EmploymentDomain
import com.privat.contacts.domain.model.SubscriptionDomain
import com.privat.contacts.domain.model.UserDomain
import com.privat.contacts.presentation.users.model.BaseUserItemUi
import com.privat.contacts.presentation.users.model.UserItemUi
import javax.inject.Inject

class MapperUserDomainUiItem @Inject internal constructor() : UserDomain.Mapper<UserItemUi> {
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
                     subscription: SubscriptionDomain): UserItemUi {
        return BaseUserItemUi(
                id, "$firstName $lastName", phoneNumber, avatar
        )
    }
}
