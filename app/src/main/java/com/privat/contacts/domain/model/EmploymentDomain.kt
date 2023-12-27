package com.privat.contacts.domain.model

interface EmploymentDomain {
    fun <T> map(mapper: Mapper<T>): T
    interface Mapper<T> {
        fun map(userId: Int, title: String, keySkill: String): T
    }
}
