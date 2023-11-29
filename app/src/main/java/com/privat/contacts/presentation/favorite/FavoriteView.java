package com.privat.contacts.presentation.favorite;

import com.privat.contacts.presentation.base.MvpView;
import com.privat.contacts.presentation.users.model.UserItemUi;

import java.util.List;

public interface FavoriteView extends MvpView {
    void showFavoriteList(List<UserItemUi> userItemUis);
}