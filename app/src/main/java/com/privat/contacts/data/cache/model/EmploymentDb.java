package com.privat.contacts.data.cache.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class EmploymentDb {
    @PrimaryKey
    private final int userId;
    private final String title;
    private final String keySkill;

    public EmploymentDb(int userId, String title, String keySkill) {
        this.userId = userId;
        this.title = title;
        this.keySkill = keySkill;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getKeySkill() {
        return keySkill;
    }
}
