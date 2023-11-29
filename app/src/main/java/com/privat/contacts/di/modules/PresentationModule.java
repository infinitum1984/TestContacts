package com.privat.contacts.di.modules;

import com.privat.contacts.presentation.MainActivity;
import com.privat.contacts.presentation.details.DetailsFragment;
import com.privat.contacts.presentation.favorite.BaseFavoritePresenter;
import com.privat.contacts.presentation.favorite.FavoriteFragment;
import com.privat.contacts.presentation.favorite.FavoritePresenter;
import com.privat.contacts.presentation.host.BottomNavigationHostFragment;
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
    @Binds
    FavoritePresenter bindFavoritePresenter(BaseFavoritePresenter usersPresenter);
    @ContributesAndroidInjector
    MainActivity mainActivity();
    @ContributesAndroidInjector
    UsersFragment usersFragment();
    @ContributesAndroidInjector
    FavoriteFragment favoriteFragment();
    @ContributesAndroidInjector
    BottomNavigationHostFragment hostFragment();
    @ContributesAndroidInjector
    DetailsFragment detailsFragment();
}
