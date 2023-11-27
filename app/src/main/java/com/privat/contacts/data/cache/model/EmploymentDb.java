package com.privat.contacts.data.cache.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class EmploymentDb {
    @PrimaryKey
    public int userId;
    public String title;
    public String keySkill;
}
