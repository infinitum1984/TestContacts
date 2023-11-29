package com.privat.contacts.presentation.users;

import com.privat.contacts.presentation.base.Presenter;

public interface UsersPresenter extends Presenter<UsersView> {
    void fetchNewUser();

    void openUser(int userId);

    void clearTempData();

    void startObserve();

    void stopObserve();
}