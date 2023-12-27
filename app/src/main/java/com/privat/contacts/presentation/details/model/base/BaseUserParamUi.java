package com.privat.contacts.presentation.details.model.base;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.privat.contacts.presentation.details.model.UserDetailsParamUi;

import org.jetbrains.annotations.NotNull;

public class BaseUserParamUi implements UserDetailsParamUi {
    @NotNull
    private final String key;
    @NotNull
    private final String value;

    public BaseUserParamUi(@NotNull String key, @NotNull String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void showParam(@NonNull TextView textView) {
        textView.setText(key+": "+value);
    }
}
