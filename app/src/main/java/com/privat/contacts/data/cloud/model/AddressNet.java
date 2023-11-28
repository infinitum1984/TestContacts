package com.privat.contacts.data.cloud.model;

import com.google.gson.annotations.SerializedName;

public class AddressNet {
    private final String city;
    @SerializedName("street_name")
    private final String streetName;
    @SerializedName("street_address")
    private final String streetAddress;
    @SerializedName("zip_code")
    private final String zipCode;
    @SerializedName("state")
    private final String state;
    private final String country;
    private final CoordinatesNet coordinates;

    public AddressNet(String city,
                      String streetName,
                      String streetAddress,
                      String zipCode,
                      String state,
                      String country,
                      CoordinatesNet coordinates) {
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
              String city,
              String streetName,
              String streetAddress,
              String zipCode,
              String state,
              String country,
              CoordinatesNet coordinates);
    }
}