package com.alex44.glukhovfitnesskittest.model.room

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class LessonRoom (
    var name : String? = null,
    var description : String? = null,
    var place : String? = null,
    var teacher : String? = null,
    var startTime : String? = null,
    var endTime : String? = null,
    var weekDay : Int? = null,
    @NonNull
    @PrimaryKey
    var appointmentId : String,
    var serviceId : String? = null,
    var pay : Boolean? = null,
    var appointment : Boolean? = null,
    var teacherFullName : String? = null,
    var color : String? = null,
    var availability : Int? = null
) : Serializable