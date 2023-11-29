package com.privat.contacts.presentation.details;

import android.util.Log;

import com.privat.contacts.base.presentation.base.BasePresenter;
import com.privat.contacts.domain.UsersRepository;
import com.privat.contacts.domain.model.UserDomain;
import com.privat.contacts.presentation.details.model.UserDetailsParamUi;
import com.privat.contacts.presentation.details.model.UserDetailsUi;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BaseDetailsPresenter extends BasePresenter<DetailsView> implements DetailsPresenter {
    private final UsersRepository usersRepository;
    private final UserDomain.Mapper<UserDetailsUi> userDetailsUiMapper;
    private final UserDomain.Mapper<List<UserDetailsParamUi>> userDetailsParamUiMapper;
    @Inject
    public BaseDetailsPresenter(UsersRepository usersRepository, UserDomain.Mapper<UserDetailsUi> userDetailsUiMapper, UserDomain.Mapper<List<UserDetailsParamUi>> userDetailsParamUiMapper) {
        this.usersRepository = usersRepository;
        this.userDetailsUiMapper = userDetailsUiMapper;
        this.userDetailsParamUiMapper = userDetailsParamUiMapper;
    }
    @Override
    public void onAttach(DetailsView mvpView) {
        super.onAttach(mvpView);
        startObserve();
    }
    private void startObserve() {
        compositeDisposable.add(usersRepository.getUserById(mvpView.userId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> {
                    showUserDetails(user.map(userDetailsUiMapper), user.map(userDetailsParamUiMapper));
                }, error -> {
                    mvpView.showError(error);
                    Log.d("BaseDetailsPresenter", "error: " + error.getMessage());
                }));
    }
    private void showUserDetails(UserDetailsUi userDetailsUi, List<UserDetailsParamUi> userDetailsParamUiList) {
        mvpView.showUser(userDetailsUi);
        mvpView.showUserParams(userDetailsParamUiList);
    }
    @Override
    public void changeFavorite() {
        compositeDisposable.add(usersRepository.changeUserFavorite(mvpView.userId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                }, error -> {
                    mvpView.showError(error);
                    Log.d("BaseUsersPresenter", "error: " + error.getMessage());
                }));
    }
}