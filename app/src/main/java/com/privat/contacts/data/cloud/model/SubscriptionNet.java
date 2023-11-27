package com.privat.contacts.data.cloud.model;

import com.google.gson.annotations.SerializedName;

class SubscriptionNet {
    public String plan;
    public String status;
    @SerializedName("payment_method")
    public String paymentMethod;
    public String term;
}
