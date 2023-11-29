package com.privat.contacts.presentation.base;

public interface Presenter<V extends MvpView> {
    void onAttach(V mvpView);
    void onDetach();
}