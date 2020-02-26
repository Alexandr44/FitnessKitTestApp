package com.alex44.glukhovfitnesskittest.presenters

import com.alex44.glukhovfitnesskittest.common.navigation.Screens
import com.alex44.glukhovfitnesskittest.model.dto.DayDTO
import com.alex44.glukhovfitnesskittest.model.dto.LessonDTO
import com.alex44.glukhovfitnesskittest.model.repo.IDataRepo
import com.alex44.glukhovfitnesskittest.views.DayView
import com.alex44.glukhovfitnesskittest.views.HomeView
import com.alex44.glukhovfitnesskittest.views.LessonView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class HomePresenter(private val mainThreadScheduler : Scheduler) : MvpPresenter<HomeView>() {

    @Inject
    lateinit var repo : IDataRepo

    @Inject
    lateinit var router: Router

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

    fun bind(lessonHolder: LessonView, dayIndex : Int) {
        if (dayIndex < 0 || dayIndex > days.size-1) return
        if (lessonHolder.getItemPosition() < 0 || lessonHolder.getItemPosition() > days[dayIndex].lessons.size-1) return
        val lesson = days[dayIndex].lessons[lessonHolder.getItemPosition()]
        lesson.apply {
            lessonHolder.setLessonName(name.orEmpty())
            lessonHolder.setDescription(description.orEmpty())
            lessonHolder.setPlace(place.orEmpty())
            lessonHolder.setTeacherName(teacher.orEmpty())
            lessonHolder.setStartTime(startTime.orEmpty())
            lessonHolder.setEndTime(endTime.orEmpty())
            lessonHolder.setColor(color?:"#FFF")
        }

    }

    fun teacherInfoClicked(dayIndex: Int, position: Int) {
        if (dayIndex < 0 || dayIndex > days.size-1) return
        if (position < 0 || position > days[dayIndex].lessons.size-1) return
        days[dayIndex].lessons[position].teacherInfo?.apply {
            router.navigateTo(Screens.TeacherScreen(this))
        }
    }

}