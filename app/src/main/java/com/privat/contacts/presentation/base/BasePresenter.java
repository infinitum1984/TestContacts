package com.privat.contacts.presentation.base;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<T extends MvpView> implements Presenter<T> {
    protected final CompositeDisposable compositeDisposable = new CompositeDisposable();
    protected T mvpView;
    @Override
    public void onDetach() {
        compositeDisposable.dispose();
        mvpView = null;
    }
    @Override
    public void onAttach(T mvpView) {
        this.mvpView = mvpView;
    }
}