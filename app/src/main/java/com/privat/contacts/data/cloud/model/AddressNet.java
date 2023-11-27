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
}
