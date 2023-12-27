package com.privat.contacts.data.cache.mapper

import com.privat.contacts.data.cache.model.AddressDb
import com.privat.contacts.data.cache.model.EmploymentDb
import com.privat.contacts.data.cache.model.SubscriptionDb
import com.privat.contacts.data.cache.model.UserDb
import com.privat.contacts.data.cache.model.UserFullDb
import com.privat.contacts.domain.model.UserDomain
import com.privat.contacts.domain.model.base.BaseAddressDomain
import com.privat.contacts.domain.model.base.BaseEmploymentDomain
import com.privat.contacts.domain.model.base.BaseSubscriptionDomain
import com.privat.contacts.domain.model.base.BaseUserDomain
import javax.inject.Inject

class MapperUserDbDomain @Inject internal constructor() : UserFullDb.Mapper<UserDomain> {
    override fun map(user: UserDb, address: AddressDb, employment: EmploymentDb, subscription: SubscriptionDb): UserDomain {
        return BaseUserDomain(
                user.id,
                user.uid,
                user.password,
                user.firstName,
                user.lastName,
                user.username,
                user.email,
                user.avatar,
                user.gender,
                user.phoneNumber,
                user.socialInsuranceNumber,
                user.dateOfBirth,
                user.cardNumber,
                user.isFavorite,
                BaseAddressDomain(
                        user.id, address.city,
                        address.streetName,
                        address.streetAddress,
                        address.zipCode,
                        address.state,
                        address.country,
                        address.lat,
                        address.lng
                ),  //                new BaseAddressDomain(user.getId(), "",
                //                        "", "", "",
                //                        "", "",0.0,0.0),
                BaseEmploymentDomain(
                        user.id, employment.title, employment.keySkill
                ),  //                new BaseEmploymentDomain(
                //                        user.getId(), "",""
                //                ),
                BaseSubscriptionDomain(
                        user.id, subscription.plan,
                        subscription.status,
                        subscription.paymentMethod,
                        subscription.term
                ) //new BaseSubscriptionDomain(user.getId(), "","","","")
        )
    }
}
