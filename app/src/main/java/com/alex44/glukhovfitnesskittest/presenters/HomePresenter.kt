package com.alex44.glukhovfitnesskittest.presenters

import com.alex44.glukhovfitnesskittest.model.dto.LessonDTO
import com.alex44.glukhovfitnesskittest.model.repo.IDataRepo
import com.alex44.glukhovfitnesskittest.views.HomeView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@InjectViewState
class HomePresenter(private val mainThreadScheduler : Scheduler) : MvpPresenter<HomeView>() {

    @Inject
    lateinit var repo : IDataRepo

    var disposable : Disposable? = null

    lateinit var data : List<LessonDTO>

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        init()
        getData()
    }

    private fun init() {
        viewState.initRV()
    }

    private fun getData() {
        disposable = repo.getData()
            .observeOn(mainThreadScheduler)
            .subscribe({ list ->
                data = list
                viewState.updateRV()
            }, { t ->
                t?.message?.let {
                    viewState.showMessage(it)
                }
            })
    }

}