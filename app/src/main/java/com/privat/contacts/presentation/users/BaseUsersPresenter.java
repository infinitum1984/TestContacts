package com.privat.contacts.presentation.users;

import android.util.Log;

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

    @Override
    public void startObserve() {
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

    private void showItems(List<UserDomain> items) {
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
}
