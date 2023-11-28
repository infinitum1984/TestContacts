package com.privat.contacts.di.modules;

import com.privat.contacts.MainActivity;
import com.privat.contacts.presentation.users.BaseUsersPresenter;
import com.privat.contacts.presentation.users.UsersFragment;
import com.privat.contacts.presentation.users.UsersPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface PresentationModule {
    @Binds
    UsersPresenter bindUsersPresenter(BaseUsersPresenter usersPresenter);

    @ContributesAndroidInjector
    MainActivity mainActivity();

    @ContributesAndroidInjector
    UsersFragment usersFragment();
}
