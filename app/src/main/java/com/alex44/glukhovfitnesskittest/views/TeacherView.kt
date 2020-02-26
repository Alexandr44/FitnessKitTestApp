package com.alex44.glukhovfitnesskittest.views

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface TeacherView : BaseView {

    fun setImage(url : String)

    fun setFio(fio : String)

    fun setPosition(position : String)

}