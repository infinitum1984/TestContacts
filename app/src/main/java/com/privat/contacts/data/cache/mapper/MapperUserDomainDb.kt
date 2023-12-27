package com.privat.contacts.data.cache.mapper

import com.privat.contacts.data.cache.model.AddressDb
import com.privat.contacts.data.cache.model.EmploymentDb
import com.privat.contacts.data.cache.model.SubscriptionDb
import com.privat.contacts.data.cache.model.UserDb
import com.privat.contacts.data.cache.model.UserFullDb
import com.privat.contacts.domain.model.AddressDomain
import com.privat.contacts.domain.model.EmploymentDomain
import com.privat.contacts.domain.model.SubscriptionDomain
import com.privat.contacts.domain.model.UserDomain
import javax.inject.Inject

class MapperUserDomainDb @Inject internal constructor(private val addressDbMapper: AddressDomain.Mapper<AddressDb>,
                                                      private val employmentDbMapper: EmploymentDomain.Mapper<EmploymentDb>,
                                                      private val subscriptionDbMapper: SubscriptionDomain.Mapper<SubscriptionDb>) : UserDomain.Mapper<UserFullDb> {
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
                     subscription: SubscriptionDomain): UserFullDb {
        return UserFullDb(
                UserDb(
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
                        cardNumber,
                        false
                ),
                address.map(addressDbMapper),
                employment.map(employmentDbMapper),
                subscription.map(subscriptionDbMapper)
        )
    }
}
