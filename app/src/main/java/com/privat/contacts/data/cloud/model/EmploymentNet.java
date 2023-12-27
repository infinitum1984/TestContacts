package com.privat.contacts.data.cloud.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class EmploymentNet {
    @NotNull
    private final String title;
    @SerializedName("key_skill")
    @NotNull
    private final String keySkill;

    public EmploymentNet(@NotNull String title, @NotNull String keySkill) {
        this.title = title;
        this.keySkill = keySkill;
    }

    public <T> T map(int userId, @NonNull Mapper<T> mapper) {
        return mapper.map(userId, title, keySkill);
    }

    public interface Mapper<T> {
        T map(int userId, @NotNull String title, @NotNull String keySkill);
    }
}
