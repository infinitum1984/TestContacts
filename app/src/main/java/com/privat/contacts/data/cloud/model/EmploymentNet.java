package com.privat.contacts.data.cloud.model;

import com.google.gson.annotations.SerializedName;

class EmploymentNet {
    public String title;
    @SerializedName("key_skill")
    public String keySkill;

    public EmploymentNet(String title, String keySkill) {
        this.title = title;
        this.keySkill = keySkill;
    }
}
