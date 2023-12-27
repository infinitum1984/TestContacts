package com.privat.contacts.presentation.favorite

import com.privat.contacts.base.presentation.MvpView
import com.privat.contacts.presentation.users.model.UserItemUi

interface FavoriteView : MvpView {
    fun showFavoriteList(userItemUis: List<UserItemUi>)
}
