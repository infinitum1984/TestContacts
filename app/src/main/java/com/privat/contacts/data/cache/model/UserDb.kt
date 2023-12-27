package com.privat.contacts.data.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userdb")
class UserDb(@PrimaryKey val id: Int,
             val uid: String,
             val password: String,
             val firstName: String,
             val lastName: String,
             val username: String,
             val email: String,
             val avatar: String,
             val gender: String,
             val phoneNumber: String,
             val socialInsuranceNumber: String,
             val dateOfBirth: String,
             val cardNumber: String,
             @ColumnInfo(name = "favorite")
             val isFavorite: Boolean)
