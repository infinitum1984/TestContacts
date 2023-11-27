package com.privat.contacts.ui.users;

import com.privat.contacts.base.presentation.Presenter;

public interface UsersPresenter extends Presenter<UsersView> {
    void fetchNewUser();
}
