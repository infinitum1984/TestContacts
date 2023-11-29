package com.privat.contacts.presentation.users;

import com.privat.contacts.base.presentation.MvpView;
import com.privat.contacts.presentation.users.model.UserItemUi;

import java.util.List;

public interface UsersView extends MvpView {
    void showUsers(List<UserItemUi> users);
    void navigateToUser(int userId);
}