package com.alex44.glukhovfitnesskittest.views

interface LessonView {

    fun setLessonName(name: String)

    fun setDescription(description: String)

    fun setTeacherName(name: String)

    fun setPlace(place: String)

    fun setStartTime(startTime: String)

    fun setEndTime(endTime: String)

    fun setColor(color : String)

    fun getItemPosition(): Int

}