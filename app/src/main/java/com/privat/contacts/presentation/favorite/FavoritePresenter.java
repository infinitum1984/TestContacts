package com.privat.contacts.presentation.favorite;

import com.privat.contacts.presentation.base.Presenter;

public interface FavoritePresenter extends Presenter<FavoriteView> {
    void changeFavorite(Integer favoriteClickId);
    void clearTempData();
    void startObserve();
    void stopObserve();
}