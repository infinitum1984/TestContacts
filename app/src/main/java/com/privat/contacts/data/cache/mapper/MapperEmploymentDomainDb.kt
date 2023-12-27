package com.privat.contacts.data.cache.mapper

import com.privat.contacts.data.cache.model.EmploymentDb
import com.privat.contacts.domain.model.EmploymentDomain
import javax.inject.Inject

class MapperEmploymentDomainDb @Inject internal constructor() : EmploymentDomain.Mapper<EmploymentDb> {
    override fun map(userId: Int, title: String, keySkill: String): EmploymentDb {
        return EmploymentDb(
                userId, title, keySkill
        )
    }
}
