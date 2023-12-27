package com.privat.contacts.data.cloud

import com.privat.contacts.data.cloud.model.UserNet
import io.reactivex.Single
import retrofit2.http.GET

interface NetworkApiService {
    @get:GET("users")
    val newUser: Single<UserNet>
}
