package com.alex44.glukhovfitnesskittest.common.navigation

import androidx.fragment.app.Fragment
import com.alex44.glukhovfitnesskittest.model.dto.TeacherDTO
import com.alex44.glukhovfitnesskittest.ui.fragments.HomeFragment
import com.alex44.glukhovfitnesskittest.ui.fragments.TeacherFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class HomeScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = HomeFragment.newInstance()
    }

    class TeacherScreen(private val teacherDTO: TeacherDTO) : SupportAppScreen() {
        override fun getFragment(): Fragment = TeacherFragment.newInstance(teacherDTO)
    }

}