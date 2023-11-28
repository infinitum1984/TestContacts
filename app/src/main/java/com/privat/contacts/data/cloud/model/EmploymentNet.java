package com.privat.contacts.data.cloud.model;

import com.google.gson.annotations.SerializedName;

public class EmploymentNet {
    private final String title;
    @SerializedName("key_skill")
    private final String keySkill;

    public EmploymentNet(String title, String keySkill) {
        this.title = title;
        this.keySkill = keySkill;
    }

    public <T> T map(int userId, Mapper<T> mapper) {
        return mapper.map(userId, title, keySkill);
    }

    public interface Mapper<T> {
        T map(int userId, String title, String keySkill);
    }
}
