package com.privat.contacts.presentation.details.mapper

import com.privat.contacts.domain.model.EmploymentDomain
import com.privat.contacts.presentation.details.model.UserDetailsParamUi
import com.privat.contacts.presentation.details.model.base.BaseUserParamUi
import java.util.LinkedList
import javax.inject.Inject

class MapperEmploymentDomainParamsUi @Inject internal constructor() : EmploymentDomain.Mapper<@JvmSuppressWildcards List<UserDetailsParamUi>> {
    override fun map(userId: Int, title: String, keySkill: String): List<UserDetailsParamUi> {
        val params = LinkedList<UserDetailsParamUi>()
        params.add(BaseUserParamUi("employment title", title))
        params.add(BaseUserParamUi("employment skill", keySkill))
        return params
    }
}
