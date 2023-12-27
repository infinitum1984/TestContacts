package com.privat.contacts.presentation.favorite

import com.privat.contacts.base.presentation.Presenter

interface FavoritePresenter : Presenter<FavoriteView> {
    fun changeFavorite(favoriteClickId: Int)
    fun clearTempData()
}
