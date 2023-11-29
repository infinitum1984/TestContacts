package com.privat.contacts.data.cloud.model;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class UserNet {
    @NotNull
    private final int id;
    @NotNull
    private final String uid;
    @NotNull
    private final String password;
    @NotNull
    @SerializedName("first_name")
    private final String firstName;
    @NotNull
    @SerializedName("last_name")
    private final String lastName;
    @NotNull
    private final String username;
    @NotNull
    private final String email;
    @NotNull
    private final String avatar;
    @NotNull
    private final String gender;
    @NotNull
    @SerializedName("phone_number")
    private final String phoneNumber;
    @NotNull
    @SerializedName("social_insurance_number")
    private final String socialInsuranceNumber;
    @NotNull
    @SerializedName("date_of_birth")
    private final String dateOfBirth;
    @NotNull
    private final EmploymentNet employment;
    @NotNull
    private final AddressNet address;
    @NotNull
    @SerializedName("credit_card")
    private final CreditCardNet creditCard;
    @NotNull
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