package com.privat.contacts.data.cache.mapper;

import androidx.annotation.NonNull;

import com.privat.contacts.data.cache.model.EmploymentDb;
import com.privat.contacts.domain.model.EmploymentDomain;

import javax.inject.Inject;

public class MapperEmploymentDomainDb implements EmploymentDomain.Mapper<EmploymentDb> {
    @Inject
    MapperEmploymentDomainDb() {

    }

    @NonNull
    @Override
    public EmploymentDb map(int userId, @NonNull String title, @NonNull String keySkill) {
        return new EmploymentDb(
                userId, title, keySkill
        );
    }
}
