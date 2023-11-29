package com.privat.contacts.presentation.details.model.base;

import android.widget.TextView;

import com.privat.contacts.presentation.details.model.UserDetailsParamUi;

public class BaseUserParamUi implements UserDetailsParamUi {
    private final String key;
    private final String value;

    public BaseUserParamUi(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void showParam(TextView textView) {
        textView.setText(key+": "+value);
    }
}
