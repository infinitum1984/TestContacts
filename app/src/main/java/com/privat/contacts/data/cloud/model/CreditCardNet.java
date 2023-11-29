package com.privat.contacts.data.cloud.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class CreditCardNet {
    @NotNull
    @SerializedName("cc_number")
    private final String ccNumber;

    public CreditCardNet(@NonNull String ccNumber) {
        this.ccNumber = ccNumber;
    }

    @NotNull
    public String cardNumber() {
        return ccNumber;
    }

}
