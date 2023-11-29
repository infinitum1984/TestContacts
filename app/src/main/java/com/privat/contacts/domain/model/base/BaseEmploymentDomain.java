package com.privat.contacts.domain.model.base;

import androidx.annotation.NonNull;

import com.privat.contacts.domain.model.EmploymentDomain;

import org.jetbrains.annotations.NotNull;

public class BaseEmploymentDomain implements EmploymentDomain {
    @NotNull
    private final int userId;
    @NotNull
    private final String title;
    @NotNull
    private final String keySkill;

    public BaseEmploymentDomain(int userId, @NotNull String title, @NotNull String keySkill) {
        this.userId = userId;
        this.title = title;
        this.keySkill = keySkill;
    }

    @NonNull
    @Override
    public <T> T map(Mapper<T> mapper) {
        return mapper.map(userId, title, keySkill);
    }
}