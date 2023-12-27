package com.privat.contacts.data.cloud.mapper

import com.privat.contacts.data.cloud.model.EmploymentNet
import com.privat.contacts.domain.model.EmploymentDomain
import com.privat.contacts.domain.model.base.BaseEmploymentDomain
import javax.inject.Inject

class MapperEmploymentNetDomain @Inject constructor() : EmploymentNet.Mapper<EmploymentDomain> {
    override fun map(userId: Int, title: String, keySkill: String): EmploymentDomain {
        return BaseEmploymentDomain(userId, title, keySkill)
    }
}
