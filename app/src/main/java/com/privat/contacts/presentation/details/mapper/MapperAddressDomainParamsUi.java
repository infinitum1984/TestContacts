package com.privat.contacts.presentation.details.mapper;

import androidx.annotation.NonNull;

import com.privat.contacts.domain.model.AddressDomain;
import com.privat.contacts.presentation.details.model.UserDetailsParamUi;
import com.privat.contacts.presentation.details.model.base.BaseUserParamUi;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

public class MapperAddressDomainParamsUi implements AddressDomain.Mapper<List<UserDetailsParamUi>> {
    @Inject
    MapperAddressDomainParamsUi(){}
    @NonNull
    @Override
    public List<UserDetailsParamUi> map(int userId,
                                        @NonNull String city,
                                        @NonNull String streetName,
                                        @NonNull String streetAddress,
                                        @NonNull String zipCode,
                                        String state,
                                        @NonNull String country,
                                        double coordinateLat,
                                        double coordinateLng) {
        LinkedList<UserDetailsParamUi> params = new LinkedList<>();
        params.add(new BaseUserParamUi("city", city));
        params.add(new BaseUserParamUi("Street name", streetName));
        params.add(new BaseUserParamUi("Street address", streetAddress));
        params.add(new BaseUserParamUi("Zip code", zipCode));
        params.add(new BaseUserParamUi("country", country));
        params.add(new BaseUserParamUi("coordinates", String.valueOf(coordinateLat) + ", " + String.valueOf(coordinateLng)));
        return params;
    }
}
