package com.privat.contacts.presentation.details.mapper;

import androidx.annotation.NonNull;

import com.privat.contacts.domain.model.EmploymentDomain;
import com.privat.contacts.presentation.details.model.UserDetailsParamUi;
import com.privat.contacts.presentation.details.model.base.BaseUserParamUi;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

public class MapperEmploymentDomainParamsUi implements EmploymentDomain.Mapper<List<UserDetailsParamUi>> {
    @Inject
    MapperEmploymentDomainParamsUi(){
    }
    @NonNull
    @Override
    public List<UserDetailsParamUi> map(int userId, String title, String keySkill) {
        LinkedList<UserDetailsParamUi> params = new LinkedList<>();
        params.add(new BaseUserParamUi("employment title", title));
        params.add(new BaseUserParamUi("employment skill", keySkill));
        return params;
    }
}