package com.privat.contacts.data.cloud.model

import com.google.gson.annotations.SerializedName

class EmploymentNet(private val title: String, @field:SerializedName("key_skill") private val keySkill: String) {
    fun <T> map(userId: Int, mapper: Mapper<T>): T {
        return mapper.map(userId, title, keySkill)
    }

    interface Mapper<T> {
        fun map(userId: Int, title: String, keySkill: String): T
    }
}
