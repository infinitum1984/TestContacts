package com.privat.contacts.data.cache.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class EmploymentDb {
    @PrimaryKey
    private final int userId;
    @NotNull
    private final String title;
    @NotNull

    private final String keySkill;

    public EmploymentDb(int userId, @NotNull String title, @NotNull String keySkill) {
        this.userId = userId;
        this.title = title;
        this.keySkill = keySkill;
    }

    public int getUserId() {
        return userId;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    @NonNull
    public String getKeySkill() {
        return keySkill;
    }
}
