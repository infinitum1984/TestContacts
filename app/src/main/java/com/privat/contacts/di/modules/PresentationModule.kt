package com.privat.contacts.di.modules

import com.privat.contacts.presentation.MainActivity
import com.privat.contacts.presentation.details.BaseDetailsPresenter
import com.privat.contacts.presentation.details.DetailsFragment
import com.privat.contacts.presentation.details.DetailsPresenter
import com.privat.contacts.presentation.favorite.BaseFavoritePresenter
import com.privat.contacts.presentation.favorite.FavoriteFragment
import com.privat.contacts.presentation.favorite.FavoritePresenter
import com.privat.contacts.presentation.host.BottomNavigationHostFragment
import com.privat.contacts.presentation.users.BaseUsersPresenter
import com.privat.contacts.presentation.users.UsersFragment
import com.privat.contacts.presentation.users.UsersPresenter
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface PresentationModule {
    @Binds
    fun bindUsersPresenter(usersPresenter: BaseUsersPresenter): UsersPresenter

    @Binds
    fun bindFavoritePresenter(usersPresenter: BaseFavoritePresenter): FavoritePresenter

    @Binds
    fun bindDetailsPresenter(detailsPresenter: BaseDetailsPresenter): DetailsPresenter

    @ContributesAndroidInjector
    fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    fun usersFragment(): UsersFragment

    @ContributesAndroidInjector
    fun favoriteFragment(): FavoriteFragment

    @ContributesAndroidInjector
    fun hostFragment(): BottomNavigationHostFragment

    @ContributesAndroidInjector
    fun detailsFragment(): DetailsFragment
}
