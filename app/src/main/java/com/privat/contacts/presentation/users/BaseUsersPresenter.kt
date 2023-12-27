package com.privat.contacts.presentation.users

import android.util.Log
import com.privat.contacts.domain.UsersRepository
import com.privat.contacts.domain.model.UserDomain
import com.privat.contacts.presentation.users.model.UserItemUi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BaseUsersPresenter @Inject internal constructor(private val usersRepository: UsersRepository, private val userItemUiMapper: UserDomain.Mapper<UserItemUi>) : UsersPresenter {
    private val compositeDisposable = CompositeDisposable()
    private var mvpView: UsersView? = null
    override fun onAttach(mvpView: UsersView) {
        this.mvpView = mvpView
        startObserve()
    }

    private fun startObserve() {
        compositeDisposable.add(usersRepository.networkUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ items: List<UserDomain> ->
                    Log.d("BaseUsersPresenter", "items size: " + items.size)
                    showItems(items)
                }) { error: Throwable -> Log.d("BaseUsersPresenter", "error: " + error.message) })
    }

    private fun showItems(items: List<UserDomain>) {
        mvpView!!.showUsers(UserDomain.Companion.mapList<UserItemUi>(items, userItemUiMapper))
    }

    override fun onDetach() {
        mvpView = null
        compositeDisposable.dispose()
    }

    override fun fetchNewUser() {
        compositeDisposable.add(usersRepository.fetchNewUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ }) { error: Throwable -> Log.d("BaseUsersPresenter", ": " + error.message) })
    }

    override fun openUser(userId: Int) {
        compositeDisposable.add(usersRepository.saveUser(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ mvpView!!.navigateToUser(userId) }) { error: Throwable -> Log.d("BaseUsersPresenter", ": " + error.message) })
    }

    override fun clearTempData() {
        compositeDisposable.add(usersRepository.clearTempData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}) { error: Throwable -> Log.d("BaseUsersPresenter", ": " + error.message) })
    }
}
