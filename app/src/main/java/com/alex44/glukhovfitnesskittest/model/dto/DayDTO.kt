package com.alex44.glukhovfitnesskittest.model.dto

import java.io.Serializable

data class DayDTO(
    var dayName : String,
    var weekDay : Int,
    var lessons : MutableList<LessonDTO>
) : Serializable