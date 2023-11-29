package com.privat.contacts.base.presentation;

import android.content.Context;

import dagger.android.support.DaggerFragment;

public abstract class BaseMvpView<T extends Presenter> extends DaggerFragment implements MvpView {
    abstract protected T presenter();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter().onAttach(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter().onDetach();
    }

    @Override
    public void showError(Throwable throwable) {
    }
}