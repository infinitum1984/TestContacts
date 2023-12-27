package com.privat.contacts.base.presentation

interface Presenter<V : MvpView> {
    fun onAttach(mvpView: V)
    fun onDetach()
}
