package com.alex44.glukhovfitnesskittest.model.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LessonDTO (
    @Expose @SerializedName("name") var name : String? = null,
    @Expose @SerializedName("description") var description : String? = null,
    @Expose @SerializedName("place") var place : String? = null,
    @Expose @SerializedName("teacher") var teacher : String? = null,
    @Expose @SerializedName("startTime") var startTime : String? = null,
    @Expose @SerializedName("endTime") var endTime : String? = null,
    @Expose @SerializedName("weekDay") var weekDay : Int? = null,
    @Expose @SerializedName("appointment_id") var appointmentId : String? = null,
    @Expose @SerializedName("service_id") var serviceId : String? = null,
    @Expose @SerializedName("pay") var pay : Boolean? = null,
    @Expose @SerializedName("appointment") var appointment : Boolean? = null,
    @Expose @SerializedName("teacher_v2") var teacherInfo : TeacherDTO? = null,
    @Expose @SerializedName("color") var color : String? = null,
    @Expose @SerializedName("availability") var availability : Int? = null
) : Serializable