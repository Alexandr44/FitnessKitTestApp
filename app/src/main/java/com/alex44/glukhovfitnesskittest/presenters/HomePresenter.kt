package com.alex44.glukhovfitnesskittest.presenters

import com.alex44.glukhovfitnesskittest.views.HomeView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class HomePresenter : MvpPresenter<HomeView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        init()
    }

    private fun init() {
        viewState.initRV()
    }

}