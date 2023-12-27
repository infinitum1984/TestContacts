package com.privat.contacts.domain.model

import java.util.LinkedList

interface UserDomain {
    fun id(): Int
    fun photoUrl(): String
    fun <T> map(mapper: Mapper<T>): T
    interface Mapper<T> {
        fun map(id: Int,
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
                subscription: SubscriptionDomain): T
    }

    fun sameId(userId: Int): Boolean

    companion object {
        fun <T> mapList(userDomainList: List<UserDomain>, mapper: Mapper<T>): List<T> {
            val newList: LinkedList<T> = LinkedList()
            for (item in userDomainList) {
                newList.add(item!!.map(mapper))
            }
            return newList
        }
    }
}
