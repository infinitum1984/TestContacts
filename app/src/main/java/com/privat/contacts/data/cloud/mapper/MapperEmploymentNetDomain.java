package com.privat.contacts.data.cloud.mapper;

import androidx.annotation.NonNull;

import com.privat.contacts.data.cloud.model.EmploymentNet;
import com.privat.contacts.domain.model.EmploymentDomain;
import com.privat.contacts.domain.model.base.BaseEmploymentDomain;

import javax.inject.Inject;

public class MapperEmploymentNetDomain implements EmploymentNet.Mapper<EmploymentDomain> {
    @Inject
    public MapperEmploymentNetDomain() {

    }

    @NonNull
    @Override
    public EmploymentDomain map(int userId, @NonNull String title, @NonNull String keySkill) {
        return new BaseEmploymentDomain(userId, title, keySkill);
    }
}
