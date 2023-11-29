package com.privat.contacts.data.cloud;

import com.privat.contacts.data.cloud.model.UserNet;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface NetworkApiService {
    @GET("users")
    Single<UserNet> getNewUser();
}