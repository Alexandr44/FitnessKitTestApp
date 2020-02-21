package com.alex44.glukhovfitnesskittest.model.cache

import com.alex44.glukhovfitnesskittest.model.dto.LessonDTO

interface IDataCache {

    fun getData() : List<LessonDTO>

    fun putData(list : List<LessonDTO>)

}