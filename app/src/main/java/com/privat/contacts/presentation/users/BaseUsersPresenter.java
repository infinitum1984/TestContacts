package com.privat.contacts.presentation.users;

import android.util.Log;

import com.privat.contacts.base.presentation.base.BasePresenter;
import com.privat.contacts.domain.UsersRepository;
import com.privat.contacts.domain.model.UserDomain;
import com.privat.contacts.presentation.users.model.UserItemUi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BaseUsersPresenter extends BasePresenter<UsersView> implements UsersPresenter {
    private final UsersRepository usersRepository;
    private final UserDomain.Mapper<UserItemUi> userItemUiMapper;
    private Disposable listObserveDisposable = null;

    @Inject
    BaseUsersPresenter(UsersRepository usersRepository, UserDomain.Mapper<UserItemUi> userItemUiMapper) {
        this.usersRepository = usersRepository;
        this.userItemUiMapper = userItemUiMapper;
    }

    @Override
    public void onAttach(UsersView mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void startObserve() {
        listObserveDisposable = usersRepository.networkUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::showItems, error -> {
                    mvpView.showError(error);
                    Log.d("BaseUsersPresenter", "error: " + error.getMessage());
                });
        compositeDisposable.add(listObserveDisposable);
    }

    @Override
    public void stopObserve() {
        if (listObserveDisposable != null)
            listObserveDisposable.dispose();
    }

    private void showItems(List<UserDomain> items) {
        mvpView.showUsers(UserDomain.mapList(items, userItemUiMapper));
    }

    @Override
    public void fetchNewUser() {
        compositeDisposable.add(usersRepository.fetchNewUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                }, error -> {
                    mvpView.showError(error);
                    Log.d("BaseUsersPresenter", ": " + error.getMessage());
                }));
    }

    @Override
    public void openUser(int userId) {
        compositeDisposable.add(usersRepository.saveUser(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    mvpView.navigateToUser(userId);
                }, error -> {
                    mvpView.showError(error);
                    Log.d("BaseUsersPresenter", ": " + error.getMessage());
                }));
    }

    @Override
    public void clearTempData() {
        compositeDisposable.add(usersRepository.clearTempData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                }, error -> {
                    mvpView.showError(error);
                    Log.d("BaseUsersPresenter", ": " + error.getMessage());
                }));
    }
}