package com.privat.contacts.data.cache.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserDb {
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


    public UserDb(int id,
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
                  String dateOfBirth, String cardNumber, boolean favorite) {
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

    public String getAvatar() {
        return avatar;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSocialInsuranceNumber() {
        return socialInsuranceNumber;
    }

    public String getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
