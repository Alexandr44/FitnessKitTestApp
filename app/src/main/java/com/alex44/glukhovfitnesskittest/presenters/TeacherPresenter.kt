package com.alex44.glukhovfitnesskittest.presenters

import com.alex44.glukhovfitnesskittest.common.navigation.Screens
import com.alex44.glukhovfitnesskittest.model.dto.TeacherDTO
import com.alex44.glukhovfitnesskittest.views.TeacherView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class TeacherPresenter(private val teacherDTO: TeacherDTO?) : MvpPresenter<TeacherView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        init()
    }

    private fun init() {
        if (teacherDTO == null) {
            viewState.showMessage("Teacher info unavailable")
            backClicked()
        }
        viewState.setImage(teacherDTO?.imageUrl.orEmpty())
        viewState.setFio(teacherDTO?.fullName.orEmpty())
        viewState.setPosition(teacherDTO?.position.orEmpty())
    }

    fun backClicked() : Boolean {
        router.backTo(Screens.HomeScreen())
        return true
    }

}