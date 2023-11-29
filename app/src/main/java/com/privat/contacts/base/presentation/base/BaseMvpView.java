package com.privat.contacts.base.presentation.base;

import android.app.AlertDialog;
import android.content.Context;

import com.privat.contacts.R;
import com.privat.contacts.base.presentation.MvpView;
import com.privat.contacts.base.presentation.Presenter;

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
        new AlertDialog.Builder(requireContext())
                .setTitle(R.string.error)
                .setMessage(throwable.getMessage())
                .setPositiveButton(android.R.string.yes, (dialogInterface, i) -> {
                    dialogInterface.dismiss();
                }).show();
    }
}