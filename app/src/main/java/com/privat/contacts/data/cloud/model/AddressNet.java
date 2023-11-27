package com.privat.contacts.data.cloud.model;

import com.google.gson.annotations.SerializedName;

public class AddressNet {
    public String city;
    @SerializedName("street_name")
    public String streetName;
    @SerializedName("street_address")
    public String streetAddress;
    @SerializedName("zip_code")
    public String zipCode;
    @SerializedName("state")
    public String state;
    public String country;
    public CoordinatesNet coordinates;
}
