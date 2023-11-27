package com.privat.contacts.data.cloud.model;

import com.google.gson.annotations.SerializedName;

public class SubscriptionNet {
    String plan;
    String status;
    @SerializedName("payment_method")
    String paymentMethod;
    String term;
}
