package com.privat.contacts.ui.users;

import android.util.Log;

import com.privat.contacts.domain.UsersRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class BaseUsersPresenter implements UsersPresenter {
    private final UsersRepository usersRepository;

    @Inject
    BaseUsersPresenter(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void onAttach(UsersView mvpView) {

    }

    @Override
    public void onDetach() {

    }

    @Override
    public void fetchNewUser() {
        usersRepository.fetchNewUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {

                    }
                }, error -> {
                    Log.d("BaseUsersPresenter", ": " + error.getMessage());
                });

    }
}
