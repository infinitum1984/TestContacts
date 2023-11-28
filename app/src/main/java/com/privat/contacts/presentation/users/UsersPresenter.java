package com.privat.contacts.presentation.users;

import com.privat.contacts.base.presentation.Presenter;

public interface UsersPresenter extends Presenter<UsersView> {
    void fetchNewUser();

    void startObserve();
}
