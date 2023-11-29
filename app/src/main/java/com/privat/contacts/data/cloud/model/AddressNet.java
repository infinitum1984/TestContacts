package com.privat.contacts.data.cloud.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class AddressNet {
    @NotNull
    private final String city;
    @NotNull
    @SerializedName("street_name")
    private final String streetName;
    @NotNull
    @SerializedName("street_address")
    private final String streetAddress;
    @NotNull
    @SerializedName("zip_code")
    private final String zipCode;
    @NotNull
    @SerializedName("state")
    private final String state;
    @NotNull
    private final String country;
    @NotNull
    private final CoordinatesNet coordinates;
    public AddressNet(@NonNull String city,
                      @NonNull String streetName,
                      @NonNull String streetAddress,
                      @NonNull String zipCode,
                      @NonNull String state,
                      @NonNull String country,
                      @NonNull CoordinatesNet coordinates) {
        this.city = city;
        this.streetName = streetName;
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
        this.coordinates = coordinates;
    }
    public <T> T map(int userId, Mapper<T> mapper) {
        return mapper.map(
                userId,
                city,
                streetName,
                streetAddress,
                zipCode,
                state,
                country,
                coordinates);
    }
    public interface Mapper<T> {
        T map(int userId,
              @NonNull String city,
              @NonNull String streetName,
              @NonNull String streetAddress,
              @NonNull String zipCode,
              @NonNull String state,
              @NonNull String country,
              @NonNull CoordinatesNet coordinates);
    }
}