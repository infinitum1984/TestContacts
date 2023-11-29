package com.privat.contacts.data.cache.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class UserDb {
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

    public UserDb(int id,
                  @NonNull String uid,
                  @NonNull String password,
                  @NonNull String firstName,
                  @NonNull String lastName,
                  @NonNull String username,
                  @NonNull String email,
                  @NonNull String avatar,
                  @NonNull String gender,
                  @NonNull String phoneNumber,
                  @NonNull String socialInsuranceNumber,
                  @NonNull String dateOfBirth, @NonNull String cardNumber, boolean favorite) {
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
    }
    public int getId() {
        return id;
    }
    @NonNull
    public String getAvatar() {
        return avatar;
    }
    @NonNull
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    @NonNull
    public String getEmail() {
        return email;
    }
    @NonNull
    public String getFirstName() {
        return firstName;
    }
    @NonNull
    public String getGender() {
        return gender;
    }
    @NonNull
    public String getLastName() {
        return lastName;
    }
    @NonNull
    public String getPassword() {
        return password;
    }
    @NonNull
    public String getPhoneNumber() {
        return phoneNumber;
    }
    @NonNull
    public String getSocialInsuranceNumber() {
        return socialInsuranceNumber;
    }
    @NonNull
    public String getUid() {
        return uid;
    }
    @NonNull
    public String getUsername() {
        return username;
    }
    public boolean isFavorite() {
        return favorite;
    }
    @NonNull
    public String getCardNumber() {
        return cardNumber;
    }
}