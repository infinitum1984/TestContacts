package com.privat.contacts.presentation.favorite;

import android.util.Log;

import com.privat.contacts.domain.UsersRepository;
import com.privat.contacts.domain.model.UserDomain;
import com.privat.contacts.presentation.users.model.UserItemUi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class BaseFavoritePresenter implements FavoritePresenter {
    private final UsersRepository usersRepository;
    private final UserDomain.Mapper<UserItemUi> userItemUiMapper;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private FavoriteView mvpView;

    @Inject
    BaseFavoritePresenter(UsersRepository usersRepository, UserDomain.Mapper<UserItemUi> userItemUiMapper) {
        this.usersRepository = usersRepository;
        this.userItemUiMapper = userItemUiMapper;
    }

    @Override
    public void onAttach(FavoriteView mvpView) {
        this.mvpView = mvpView;
        startObserve();
    }

    @Override
    public void onDetach() {
        compositeDisposable.dispose();
        mvpView = null;
    }

    @Override
    public void changeFavorite(Integer userId) {
        compositeDisposable.add(usersRepository.changeUserFavorite(userId)
                .andThen(usersRepository.clearTempData())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe());
    }

    @Override
    public void clearTempData() {
        compositeDisposable.add(usersRepository.clearTempData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe());
    }

    private void startObserve() {
        compositeDisposable.add(usersRepository.favoriteUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(items -> {
                    Log.d("BaseUsersPresenter", "items size: " + items.size());
                    showItems(items);
                }, error -> {
                    Log.d("BaseUsersPresenter", "error: " + error.getMessage());
                }));
    }

    private void showItems(List<UserDomain> items) {
        mvpView.showFavoriteList(UserDomain.mapList(items, userItemUiMapper));
    }
}
