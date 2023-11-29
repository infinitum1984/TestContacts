package com.privat.contacts.presentation.favorite;

import android.util.Log;

import com.privat.contacts.base.presentation.base.BasePresenter;
import com.privat.contacts.domain.UsersRepository;
import com.privat.contacts.domain.model.UserDomain;
import com.privat.contacts.presentation.users.model.UserItemUi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BaseFavoritePresenter extends BasePresenter<FavoriteView> implements FavoritePresenter {
    private final UsersRepository usersRepository;
    private final UserDomain.Mapper<UserItemUi> userItemUiMapper;

    @Inject
    BaseFavoritePresenter(UsersRepository usersRepository, UserDomain.Mapper<UserItemUi> userItemUiMapper) {
        this.usersRepository = usersRepository;
        this.userItemUiMapper = userItemUiMapper;
    }

    @Override
    public void onAttach(FavoriteView mvpView) {
        super.onAttach(mvpView);
        startObserve();
    }

    @Override
    public void changeFavorite(Integer userId) {
        compositeDisposable.add(usersRepository.changeUserFavorite(userId)
                .andThen(usersRepository.clearTempData())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        () -> {
                        },
                        error -> {
                            mvpView.showError(error);
                            Log.e("BaseFavoritePresenter", "error: " + error.getMessage());
                        }
                ));
    }

    @Override
    public void clearTempData() {
        compositeDisposable.add(usersRepository.clearTempData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                        () -> {
                        }, error -> {
                            mvpView.showError(error);
                            Log.e("BaseFavoritePresenter", "error: " + error.getMessage());
                        }
                ));
    }

    private void startObserve() {
        compositeDisposable.add(usersRepository.favoriteUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::showItems, error -> {
                    mvpView.showError(error);
                    Log.e("BaseFavoritePresenter", "error: " + error.getMessage());
                }));
    }

    private void showItems(List<UserDomain> items) {
        mvpView.showFavoriteList(UserDomain.mapList(items, userItemUiMapper));
    }
}