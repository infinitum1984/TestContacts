package com.privat.contacts.data.cloud.model;

import com.google.gson.annotations.SerializedName;

public class UserNet {
    public String id;
    public String uid;
    public String password;
    @SerializedName("first_name")
    public String firstName;
    @SerializedName("last_name")
    public String lastName;
    public String username;
    public String email;
    public String avatar;
    public String gender;
    @SerializedName("phone_number")
    public String phoneNumber;
    @SerializedName("social_insurance_number")
    public String socialInsuranceNumber;
    @SerializedName("date_of_birth")
    public String dateOfBirth;
    public EmploymentNet employment;
    public AddressNet address;
    @SerializedName("credit_card")
    public CreditCardNet creditCard;
    public SubscriptionNet subscription;
}
