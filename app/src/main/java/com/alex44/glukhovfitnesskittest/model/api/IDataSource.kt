package com.alex44.glukhovfitnesskittest.model.api

import com.alex44.glukhovfitnesskittest.model.dto.LessonDTO
import io.reactivex.Maybe
import retrofit2.http.GET

interface IDataSource {

    @GET("schedule/get_group_lessons_v2/1/")
    fun getData() : Maybe<List<LessonDTO>>

}