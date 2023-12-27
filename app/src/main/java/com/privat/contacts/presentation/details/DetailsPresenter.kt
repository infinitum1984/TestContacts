package com.privat.contacts.presentation.details

import com.privat.contacts.base.presentation.Presenter

interface DetailsPresenter : Presenter<DetailsView> {
    fun changeFavorite()
}
