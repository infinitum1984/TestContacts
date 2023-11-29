package com.privat.contacts.presentation.favorite;

import com.privat.contacts.base.presentation.Presenter;

public interface FavoritePresenter extends Presenter<FavoriteView> {
    void changeFavorite(Integer favoriteClickId);

    void clearTempData();

    void startObserve();

    void stopObserve();
}