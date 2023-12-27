package com.privat.contacts.di.modules;

import com.privat.contacts.presentation.MainActivity;
import com.privat.contacts.presentation.details.BaseDetailsPresenter;
import com.privat.contacts.presentation.details.DetailsFragment;
import com.privat.contacts.presentation.details.DetailsPresenter;
import com.privat.contacts.presentation.favorite.BaseFavoritePresenter;
import com.privat.contacts.presentation.favorite.FavoriteFragment;
import com.privat.contacts.presentation.favorite.FavoritePresenter;
import com.privat.contacts.presentation.host.BottomNavigationHostFragment;
import com.privat.contacts.presentation.users.BaseUsersPresenter;
import com.privat.contacts.presentation.users.UsersFragment;
import com.privat.contacts.presentation.users.UsersPresenter;

import org.jetbrains.annotations.NotNull;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface PresentationModule {
    @NotNull
    @Binds
    UsersPresenter bindUsersPresenter(    @NotNull
                                          BaseUsersPresenter usersPresenter);
    @Binds
    FavoritePresenter bindFavoritePresenter(    @NotNull
                                                BaseFavoritePresenter usersPresenter);
    @Binds
    DetailsPresenter bindDetailsPresenter(    @NotNull
                                              BaseDetailsPresenter detailsPresenter);
    @NotNull

    @ContributesAndroidInjector
    MainActivity mainActivity();
    @NotNull
    @ContributesAndroidInjector
    UsersFragment usersFragment();
    @NotNull
    @ContributesAndroidInjector
    FavoriteFragment favoriteFragment();
    @NotNull
    @ContributesAndroidInjector
    BottomNavigationHostFragment hostFragment();
    @NotNull
    @ContributesAndroidInjector
    DetailsFragment detailsFragment();
}
