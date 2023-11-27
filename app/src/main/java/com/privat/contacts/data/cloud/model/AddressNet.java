package com.privat.contacts.data.cloud.model;

import com.google.gson.annotations.SerializedName;

public class AddressNet {
    String city;
    @SerializedName("street_name")
    String streetName;
    @SerializedName("street_address")
    String streetAddress;
    @SerializedName("zip_code")
    String zipCode;
    @SerializedName("state")
    String state;
    String country;
    CoordinatesNet coordinates;
}
