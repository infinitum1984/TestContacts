package com.privat.contacts.domain.model.base;

import androidx.room.PrimaryKey;

import com.privat.contacts.domain.model.AddressDomain;
import com.privat.contacts.domain.model.EmploymentDomain;
import com.privat.contacts.domain.model.SubscriptionDomain;
import com.privat.contacts.domain.model.UserDomain;

public class BaseUserDomain implements UserDomain {
    @PrimaryKey
    private final int id;
    private final String uid;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String email;
    private final String avatar;
    private final String gender;
    private final String phoneNumber;
    private final String socialInsuranceNumber;
    private final String dateOfBirth;
    private final String cardNumber;
    private final boolean favorite;
    private final AddressDomain address;
    private final EmploymentDomain employment;
    private final SubscriptionDomain subscription;

    public BaseUserDomain(int id,
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
                          String cardNumber,
                          boolean favorite,
                          AddressDomain address,
                          EmploymentDomain employment,
                          SubscriptionDomain subscription) {
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
        this.cardNumber = cardNumber;
        this.favorite = favorite;
        this.address = address;
        this.employment = employment;
        this.subscription = subscription;
    }

    @Override
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
                cardNumber,
                favorite,
                address,
                employment,
                subscription);
    }
}
