package com.alex44.glukhovfitnesskittest.presenters

import com.alex44.glukhovfitnesskittest.model.dto.DayDTO
import com.alex44.glukhovfitnesskittest.model.dto.LessonDTO
import com.alex44.glukhovfitnesskittest.model.repo.IDataRepo
import com.alex44.glukhovfitnesskittest.views.DayView
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
    var days = prepareDays()

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
                list.forEach { lesson ->
                    lesson.weekDay?.let {
                        days[it-1].lessons.add(lesson)
                    }
                }
                data = list
                viewState.updateRV()
            }, { t ->
                t?.message?.let {
                    viewState.showMessage(it)
                }
            })
    }

    private fun prepareDays() : List<DayDTO> {
        val days = ArrayList<DayDTO>()
        days.add(DayDTO("Понедельник", 1, mutableListOf()))
        days.add(DayDTO("Вторник", 2, mutableListOf()))
        days.add(DayDTO("Среда", 3, mutableListOf()))
        days.add(DayDTO("Четверг", 4, mutableListOf()))
        days.add(DayDTO("Пятница", 5, mutableListOf()))
        days.add(DayDTO("Суббота", 6, mutableListOf()))
        days.add(DayDTO("Воскресенье", 7, mutableListOf()))
        return days
    }

    fun bind(dayHolder: DayView) {
        if (dayHolder.getItemPosition() < 0 || dayHolder.getItemPosition() > days.size-1) return
        val day = days[dayHolder.getItemPosition()]
        dayHolder.setDayName(day.dayName)
    }

}