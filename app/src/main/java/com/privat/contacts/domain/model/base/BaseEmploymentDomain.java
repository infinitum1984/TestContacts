package com.privat.contacts.domain.model.base;

import androidx.annotation.NonNull;

import com.privat.contacts.domain.model.EmploymentDomain;

public class BaseEmploymentDomain implements EmploymentDomain {
    private final String title;
    private final String keySkill;

    public BaseEmploymentDomain(String title, String keySkill) {
        this.title = title;
        this.keySkill = keySkill;
    }

    @NonNull
    @Override
    public <T> T map(Mapper<T> mapper) {
        return mapper.map(title, keySkill);
    }
}
