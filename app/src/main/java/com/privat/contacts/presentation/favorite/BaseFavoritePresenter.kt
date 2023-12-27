package com.privat.contacts.presentation.favorite

import android.util.Log
import com.privat.contacts.domain.UsersRepository
import com.privat.contacts.domain.model.UserDomain
import com.privat.contacts.presentation.users.model.UserItemUi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BaseFavoritePresenter @Inject internal constructor(private val usersRepository: UsersRepository, private val userItemUiMapper: UserDomain.Mapper<UserItemUi>) : FavoritePresenter {
    private val compositeDisposable = CompositeDisposable()
    private var mvpView: FavoriteView? = null
    override fun onAttach(mvpView: FavoriteView) {
        this.mvpView = mvpView
        startObserve()
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        mvpView = null
    }

    override fun changeFavorite(userId: Int) {
        compositeDisposable.add(usersRepository.changeUserFavorite(userId)
                .andThen(usersRepository.clearTempData())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe())
    }

    override fun clearTempData() {
        compositeDisposable.add(usersRepository.clearTempData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe())
    }

    private fun startObserve() {
        compositeDisposable.add(usersRepository.favoriteUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ items: List<UserDomain> ->
                    Log.d("BaseUsersPresenter", "items size: " + items.size)
                    showItems(items)
                }) { error: Throwable -> Log.d("BaseUsersPresenter", "error: " + error.message) })
    }

    private fun showItems(items: List<UserDomain>) {
        mvpView!!.showFavoriteList(UserDomain.Companion.mapList<UserItemUi>(items, userItemUiMapper))
    }
}
