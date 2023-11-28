package com.privat.contacts.data.cloud.model;

import com.google.gson.annotations.SerializedName;

public class UserNet {
    private final int id;
    private final String uid;
    private final String password;
    @SerializedName("first_name")
    private final String firstName;
    @SerializedName("last_name")
    private final String lastName;
    private final String username;
    private final String email;
    private final String avatar;
    private final String gender;
    @SerializedName("phone_number")
    private final String phoneNumber;
    @SerializedName("social_insurance_number")
    private final String socialInsuranceNumber;
    @SerializedName("date_of_birth")
    private final String dateOfBirth;
    private final EmploymentNet employment;
    private final AddressNet address;
    @SerializedName("credit_card")
    private final CreditCardNet creditCard;
    private final SubscriptionNet subscription;


    public UserNet(int id,
                   String uid,
                   String password,
                   String firstName,
                   String lastName,
                   String username,
                   String email,
                   String avatar,
                   String gender,
                   String phoneNumber,
                   String socialInsuranceNumber,
                   String dateOfBirth,
                   EmploymentNet employment,
                   AddressNet address,
                   CreditCardNet creditCard,
                   SubscriptionNet subscription) {
        this.id = id;
        this.uid = uid;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.avatar = avatar;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.socialInsuranceNumber = socialInsuranceNumber;
        this.dateOfBirth = dateOfBirth;
        this.employment = employment;
        this.address = address;
        this.creditCard = creditCard;
        this.subscription = subscription;
    }

    public <T> T map(Mapper<T> mapper) {
        return mapper.map(id,
                uid,
                password,
                firstName,
                lastName,
                username,
                email,
                avatar,
                gender,
                phoneNumber,
                socialInsuranceNumber,
                dateOfBirth,
                employment,
                address,
                creditCard,
                subscription);
    }

    public interface Mapper<T> {
        T map(
                int id,
                String uid,
                String password,
                String firstName,
                String lastName,
                String username,
                String email,
                String avatar,
                String gender,
                String phoneNumber,
                String socialInsuranceNumber,
                String dateOfBirth,
                EmploymentNet employment,
                AddressNet address,
                CreditCardNet creditCard,
                SubscriptionNet subscription
        );
    }
}
