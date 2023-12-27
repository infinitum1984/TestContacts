package com.privat.contacts.presentation.users

import com.privat.contacts.base.presentation.Presenter

interface UsersPresenter : Presenter<UsersView> {
    fun fetchNewUser()
    fun openUser(userId: Int)
    fun clearTempData()
}
