package com.privat.contacts.domain.model;

import org.jetbrains.annotations.NotNull;

public interface EmploymentDomain {
    @NotNull
    <T> T map(Mapper<T> mapper);

    interface Mapper<T> {
        @NotNull
        T map(int userId, String title, String keySkill);
    }
}