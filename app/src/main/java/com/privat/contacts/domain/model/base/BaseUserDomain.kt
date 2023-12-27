package com.privat.contacts.domain.model.base

import androidx.room.PrimaryKey
import com.privat.contacts.domain.model.AddressDomain
import com.privat.contacts.domain.model.EmploymentDomain
import com.privat.contacts.domain.model.SubscriptionDomain
import com.privat.contacts.domain.model.UserDomain

class BaseUserDomain(@field:PrimaryKey private val id: Int,
                     private val uid: String,
                     private val password: String,
                     private val firstName: String,
                     private val lastName: String,
                     private val username: String,
                     private val email: String,
                     private val avatar: String,
                     private val gender: String,
                     private val phoneNumber: String,
                     private val socialInsuranceNumber: String,
                     private val dateOfBirth: String,
                     private val cardNumber: String,
                     private val favorite: Boolean,
                     private val address: AddressDomain,
                     private val employment: EmploymentDomain,
                     private val subscription: SubscriptionDomain) : UserDomain {
    override fun id(): Int {
        return id
    }

    override fun photoUrl(): String {
        return avatar
    }

    override fun <T> map(mapper: UserDomain.Mapper<T>): T {
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
                cardNumber,
                favorite,
                address,
                employment,
                subscription)
    }

    override fun sameId(userId: Int): Boolean {
        return id == userId
    }
}
