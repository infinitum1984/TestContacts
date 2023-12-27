package com.privat.contacts.data.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class EmploymentDb(@PrimaryKey val userId: Int, val title: String, val keySkill: String)
