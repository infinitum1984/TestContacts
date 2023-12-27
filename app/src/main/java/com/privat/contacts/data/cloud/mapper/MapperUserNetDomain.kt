package com.privat.contacts.data.cloud.mapper

import com.privat.contacts.data.cloud.model.AddressNet
import com.privat.contacts.data.cloud.model.CreditCardNet
import com.privat.contacts.data.cloud.model.EmploymentNet
import com.privat.contacts.data.cloud.model.SubscriptionNet
import com.privat.contacts.data.cloud.model.UserNet
import com.privat.contacts.domain.model.AddressDomain
import com.privat.contacts.domain.model.EmploymentDomain
import com.privat.contacts.domain.model.SubscriptionDomain
import com.privat.contacts.domain.model.UserDomain
import com.privat.contacts.domain.model.base.BaseUserDomain
import javax.inject.Inject

class MapperUserNetDomain @Inject constructor(private val addressDomainMapper: AddressNet.Mapper<AddressDomain>,
                                              private val employmentDomainMapper: EmploymentNet.Mapper<EmploymentDomain>,
                                              private val subscriptionDomainMapper: SubscriptionNet.Mapper<SubscriptionDomain>) : UserNet.Mapper<UserDomain> {
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
                     employment: EmploymentNet,
                     address: AddressNet,
                     creditCard: CreditCardNet,
                     subscription: SubscriptionNet): UserDomain {
        return BaseUserDomain(
                id,
                uid,
                password,
                firstName,
                lastName,
                username,
                email,
                avatar,
                gender,
                phoneNumber,
                socialInsuranceNumber,
                dateOfBirth,
                creditCard.cardNumber(),
                false,
                address.map(id, addressDomainMapper),
                employment.map(id, employmentDomainMapper),
                subscription.map(id, subscriptionDomainMapper)
        )
    }
}
