package com.alex44.glukhovfitnesskittest.model.repo

import com.alex44.glukhovfitnesskittest.model.dto.LessonDTO
import io.reactivex.Maybe

interface IDataRepo {

    fun getData() : Maybe<List<LessonDTO>>

}