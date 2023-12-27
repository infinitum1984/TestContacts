package com.privat.contacts.data.cloud.model

import com.google.gson.annotations.SerializedName

class UserNet(private val id: Int,
              private val uid: String,
              private val password: String,
              @field:SerializedName("first_name") private val firstName: String,
              @field:SerializedName("last_name") private val lastName: String,
              private val username: String,
              private val email: String,
              private val avatar: String,
              private val gender: String,
              @field:SerializedName("phone_number") private val phoneNumber: String,
              @field:SerializedName("social_insurance_number") private val socialInsuranceNumber: String,
              @field:SerializedName("date_of_birth") private val dateOfBirth: String,
              private val employment: EmploymentNet,
              private val address: AddressNet,
              @field:SerializedName("credit_card") private val creditCard: CreditCardNet,
              private val subscription: SubscriptionNet) {
    fun <T> map(mapper: Mapper<T>): T {
        return mapper.map(id,
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
                employment,
                address,
                creditCard,
                subscription)
    }

    interface Mapper<T> {
        fun map(
                id: Int,
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
                subscription: SubscriptionNet
        ): T
    }
}
