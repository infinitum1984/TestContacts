package com.privat.contacts.domain.model.base

import com.privat.contacts.domain.model.EmploymentDomain

class BaseEmploymentDomain(private val userId: Int, private val title: String, private val keySkill: String) : EmploymentDomain {
    override fun <T> map(mapper: EmploymentDomain.Mapper<T>): T {
        return mapper.map(userId, title, keySkill)
    }
}
