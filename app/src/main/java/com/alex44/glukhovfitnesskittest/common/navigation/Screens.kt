package com.alex44.glukhovfitnesskittest.common.navigation

import androidx.fragment.app.Fragment
import com.alex44.glukhovfitnesskittest.ui.fragments.HomeFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class HomeScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = HomeFragment.newInstance()
    }

}