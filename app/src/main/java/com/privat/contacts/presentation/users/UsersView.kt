package com.privat.contacts.presentation.users

import com.privat.contacts.base.presentation.MvpView
import com.privat.contacts.presentation.users.model.UserItemUi

interface UsersView : MvpView {
    fun showUsers(users: List<UserItemUi>)
    fun navigateToUser(userId: Int)
}
