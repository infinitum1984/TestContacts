package com.privat.contacts.presentation.details;

import com.privat.contacts.base.presentation.MvpView;
import com.privat.contacts.presentation.details.model.UserDetailsParamUi;
import com.privat.contacts.presentation.details.model.UserDetailsUi;

import java.util.List;

public interface DetailsView extends MvpView {
    void showUser(UserDetailsUi userDetailsUi);
    void showUserParams(List<UserDetailsParamUi> userDetailsParamUiList);
    int userId();
}