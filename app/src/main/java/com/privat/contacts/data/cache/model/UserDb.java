package com.privat.contacts.data.cache.model;

import androidx.room.Entity;

@Entity
public class UserDb {
    public int id;
    public String uid;
    public String password;
    public String firstName;
    public String lastName;
    public String username;
    public String email;
    public String avatar;
    public String gender;
    public String phoneNumber;
    public String socialInsuranceNumber;
    public String dateOfBirth;
}
