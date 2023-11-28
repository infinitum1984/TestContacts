package com.privat.contacts.data.cloud.model;

import com.google.gson.annotations.SerializedName;

public class CreditCardNet {
    @SerializedName("cc_number")
    private final String ccNumber;

    public CreditCardNet(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String cardNumber() {
        return ccNumber;
    }

}
