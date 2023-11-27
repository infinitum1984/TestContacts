package com.privat.contacts.data.cloud.model;

import com.google.gson.annotations.SerializedName;

public class UserNet {
    private String id;
    private String uid;
    private String password;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    private String username;
    private String email;
    private String avatar;
    private String gender;
    @SerializedName("phone_number")
    private String phoneNumber;
    @SerializedName("social_insurance_number")
    private String socialInsuranceNumber;
    @SerializedName("date_of_birth")
    private String dateOfBirth;
    private EmploymentNet employment;
    private AddressNet address;
    @SerializedName("credit_card")
    private CreditCardNet creditCard;
    private SubscriptionNet subscription;

    public String data() {
        return firstName;
    }
}
