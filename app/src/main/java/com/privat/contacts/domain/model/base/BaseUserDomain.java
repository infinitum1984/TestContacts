package com.privat.contacts.domain.model.base;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

import com.privat.contacts.domain.model.AddressDomain;
import com.privat.contacts.domain.model.EmploymentDomain;
import com.privat.contacts.domain.model.SubscriptionDomain;
import com.privat.contacts.domain.model.UserDomain;

import org.jetbrains.annotations.NotNull;

public class BaseUserDomain implements UserDomain {
    @PrimaryKey
    private final int id;
    @NotNull
    private final String uid;
    @NotNull
    private final String password;
    @NotNull
    private final String firstName;
    @NotNull
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
    private final String phoneNumber;
    @NotNull
    private final String socialInsuranceNumber;
    @NotNull
    private final String dateOfBirth;
    @NotNull
    private final String cardNumber;
    @NotNull
    private final boolean favorite;
    @NotNull
    private final AddressDomain address;
    @NotNull
    private final EmploymentDomain employment;
    @NotNull
    private final SubscriptionDomain subscription;

    public BaseUserDomain(int id,
                          @NotNull String uid,
                          @NotNull String password,
                          @NotNull String firstName,
                          @NotNull String lastName,
                          @NotNull String username,
                          @NotNull String email,
                          @NotNull String avatar,
                          @NotNull String gender,
                          @NotNull String phoneNumber,
                          @NotNull String socialInsuranceNumber,
                          @NotNull String dateOfBirth,
                          @NotNull String cardNumber,
                          boolean favorite,
                          @NotNull AddressDomain address,
                          @NotNull EmploymentDomain employment,
                          @NotNull SubscriptionDomain subscription) {
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
    public int id() {
        return this.id;
    }

    @NonNull
    @Override
    public String photoUrl() {
        return avatar;
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

    @Override
    public boolean sameId(int userId) {
        return id == userId;
    }
}
