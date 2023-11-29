package com.privat.contacts.base.presentation;

public interface Presenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

}
