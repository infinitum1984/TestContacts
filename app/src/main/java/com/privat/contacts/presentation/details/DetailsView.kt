package com.privat.contacts.presentation.details

import com.privat.contacts.base.presentation.MvpView
import com.privat.contacts.presentation.details.model.UserDetailsParamUi
import com.privat.contacts.presentation.details.model.UserDetailsUi

interface DetailsView : MvpView {
    fun showUser(userDetailsUi: UserDetailsUi)
    fun showUserParams(userDetailsParamUiList: List<UserDetailsParamUi>)
    fun userId(): Int
}
