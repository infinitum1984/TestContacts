package com.privat.contacts.data.cloud.model

import com.google.gson.annotations.SerializedName

class CreditCardNet(@field:SerializedName("cc_number") private val ccNumber: String) {
    fun cardNumber(): String {
        return ccNumber
    }
}
