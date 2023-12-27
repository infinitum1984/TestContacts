package com.privat.contacts.presentation.details.mapper

import com.privat.contacts.domain.model.AddressDomain
import com.privat.contacts.domain.model.EmploymentDomain
import com.privat.contacts.domain.model.SubscriptionDomain
import com.privat.contacts.domain.model.UserDomain
import com.privat.contacts.presentation.details.model.UserDetailsParamUi
import com.privat.contacts.presentation.details.model.base.BaseUserParamUi
import java.util.LinkedList
import javax.inject.Inject

class MapperUserDomainParamsUi @Inject constructor(private val addressParamsMapper: AddressDomain.Mapper<List<UserDetailsParamUi>>,
                                                   private val employmentParamsMapper: EmploymentDomain.Mapper<List<UserDetailsParamUi>>,
                                                   private val subscriptionParamsMapper: SubscriptionDomain.Mapper<List<UserDetailsParamUi>>)
    : UserDomain.Mapper<@JvmSuppressWildcards List<UserDetailsParamUi>> {
    override fun map(id: Int,
                     uid: String,
                     password: String, firstName: String,
                     lastName: String, username: String,
                     email: String, avatar: String,
                     gender: String, phoneNumber: String,
                     socialInsuranceNumber: String,
                     dateOfBirth: String, cardNumber: String,
                     favorite: Boolean, address: AddressDomain,
                     employment: EmploymentDomain,
                     subscription: SubscriptionDomain): List<UserDetailsParamUi> {
        val params = LinkedList<UserDetailsParamUi>()
        params.add(BaseUserParamUi("Id", id.toString()))
        params.add(BaseUserParamUi("Uid", uid))
        params.add(BaseUserParamUi("Password", password))
        params.add(BaseUserParamUi("Username", username))
        params.add(BaseUserParamUi("Email", email))
        params.add(BaseUserParamUi("Gender", gender))
        params.add(BaseUserParamUi("Social insurance number", socialInsuranceNumber))
        params.add(BaseUserParamUi("Date Of Birth", dateOfBirth))
        params.add(BaseUserParamUi("Card number", cardNumber))
        params.addAll(address.map(addressParamsMapper))
        params.addAll(employment.map(employmentParamsMapper))
        params.addAll(subscription.map(subscriptionParamsMapper))
        return params
    }
}
