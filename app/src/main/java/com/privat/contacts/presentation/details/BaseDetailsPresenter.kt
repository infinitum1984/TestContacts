package com.privat.contacts.presentation.details

import android.util.Log
import com.privat.contacts.domain.UsersRepository
import com.privat.contacts.domain.model.UserDomain
import com.privat.contacts.presentation.details.model.UserDetailsParamUi
import com.privat.contacts.presentation.details.model.UserDetailsUi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BaseDetailsPresenter @Inject constructor(private val usersRepository: UsersRepository, private val userDetailsUiMapper: UserDomain.Mapper<UserDetailsUi>, private val userDetailsParamUiMapper: UserDomain.Mapper<List<UserDetailsParamUi>>) : DetailsPresenter {
    private val compositeDisposable = CompositeDisposable()
    private var mvpView: DetailsView? = null
    override fun onAttach(mvpView: DetailsView) {
        this.mvpView = mvpView
        startObserve()
    }

    private fun startObserve() {
        compositeDisposable.add(usersRepository.getUserById(mvpView!!.userId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ user: UserDomain? -> showUserDetails(user!!.map(userDetailsUiMapper), user.map<List<UserDetailsParamUi>>(userDetailsParamUiMapper)) }) { error: Throwable -> Log.d("BaseUsersPresenter", "error: " + error.message) })
    }

    private fun showUserDetails(userDetailsUi: UserDetailsUi, userDetailsParamUiList: List<UserDetailsParamUi>) {
        mvpView!!.showUser(userDetailsUi)
        mvpView!!.showUserParams(userDetailsParamUiList)
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        mvpView = null
    }

    override fun changeFavorite() {
        compositeDisposable.add(usersRepository.changeUserFavorite(mvpView!!.userId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}) { error: Throwable -> Log.d("BaseUsersPresenter", "error: " + error.message) })
    }
}
