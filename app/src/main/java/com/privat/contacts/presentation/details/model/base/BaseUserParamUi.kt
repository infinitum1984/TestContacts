package com.privat.contacts.presentation.details.model.base

import android.widget.TextView
import com.privat.contacts.presentation.details.model.UserDetailsParamUi

class BaseUserParamUi(private val key: String, private val value: String) : UserDetailsParamUi {
    override fun showParam(textView: TextView) {
        textView.text = "$key: $value"
    }
}
