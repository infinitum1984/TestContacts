package com.privat.contacts.presentation.users;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.privat.contacts.domain.UsersRepository;
import com.privat.contacts.domain.model.UserDomain;
import com.privat.contacts.presentation.users.model.UserItemUi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class BaseUsersPresenter implements UsersPresenter {

    private final UsersRepository usersRepository;
    private final UserDomain.Mapper<UserItemUi> userItemUiMapper;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Nullable
    private UsersView mvpView;
    @Inject
    BaseUsersPresenter(UsersRepository usersRepository, UserDomain.Mapper<UserItemUi> userItemUiMapper) {
        this.usersRepository = usersRepository;
        this.userItemUiMapper = userItemUiMapper;
    }

    @Override
    public void onAttach(UsersView mvpView) {
        this.mvpView = mvpView;
        startObserve();
    }

    private void startObserve() {
        compositeDisposable.add(usersRepository.networkUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(items -> {
                    Log.d("BaseUsersPresenter", "items size: " + items.size());
                    showItems(items);
                }, error -> {
                    Log.d("BaseUsersPresenter", "error: " + error.getMessage());
                }));
    }

    private void showItems(@NonNull List<UserDomain> items) {
        mvpView.showUsers(UserDomain.mapList(items, userItemUiMapper));
    }

    @Override
    public void onDetach() {
        mvpView = null;
        compositeDisposable.dispose();
    }

    @Override
    public void fetchNewUser() {
        compositeDisposable.add(usersRepository.fetchNewUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {

                    }
                }, error -> {
                    Log.d("BaseUsersPresenter", ": " + error.getMessage());
                }));
    }

    @Override
    public void openUser(int userId) {
        compositeDisposable.add(usersRepository.saveUser(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(()->{
                    mvpView.navigateToUser(userId);
                }, error -> {
                    Log.d("BaseUsersPresenter", ": " + error.getMessage());
                }));
    }

    @Override
    public void clearTempData() {
        compositeDisposable.add(usersRepository.clearTempData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(()->{
                }, error -> {
                    Log.d("BaseUsersPresenter", ": " + error.getMessage());
                }));
    }
}
